package uk.gov.hmrc.eusubsidycompliancefrontend.controllers

import org.jsoup.Jsoup
import org.scalatest.concurrent.{IntegrationPatience, ScalaFutures}
import org.scalatest.matchers.should.Matchers
import play.api.http.Status.{OK, SEE_OTHER}
import play.api.inject
import play.api.inject.guice.GuiceableModule
import play.api.test.FakeRequest
import play.api.test.Helpers.{GET, POST, contentAsString, defaultAwaitTimeout, redirectLocation, status}
import uk.gov.hmrc.auth.core.AuthConnector
import uk.gov.hmrc.eusubsidycompliancefrontend.models.types.Sector
import uk.gov.hmrc.eusubsidycompliancefrontend.navigation.Navigator
import uk.gov.hmrc.eusubsidycompliancefrontend.test.util.FakeTimeProvider
import uk.gov.hmrc.eusubsidycompliancefrontend.util.TimeProvider

class GeneralTradeGroupsControllerSpec
    extends ControllerSpec
    with AuthSupport
    with JourneyStoreSupport
    with AuthAndSessionDataBehaviour
    with Matchers
    with ScalaFutures
    with IntegrationPatience {
  private val fakeTimeProvider = FakeTimeProvider.withFixedDate(1, 1, 2022)

  override def overrideBindings: List[GuiceableModule] = List(
    inject.bind[AuthConnector].toInstance(mockAuthConnector),
    inject.bind[TimeProvider].toInstance(fakeTimeProvider)
  )

  private val controller = instanceOf[GeneralTradeGroupsController]
  private val navigator = instanceOf[Navigator]
  "GeneralTradeGroupsController" should {

    "loadGeneralTradeUndertakingPage" should {
      "return OK and render the GeneralTradeUndertakingPage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadGeneralTradeUndertakingPage("test")(
          FakeRequest(GET, routes.GeneralTradeGroupsController.loadGeneralTradeUndertakingPage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-accommodationAndFoodService")
          .text shouldBe "Accommodation"
      }
    }

    "submitGeneralTradeUndertakingPage" should {
      "redirect on valid form submission GeneralTradeUndertakingPage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitGeneralTradeUndertakingPage("test")(
          FakeRequest(POST, routes.GeneralTradeGroupsController.submitGeneralTradeUndertakingPage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadGeneralTradeUndertakingOtherPage" should {
      "return OK and render the GeneralTradeUndertakingOtherPage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadGeneralTradeUndertakingOtherPage("test")(
          FakeRequest(GET, routes.GeneralTradeGroupsController.loadGeneralTradeUndertakingOtherPage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-accommodationAndFoodService")
          .text shouldBe "Accommodation"
      }
    }

    "submitGeneralTradeUndertakingOtherPage" should {
      "redirect on valid form submission GeneralTradeUndertakingOtherPage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitGeneralTradeUndertakingOtherPage("test")(
          FakeRequest(POST, routes.GeneralTradeGroupsController.submitGeneralTradeUndertakingOtherPage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadLvl2_1GroupsPage" should {
      "return OK and render the Lvl2_1GroupsPage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadLvl2_1GroupsPage("test")(
          FakeRequest(GET, routes.GeneralTradeGroupsController.loadLvl2_1GroupsPage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-accommodationAndFoodService")
          .text shouldBe "Accommodation"
      }
    }

    "submitLvl2_1GroupsPage" should {
      "redirect on valid form submission Lvl2_1GroupsPage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitLvl2_1GroupsPage("test")(
          FakeRequest(POST, routes.GeneralTradeGroupsController.submitLvl2_1GroupsPage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadClothesTextilesHomewarePage" should {
      "return OK and render the ClothesTextilesHomewarePage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadClothesTextilesHomewarePage("test")(
          FakeRequest(GET, routes.GeneralTradeGroupsController.loadClothesTextilesHomewarePage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-accommodationAndFoodService")
          .text shouldBe "Accommodation"
      }
    }

    "submitClothesTextilesHomewarePage" should {
      "redirect on valid form submission ClothesTextilesHomewarePage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitClothesTextilesHomewarePage("test")(
          FakeRequest(POST, routes.GeneralTradeGroupsController.submitClothesTextilesHomewarePage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadComputersElectronicsMachineryPage" should {
      "return OK and render the ComputersElectronicsMachineryPage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadComputersElectronicsMachineryPage("test")(
          FakeRequest(GET, routes.GeneralTradeGroupsController.loadComputersElectronicsMachineryPage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-accommodationAndFoodService")
          .text shouldBe "Accommodation"
      }
    }

    "submitComputersElectronicsMachineryPage" should {
      "redirect on valid form submission ComputersElectronicsMachineryPage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitComputersElectronicsMachineryPage("test")(
          FakeRequest(POST, routes.GeneralTradeGroupsController.submitComputersElectronicsMachineryPage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadFoodBeveragesTobaccoPage" should {
      "return OK and render the FoodBeveragesTobaccoPage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadFoodBeveragesTobaccoPage("test")(
          FakeRequest(GET, routes.GeneralTradeGroupsController.loadFoodBeveragesTobaccoPage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-accommodationAndFoodService")
          .text shouldBe "Accommodation"
      }
    }

    "submitFoodBeveragesTobaccoPage" should {
      "redirect on valid form submission FoodBeveragesTobaccoPage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitFoodBeveragesTobaccoPage("test")(
          FakeRequest(POST, routes.GeneralTradeGroupsController.submitFoodBeveragesTobaccoPage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadMetalsChemicalsMaterialsPage" should {
      "return OK and render the MetalsChemicalsMaterialsPage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadMetalsChemicalsMaterialsPage("test")(
          FakeRequest(GET, routes.GeneralTradeGroupsController.loadMetalsChemicalsMaterialsPage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-accommodationAndFoodService")
          .text shouldBe "Accommodation"
      }
    }

    "submitMetalsChemicalsMaterialsPage" should {
      "redirect on valid form submission MetalsChemicalsMaterialsPage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitMetalsChemicalsMaterialsPage("test")(
          FakeRequest(POST, routes.GeneralTradeGroupsController.submitMetalsChemicalsMaterialsPage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadPaperPrintedProductsPage" should {
      "return OK and render the PaperPrintedProductsPage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadPaperPrintedProductsPage("test")(
          FakeRequest(GET, routes.GeneralTradeGroupsController.loadPaperPrintedProductsPage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-accommodationAndFoodService")
          .text shouldBe "Accommodation"
      }
    }

    "submitPaperPrintedProductsPage" should {
      "redirect on valid form submission PaperPrintedProductsPage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitPaperPrintedProductsPage("test")(
          FakeRequest(POST, routes.GeneralTradeGroupsController.submitPaperPrintedProductsPage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadVehiclesTransportPage" should {
      "return OK and render the VehiclesTransportPage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadVehiclesTransportPage("test")(
          FakeRequest(GET, routes.GeneralTradeGroupsController.loadVehiclesTransportPage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-accommodationAndFoodService")
          .text shouldBe "Accommodation"
      }
    }

    "submitVehiclesTransportPage" should {
      "redirect on valid form submission VehiclesTransportPage" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitVehiclesTransportPage("test")(
          FakeRequest(POST, routes.GeneralTradeGroupsController.submitVehiclesTransportPage("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

  }
}
