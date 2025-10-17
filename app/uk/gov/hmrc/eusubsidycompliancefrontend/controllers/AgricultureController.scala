/*
 * Copyright 2025 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.eusubsidycompliancefrontend.controllers

import org.apache.pekko.util.Helpers.{Requiring, compareIdentityHash}
import play.api.data.Form
import play.api.i18n.MessagesApi
import play.api.mvc.{Action, AnyContent, MessagesControllerComponents}
import play.twirl.api.Html
import uk.gov.hmrc.eusubsidycompliancefrontend.actions.ActionBuilders
import uk.gov.hmrc.eusubsidycompliancefrontend.config.AppConfig
import uk.gov.hmrc.eusubsidycompliancefrontend.forms.FormHelpers.formWithSingleMandatoryField
import uk.gov.hmrc.eusubsidycompliancefrontend.journeys.{EligibilityJourney, UndertakingJourney}
import uk.gov.hmrc.eusubsidycompliancefrontend.models.FormValues
import uk.gov.hmrc.eusubsidycompliancefrontend.models.types.{EORI, Sector}
import uk.gov.hmrc.eusubsidycompliancefrontend.navigation.Navigator
import uk.gov.hmrc.eusubsidycompliancefrontend.persistence.Store
import uk.gov.hmrc.eusubsidycompliancefrontend.syntax.FutureSyntax.FutureOps
import uk.gov.hmrc.eusubsidycompliancefrontend.views.html.nace.agriculture._
import uk.gov.hmrc.eusubsidycompliancefrontend.views.html.nace.forestry._
import uk.gov.hmrc.eusubsidycompliancefrontend.views.html.nace.fishing._

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

class AgricultureController @Inject() (
                                        mcc: MessagesControllerComponents,
                                        actionBuilders: ActionBuilders,
                                        val store: Store,
                                        navigator: Navigator,
                                        AgricultureLvl3Page: AgricultureLvl3Page,
                                        AnimalProductionLvl4Page: AnimalProductionLvl4Page,
                                        NonPerennialCropLvl4Page: NonPerennialCropLvl4Page,
                                        PerennialCropLvl4Page: PerennialCropLvl4Page,
                                        SupportActivitiesLvl4Page: SupportActivitiesLvl4Page,
                                        ForestryLvl3Page: ForestryLvl3Page,
                                        FishingAndAquacultureLvl3Page: FishingAndAquacultureLvl3Page,
                                        AquacultureLvl4Page: AquacultureLvl4Page,
                                        FishingLvl4Page: FishingLvl4Page
                                      )(implicit
                                        val appConfig: AppConfig,
                                        val executionContext: ExecutionContext
                                      ) extends BaseController(mcc){

  import actionBuilders._
  override val messagesApi: MessagesApi = mcc.messagesApi

  private val SupportActivitiesLvl4Form: Form[FormValues] = formWithSingleMandatoryField("agriSupport4")
  private val PerennialCropLvl4Form: Form[FormValues] = formWithSingleMandatoryField("pCrops4")
  private val NonPerennialCropLvl4Form: Form[FormValues] = formWithSingleMandatoryField("nonPCrops4")
  private val AnimalProductionLvl4Form: Form[FormValues] = formWithSingleMandatoryField("animal4")
  private val AgricultureLvl3Form: Form[FormValues] = formWithSingleMandatoryField("agriculture3")
  private val ForestryLvl3Form: Form[FormValues] = formWithSingleMandatoryField("forestry3")
  private val FishingAndAquacultureLvl3Form: Form[FormValues] = formWithSingleMandatoryField("fishing3")
  private val AquacultureLvl4Form: Form[FormValues] = formWithSingleMandatoryField("aquaculture4")
  private val FishingLvl4Form: Form[FormValues] = formWithSingleMandatoryField("fishing4")

  def loadAgricultureLvl3Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
      val previousCode = journey.sector.value.map(_.toString).getOrElse("")
      val previousLevel3 = if (previousCode.length >= 4) previousCode.take(4) else previousCode

      val form = if (previousLevel3.isEmpty) AgricultureLvl3Form
      else AgricultureLvl3Form.fill(FormValues(previousLevel3))

      Ok(AgricultureLvl3Page(form, journey.mode)).toFuture
    }
  }

  def submitAgricultureLvl3Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    AgricultureLvl3Form
      .bindFromRequest()
      .fold(
        formWithErrors => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            BadRequest(AgricultureLvl3Page(formWithErrors, journey.mode)).toFuture
          }
        },
        form => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            val previousCode = journey.sector.value.map(_.toString).getOrElse("")
            val previousLevel3 = if (previousCode.length >= 4) previousCode.take(4) else previousCode
            val previousLevel4 = previousCode

            if (previousLevel3 == form.value && journey.mode == "NewRegChangeMode") {
              Redirect(routes.NACECheckDetailsController.getCheckDetails(previousLevel4)).toFuture
            } else {
              store.update[UndertakingJourney](_.copy(mode = "NewRegMode")).flatMap { _ =>
                Redirect(navigator.nextPage(form.value, "NewRegMode")).toFuture
              }
            }
          }
        }
      )
  }

  def loadSupportActivitiesLvl4Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
      val previousCode = journey.sector.value.map(_.toString).getOrElse("")
      val form = if (previousCode.isEmpty) SupportActivitiesLvl4Form
      else SupportActivitiesLvl4Form.fill(FormValues(previousCode))
      Ok(SupportActivitiesLvl4Page(form, journey.mode)).toFuture
    }
  }

  def submitSupportActivitiesLvl4Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    SupportActivitiesLvl4Form
      .bindFromRequest()
      .fold(
        formWithErrors => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            BadRequest(SupportActivitiesLvl4Page(formWithErrors, journey.mode)).toFuture
          }
        },
        form => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            val previousCode = journey.sector.value.map(_.toString).getOrElse("")

            if (previousCode == form.value && journey.mode == "NewRegChangeMode") {
              Redirect(routes.NACECheckDetailsController.getCheckDetails(form.value)).toFuture
            } else {
              for {
                _ <- store.update[UndertakingJourney](_.setUndertakingSector(Sector.withName(form.value).id))
                _ <- store.update[UndertakingJourney](_.copy(mode = "NewRegMode"))
              } yield Redirect(routes.NACECheckDetailsController.getCheckDetails(form.value))
            }
          }
        }
      )
  }

  def loadAnimalProductionLvl4Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
      val previousCode = journey.sector.value.map(_.toString).getOrElse("")
      val form = if (previousCode.isEmpty) AnimalProductionLvl4Form
      else AnimalProductionLvl4Form.fill(FormValues(previousCode))
      Ok(AnimalProductionLvl4Page(form, journey.mode)).toFuture
    }
  }

  def submitAnimalProductionLvl4Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    AnimalProductionLvl4Form
      .bindFromRequest()
      .fold(
        formWithErrors => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            BadRequest(AnimalProductionLvl4Page(formWithErrors, journey.mode)).toFuture
          }
        },
        form => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            val previousCode = journey.sector.value.map(_.toString).getOrElse("")

            if (previousCode == form.value && journey.mode == "NewRegChangeMode") {
              Redirect(routes.NACECheckDetailsController.getCheckDetails(form.value)).toFuture
            } else {
              for {
                _ <- store.update[UndertakingJourney](_.setUndertakingSector(Sector.withName(form.value).id))
                _ <- store.update[UndertakingJourney](_.copy(mode = "NewRegMode"))
              } yield Redirect(routes.NACECheckDetailsController.getCheckDetails(form.value))
            }
          }
        }
      )
  }

  def loadPerennialCropLvl4Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
      val previousCode = journey.sector.value.map(_.toString).getOrElse("")
      val form = if (previousCode.isEmpty) PerennialCropLvl4Form
      else PerennialCropLvl4Form.fill(FormValues(previousCode))
      Ok(PerennialCropLvl4Page(form, journey.mode)).toFuture
    }
  }

  def submitPerennialCropLvl4Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    PerennialCropLvl4Form
      .bindFromRequest()
      .fold(
        formWithErrors => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            BadRequest(PerennialCropLvl4Page(formWithErrors, journey.mode)).toFuture
          }
        },
        form => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            val previousCode = journey.sector.value.map(_.toString).getOrElse("")

            if (previousCode == form.value && journey.mode == "NewRegChangeMode") {
              Redirect(routes.NACECheckDetailsController.getCheckDetails(form.value)).toFuture
            } else {
              for {
                _ <- store.update[UndertakingJourney](_.setUndertakingSector(Sector.withName(form.value).id))
                _ <- store.update[UndertakingJourney](_.copy(mode = "NewRegMode"))
              } yield Redirect(routes.NACECheckDetailsController.getCheckDetails(form.value))
            }
          }
        }
      )
  }

  def loadNonPerennialCropLvl4Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
      val previousCode = journey.sector.value.map(_.toString).getOrElse("")
      val form = if (previousCode.isEmpty) NonPerennialCropLvl4Form
      else NonPerennialCropLvl4Form.fill(FormValues(previousCode))
      Ok(NonPerennialCropLvl4Page(form, journey.mode)).toFuture
    }
  }

  def submitNonPerennialCropLvl4Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    NonPerennialCropLvl4Form
      .bindFromRequest()
      .fold(
        formWithErrors => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            BadRequest(NonPerennialCropLvl4Page(formWithErrors, journey.mode)).toFuture
          }
        },
        form => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            val previousCode = journey.sector.value.map(_.toString).getOrElse("")

            if (previousCode == form.value && journey.mode == "NewRegChangeMode") {
              Redirect(routes.NACECheckDetailsController.getCheckDetails(form.value)).toFuture
            } else {
              for {
                _ <- store.update[UndertakingJourney](_.setUndertakingSector(Sector.withName(form.value).id))
                _ <- store.update[UndertakingJourney](_.copy(mode = "NewRegMode"))
              } yield Redirect(routes.NACECheckDetailsController.getCheckDetails(form.value))
            }
          }
        }
      )
  }

  def loadForestryLvl3Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
      val previousCode = journey.sector.value.map(_.toString).getOrElse("")
      val form = if (previousCode.isEmpty) ForestryLvl3Form
      else ForestryLvl3Form.fill(FormValues(previousCode))
      Ok(ForestryLvl3Page(form, journey.mode)).toFuture
    }
  }

  def submitForestryLvl3Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    ForestryLvl3Form
      .bindFromRequest()
      .fold(
        formWithErrors => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            BadRequest(ForestryLvl3Page(formWithErrors, journey.mode)).toFuture
          }
        },
        form => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            val previousCode = journey.sector.value.map(_.toString).getOrElse("")

            if (previousCode == form.value && journey.mode == "NewRegChangeMode") {
              Redirect(routes.NACECheckDetailsController.getCheckDetails(form.value)).toFuture
            } else {
              for {
                _ <- store.update[UndertakingJourney](_.setUndertakingSector(Sector.withName(form.value).id))
                _ <- store.update[UndertakingJourney](_.copy(mode = "NewRegMode"))
              } yield Redirect(routes.NACECheckDetailsController.getCheckDetails(form.value))
            }
          }
        }
      )
  }

  def loadFishingAndAquacultureLvl3Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
      val previousCode = journey.sector.value.map(_.toString).getOrElse("")
      val form = if (previousCode.isEmpty) FishingAndAquacultureLvl3Form
      else FishingAndAquacultureLvl3Form.fill(FormValues(previousCode))
      Ok(FishingAndAquacultureLvl3Page(form, journey.mode)).toFuture
    }
  }

  def submitFishingAndAquacultureLvl3Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    FishingAndAquacultureLvl3Form
      .bindFromRequest()
      .fold(
        formWithErrors => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            BadRequest(FishingAndAquacultureLvl3Page(formWithErrors, journey.mode)).toFuture
          }
        },
        form => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            val previousCode = journey.sector.value.map(_.toString).getOrElse("")
            val previousLevel3 = if (previousCode.length >= 4) previousCode.take(4) else previousCode
            val previousLevel4 = previousCode

            if (previousLevel3 == form.value && journey.mode == "NewRegChangeMode") {
              Redirect(routes.NACECheckDetailsController.getCheckDetails(previousLevel4)).toFuture
            } else {
              store.update[UndertakingJourney](_.copy(mode = "NewRegMode")).flatMap { _ =>
                Redirect(navigator.nextPage(form.value, "NewRegMode")).toFuture
              }
            }
          }
        }
      )
  }

  def loadAquacultureLvl4Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
      val previousCode = journey.sector.value.map(_.toString).getOrElse("")
      val form = if (previousCode.isEmpty) AquacultureLvl4Form
      else AquacultureLvl4Form.fill(FormValues(previousCode))
      Ok(AquacultureLvl4Page(form, journey.mode)).toFuture
    }
  }

  def submitAquacultureLvl4Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    AquacultureLvl4Form
      .bindFromRequest()
      .fold(
        formWithErrors => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            BadRequest(AquacultureLvl4Page(formWithErrors, journey.mode)).toFuture
          }
        },
        form => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            val previousCode = journey.sector.value.map(_.toString).getOrElse("")

            if (previousCode == form.value && journey.mode == "NewRegChangeMode") {
              Redirect(routes.NACECheckDetailsController.getCheckDetails(form.value)).toFuture
            } else {
              for {
                _ <- store.update[UndertakingJourney](_.setUndertakingSector(Sector.withName(form.value).id))
                _ <- store.update[UndertakingJourney](_.copy(mode = "NewRegMode"))
              } yield Redirect(routes.NACECheckDetailsController.getCheckDetails(form.value))
            }
          }
        }
      )
  }

  def loadFishingLvl4Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
      val previousCode = journey.sector.value.map(_.toString).getOrElse("")
      val form = if (previousCode.isEmpty) FishingLvl4Form
      else FishingLvl4Form.fill(FormValues(previousCode))
      Ok(FishingLvl4Page(form, journey.mode)).toFuture
    }
  }

  def submitFishingLvl4Page(): Action[AnyContent] = enrolled.async { implicit request =>
    implicit val eori: EORI = request.eoriNumber
    FishingLvl4Form
      .bindFromRequest()
      .fold(
        formWithErrors => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            BadRequest(FishingLvl4Page(formWithErrors, journey.mode)).toFuture
          }
        },
        form => {
          store.getOrCreate[UndertakingJourney](UndertakingJourney()).flatMap { journey =>
            val previousCode = journey.sector.value.map(_.toString).getOrElse("")

            if (previousCode == form.value && journey.mode == "NewRegChangeMode") {
              Redirect(routes.NACECheckDetailsController.getCheckDetails(form.value)).toFuture
            } else {
              for {
                _ <- store.update[UndertakingJourney](_.setUndertakingSector(Sector.withName(form.value).id))
                _ <- store.update[UndertakingJourney](_.copy(mode = "NewRegMode"))
              } yield Redirect(routes.NACECheckDetailsController.getCheckDetails(form.value))
            }
          }
        }
      )
  }
}