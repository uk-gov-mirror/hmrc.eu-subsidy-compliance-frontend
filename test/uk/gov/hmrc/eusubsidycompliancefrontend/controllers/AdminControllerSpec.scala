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

class AdminControllerSpec
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

  private val controller = instanceOf[AdminController]
  private val navigator = instanceOf[Navigator]
  "AdminController" should {
    "loadTravelLvl3Page" should {
      "return OK and render the TravelLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }

        def performAction() = controller.loadTravelLvl3Page("test")(
          FakeRequest(GET, routes.AdminController.loadTravelLvl3Page("tes").url)
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

    "submitTravelLvl3Page" should {
      "redirect on valid form submission TravelLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }

        def performAction() = controller.submitTravelLvl3Page("test")(
          FakeRequest(POST, routes.AdminController.submitTravelLvl3Page("test").url)
        )

        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadRentalLvl3Page" should {
      "return OK and render the RentalLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }

        def performAction() = controller.loadRentalLvl3Page("test")(
          FakeRequest(GET, routes.AdminController.loadRentalLvl3Page("tes").url)
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

    "submitRentalLvl3Page" should {
      "redirect on valid form submission RentalLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }

        def performAction() = controller.submitRentalLvl3Page("test")(
          FakeRequest(POST, routes.AdminController.submitRentalLvl3Page("test").url)
        )

        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadTravelAgencyLvl4Page" should {
      "return OK and render the TravelAgencyLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }

        def performAction() = controller.loadTravelAgencyLvl4Page("test")(
          FakeRequest(GET, routes.AdminController.loadTravelAgencyLvl4Page("tes").url)
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

    "submitTravelAgencyLvl4Page" should {
      "redirect on valid form submission TravelAgencyLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }

        def performAction() = controller.submitTravelAgencyLvl4Page("test")(
          FakeRequest(POST, routes.AdminController.submitTravelAgencyLvl4Page("test").url)
        )

        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadAdministrativeLvl2Page" should {
      "return OK and render the AdministrativeLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }

        def performAction() = controller.loadAdministrativeLvl2Page("test")(
          FakeRequest(GET, routes.AdminController.loadAdministrativeLvl2Page("tes").url)
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

    "submitAdministrativeLvl2Page" should {
      "redirect on valid form submission AdministrativeLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }

        def performAction() = controller.submitAdministrativeLvl2Page("test")(
          FakeRequest(POST, routes.AdminController.submitAdministrativeLvl2Page("test").url)
        )

        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadBuildingsLvl3Page" should {
      "return OK and render the BuildingsLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadBuildingsLvl3Page("test")(
          FakeRequest(GET, routes.AdminController.loadBuildingsLvl3Page("tes").url)
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

    "submitBuildingsLvl3Page" should {
      "redirect on valid form submission BuildingsLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitBuildingsLvl3Page("test")(
          FakeRequest(POST, routes.AdminController.submitBuildingsLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadCleaningLvl4Page" should {
      "return OK and render the CleaningLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadCleaningLvl4Page("test")(
          FakeRequest(GET, routes.AdminController.loadCleaningLvl4Page("tes").url)
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

    "submitCleaningLvl4Page" should {
      "redirect on valid form submission CleaningLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitCleaningLvl4Page("test")(
          FakeRequest(POST, routes.AdminController.submitCleaningLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadEmploymentLvl3Page" should {
      "return OK and render the EmploymentLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadEmploymentLvl3Page("test")(
          FakeRequest(GET, routes.AdminController.loadEmploymentLvl3Page("tes").url)
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

    "submitEmploymentLvl3Page" should {
      "redirect on valid form submission EmploymentLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitEmploymentLvl3Page("test")(
          FakeRequest(POST, routes.AdminController.submitEmploymentLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadIntermediationServicesLvl4Page" should {
      "return OK and render the IntermediationServicesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadIntermediationServicesLvl4Page("test")(
          FakeRequest(GET, routes.AdminController.loadIntermediationServicesLvl4Page("tes").url)
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

    "submitIntermediationServicesLvl4Page" should {
      "redirect on valid form submission IntermediationServicesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitIntermediationServicesLvl4Page("test")(
          FakeRequest(POST, routes.AdminController.submitIntermediationServicesLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadInvestigationLvl4Page" should {
      "return OK and render the InvestigationLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadInvestigationLvl4Page("test")(
          FakeRequest(GET, routes.AdminController.loadInvestigationLvl4Page("tes").url)
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

    "submitInvestigationLvl4Page" should {
      "redirect on valid form submission InvestigationLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitInvestigationLvl4Page("test")(
          FakeRequest(POST, routes.AdminController.submitInvestigationLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadMachineryEquipmentLvl4Page" should {
      "return OK and render the MachineryEquipmentLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadMachineryEquipmentLvl4Page("test")(
          FakeRequest(GET, routes.AdminController.loadMachineryEquipmentLvl4Page("tes").url)
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

    "loadMotorVehiclesLvl4Page" should {
      "redirect on valid form submission MotorVehiclesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadMotorVehiclesLvl4Page("test")(
          FakeRequest(POST, routes.AdminController.loadMotorVehiclesLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "submitMotorVehiclesLvl4Page" should {
      "redirect on valid form submission MotorVehiclesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitMotorVehiclesLvl4Page("test")(
          FakeRequest(POST, routes.AdminController.submitMotorVehiclesLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOfficeLvl3Page" should {
      "redirect on valid form submission OfficeLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOfficeLvl3Page("test")(
          FakeRequest(POST, routes.AdminController.loadOfficeLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "submitOfficeLvl3Page" should {
      "redirect on valid form submission OfficeLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOfficeLvl3Page("test")(
          FakeRequest(POST, routes.AdminController.submitOfficeLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOtherBusinessSupportLvl4Page" should {
      "redirect on valid form submission OtherBusinessSupportLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherBusinessSupportLvl4Page("test")(
          FakeRequest(POST, routes.AdminController.loadOtherBusinessSupportLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "submitOtherBusinessSupportLvl4Page" should {
      "redirect on valid form submission OtherBusinessSupportLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherBusinessSupportLvl4Page("test")(
          FakeRequest(POST, routes.AdminController.submitOtherBusinessSupportLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadPersonalHouseholdLvl4Page" should {
      "redirect on valid form submission PersonalHouseholdLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadPersonalHouseholdLvl4Page("test")(
          FakeRequest(POST, routes.AdminController.loadPersonalHouseholdLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "submitPersonalHouseholdLvl4Page" should {
      "redirect on valid form submission PersonalHouseholdLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitPersonalHouseholdLvl4Page("test")(
          FakeRequest(POST, routes.AdminController.submitPersonalHouseholdLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

  }
}
