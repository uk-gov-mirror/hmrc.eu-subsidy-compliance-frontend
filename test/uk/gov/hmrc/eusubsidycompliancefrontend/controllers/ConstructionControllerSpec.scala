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

class ConstructionControllerSpec
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

  private val controller = instanceOf[ConstructionController]
  private val navigator = instanceOf[Navigator]

  "ComputersElectronicsController" should {

    "loadConstructionLvl2Page" should {
      "return OK and render the ConstructionLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadConstructionLvl2Page("test")(
          FakeRequest(GET, routes.ConstructionController.loadConstructionLvl2Page("test").url)
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

    "submitConstructionLvl2Page" should {
      "redirect on valid form submission ConstructionLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitConstructionLvl2Page("test")(
          FakeRequest(POST, routes.ConstructionController.submitConstructionLvl2Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadCivilEngineeringLvl3Page" should {
      "return OK and render the CivilEngineeringLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadCivilEngineeringLvl3Page("test")(
          FakeRequest(GET, routes.ConstructionController.loadCivilEngineeringLvl3Page("test").url)
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

    "submitCivilEngineeringLvl3Page" should {
      "redirect on valid form submission CivilEngineeringLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitCivilEngineeringLvl3Page("test")(
          FakeRequest(POST, routes.ConstructionController.submitCivilEngineeringLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadSpecialisedConstructionLvl3Page" should {
      "return OK and render the SpecialisedConstructionLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadSpecialisedConstructionLvl3Page("test")(
          FakeRequest(GET, routes.ConstructionController.loadSpecialisedConstructionLvl3Page("test").url)
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

    "submitSpecialisedConstructionLvl3Page" should {
      "redirect on valid form submission SpecialisedConstructionLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitSpecialisedConstructionLvl3Page("test")(
          FakeRequest(POST, routes.ConstructionController.submitSpecialisedConstructionLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadBuildingCompletionLvl4Page" should {
      "return OK and render the BuildingCompletionLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadBuildingCompletionLvl4Page("test")(
          FakeRequest(GET, routes.ConstructionController.loadBuildingCompletionLvl4Page("test").url)
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

    "submitBuildingCompletionLvl4Page" should {
      "redirect on valid form submission BuildingCompletionLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitBuildingCompletionLvl4Page("test")(
          FakeRequest(POST, routes.ConstructionController.submitBuildingCompletionLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadConstructionRoadsRailwaysLvl4Page" should {
      "return OK and render the ConstructionRoadsRailwaysLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadConstructionRoadsRailwaysLvl4Page("test")(
          FakeRequest(GET, routes.ConstructionController.loadConstructionRoadsRailwaysLvl4Page("test").url)
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

    "submitConstructionRoadsRailwaysLvl4Page" should {
      "redirect on valid form submission ConstructionRoadsRailwaysLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitConstructionRoadsRailwaysLvl4Page("test")(
          FakeRequest(POST, routes.ConstructionController.submitConstructionRoadsRailwaysLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadConstructionUtilityProjectsLvl4Page" should {
      "return OK and render the ConstructionUtilityProjectsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadConstructionUtilityProjectsLvl4Page("test")(
          FakeRequest(GET, routes.ConstructionController.loadConstructionUtilityProjectsLvl4Page("test").url)
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

    "submitConstructionUtilityProjectsLvl4Page" should {
      "redirect on valid form submission ConstructionUtilityProjectsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitConstructionUtilityProjectsLvl4Page("test")(
          FakeRequest(POST, routes.ConstructionController.submitConstructionUtilityProjectsLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadDemolitionSitePreparationLvl4Page" should {
      "return OK and render the DemolitionSitePreparationLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadDemolitionSitePreparationLvl4Page("test")(
          FakeRequest(GET, routes.ConstructionController.loadDemolitionSitePreparationLvl4Page("test").url)
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

    "submitDemolitionSitePreparationLvl4Page" should {
      "redirect on valid form submission DemolitionSitePreparationLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitDemolitionSitePreparationLvl4Page("test")(
          FakeRequest(POST, routes.ConstructionController.submitDemolitionSitePreparationLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadElectricalPlumbingConstructionLvl4Page" should {
      "return OK and render the ElectricalPlumbingConstructionLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadElectricalPlumbingConstructionLvl4Page("test")(
          FakeRequest(GET, routes.ConstructionController.loadElectricalPlumbingConstructionLvl4Page("test").url)
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

    "submitElectricalPlumbingConstructionLvl4Page" should {
      "redirect on valid form submission ElectricalPlumbingConstructionLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitElectricalPlumbingConstructionLvl4Page("test")(
          FakeRequest(POST, routes.ConstructionController.submitElectricalPlumbingConstructionLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOtherCivilEngineeringProjectsLvl4Page" should {
      "return OK and render the OtherCivilEngineeringProjectsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherCivilEngineeringProjectsLvl4Page("test")(
          FakeRequest(GET, routes.ConstructionController.loadOtherCivilEngineeringProjectsLvl4Page("test").url)
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

    "submitOtherCivilEngineeringProjectsLvl4Page" should {
      "redirect on valid form submission OtherCivilEngineeringProjectsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherCivilEngineeringProjectsLvl4Page("test")(
          FakeRequest(POST, routes.ConstructionController.submitOtherCivilEngineeringProjectsLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOtherSpecialisedConstructionLvl4Page" should {
      "return OK and render the OtherSpecialisedConstructionLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherSpecialisedConstructionLvl4Page("test")(
          FakeRequest(GET, routes.ConstructionController.loadOtherSpecialisedConstructionLvl4Page("test").url)
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

    "submitOtherSpecialisedConstructionLvl4Page" should {
      "redirect on valid form submission OtherSpecialisedConstructionLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherSpecialisedConstructionLvl4Page("test")(
          FakeRequest(POST, routes.ConstructionController.submitOtherSpecialisedConstructionLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadSpecialisedConstructionActivitiesLvl4Page" should {
      "return OK and render the SpecialisedConstructionActivitiesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadSpecialisedConstructionActivitiesLvl4Page("test")(
          FakeRequest(GET, routes.ConstructionController.loadSpecialisedConstructionActivitiesLvl4Page("test").url)
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

    "submitSpecialisedConstructionActivitiesLvl4Page" should {
      "redirect on valid form submission SpecialisedConstructionActivitiesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitSpecialisedConstructionActivitiesLvl4Page("test")(
          FakeRequest(POST, routes.ConstructionController.submitSpecialisedConstructionActivitiesLvl4Page("test").url)
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
