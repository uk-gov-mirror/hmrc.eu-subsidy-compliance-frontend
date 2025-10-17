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

class ComputersElectronicsControllerSpec
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

  private val controller = instanceOf[ComputersElectronicsController]
  private val navigator = instanceOf[Navigator]

  "ComputersElectronicsController" should {
    "loadOtherSpecialPurposeLvl4Page" should {
      "return OK and render the OtherSpecialPurposeLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherSpecialPurposeLvl4Page("test")(
          FakeRequest(GET, routes.ComputersElectronicsController.loadOtherSpecialPurposeLvl4Page("test").url)
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

    "submitOtherSpecialPurposeLvl4Page" should {
      "redirect on valid form submission OtherSpecialPurposeLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherSpecialPurposeLvl4Page("test")(
          FakeRequest(POST, routes.ComputersElectronicsController.submitOtherSpecialPurposeLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadRepairMaintenanceLvl4Page" should {
      "return OK and render the RepairMaintenanceLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadRepairMaintenanceLvl4Page("test")(
          FakeRequest(GET, routes.ComputersElectronicsController.loadRepairMaintenanceLvl4Page("test").url)
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

    "submitRepairMaintenanceLvl4Page" should {
      "redirect on valid form submission RepairMaintenanceLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitRepairMaintenanceLvl4Page("test")(
          FakeRequest(POST, routes.ComputersElectronicsController.submitRepairMaintenanceLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadWiringAndDevicesLvl4Page" should {
      "return OK and render the WiringAndDevicesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadWiringAndDevicesLvl4Page("test")(
          FakeRequest(GET, routes.ComputersElectronicsController.loadWiringAndDevicesLvl4Page("test").url)
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

    "submitWiringAndDevicesLvl4Page" should {
      "redirect on valid form submission WiringAndDevicesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitWiringAndDevicesLvl4Page("test")(
          FakeRequest(POST, routes.ComputersElectronicsController.submitWiringAndDevicesLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadRepairsMaintainInstallLvl3Page" should {
      "return OK and render the RepairsMaintainInstallLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadRepairsMaintainInstallLvl3Page("test")(
          FakeRequest(GET, routes.ComputersElectronicsController.loadRepairsMaintainInstallLvl3Page("test").url)
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

    "submitRepairsMaintainInstallLvl3Page" should {
      "redirect on valid form submission RepairsMaintainInstallLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitRepairsMaintainInstallLvl3Page("test")(
          FakeRequest(POST, routes.ComputersElectronicsController.submitRepairsMaintainInstallLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadComponentsBoardsLvl4Page" should {
      "return OK and render the ComponentsBoardsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadComponentsBoardsLvl4Page("test")(
          FakeRequest(GET, routes.ComputersElectronicsController.loadComponentsBoardsLvl4Page("test").url)
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

    "submitComponentsBoardsLvl4Page" should {
      "redirect on valid form submission ComponentsBoardsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitComponentsBoardsLvl4Page("test")(
          FakeRequest(POST, routes.ComputersElectronicsController.submitComponentsBoardsLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadComputersElectronicsOpticalLvl3Page" should {
      "return OK and render the ComputersElectronicsOpticalLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadComputersElectronicsOpticalLvl3Page("test")(
          FakeRequest(GET, routes.ComputersElectronicsController.loadComputersElectronicsOpticalLvl3Page("test").url)
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

    "submitComputersElectronicsOpticalLvl3Page" should {
      "redirect on valid form submission ComputersElectronicsOpticalLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitComputersElectronicsOpticalLvl3Page("test")(
          FakeRequest(POST, routes.ComputersElectronicsController.submitComputersElectronicsOpticalLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadDomesticAppliancesLvl4Page" should {
      "return OK and render the DomesticAppliancesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadDomesticAppliancesLvl4Page("test")(
          FakeRequest(GET, routes.ComputersElectronicsController.loadDomesticAppliancesLvl4Page("test").url)
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

    "submitDomesticAppliancesLvl4Page" should {
      "redirect on valid form submission DomesticAppliancesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitDomesticAppliancesLvl4Page("test")(
          FakeRequest(POST, routes.ComputersElectronicsController.submitDomesticAppliancesLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadElectricalEquipmentLvl3Page" should {
      "return OK and render the ElectricalEquipmentLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadElectricalEquipmentLvl3Page("test")(
          FakeRequest(GET, routes.ComputersElectronicsController.loadElectricalEquipmentLvl3Page("test").url)
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

    "submitElectricalEquipmentLvl3Page" should {
      "redirect on valid form submission ElectricalEquipmentLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitElectricalEquipmentLvl3Page("test")(
          FakeRequest(POST, routes.ComputersElectronicsController.submitElectricalEquipmentLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadGeneralPurposeLvl4Page" should {
      "return OK and render the GeneralPurposeLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadGeneralPurposeLvl4Page("test")(
          FakeRequest(GET, routes.ComputersElectronicsController.loadGeneralPurposeLvl4Page("test").url)
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

    "submitGeneralPurposeLvl4Page" should {
      "redirect on valid form submission GeneralPurposeLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitGeneralPurposeLvl4Page("test")(
          FakeRequest(POST, routes.ComputersElectronicsController.submitGeneralPurposeLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadMeasuringTestingInstrumentsLvl4Page" should {
      "return OK and render the MeasuringTestingInstrumentsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadMeasuringTestingInstrumentsLvl4Page("test")(
          FakeRequest(GET, routes.ComputersElectronicsController.loadMeasuringTestingInstrumentsLvl4Page("test").url)
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

    "submitMeasuringTestingInstrumentsLvl4Page" should {
      "redirect on valid form submission MeasuringTestingInstrumentsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitMeasuringTestingInstrumentsLvl4Page("test")(
          FakeRequest(POST, routes.ComputersElectronicsController.submitMeasuringTestingInstrumentsLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadMetalFormingLvl4Page" should {
      "return OK and render the MetalFormingLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadMetalFormingLvl4Page("test")(
          FakeRequest(GET, routes.ComputersElectronicsController.loadMetalFormingLvl4Page("test").url)
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

    "submitMetalFormingLvl4Page" should {
      "redirect on valid form submission MetalFormingLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitMetalFormingLvl4Page("test")(
          FakeRequest(POST, routes.ComputersElectronicsController.submitMetalFormingLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println {
          redirectLocation(result)
        }
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadMotorsGeneratorsLvl4Page" should {
      "return OK and render the MotorsGeneratorsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadMotorsGeneratorsLvl4Page("test")(
          FakeRequest(GET, routes.ComputersElectronicsController.loadMotorsGeneratorsLvl4Page("test").url)
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

    "submitMotorsGeneratorsLvl4Page" should {
      "redirect on valid form submission MotorsGeneratorsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitMotorsGeneratorsLvl4Page("test")(
          FakeRequest(POST, routes.ComputersElectronicsController.submitMotorsGeneratorsLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println {
          redirectLocation(result)
        }
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOtherGeneralPurposeLvl4Page" should {
      "return OK and render the OtherGeneralPurposeLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherGeneralPurposeLvl4Page("test")(
          FakeRequest(GET, routes.ComputersElectronicsController.loadOtherGeneralPurposeLvl4Page("test").url)
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

    "submitOtherGeneralPurposeLvl4Page" should {
      "redirect on valid form submission OtherGeneralPurposeLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherGeneralPurposeLvl4Page("test")(
          FakeRequest(POST, routes.ComputersElectronicsController.submitOtherGeneralPurposeLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println {
          redirectLocation(result)
        }
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOtherMachineryLvl3Page" should {
      "return OK and render the OtherMachineryLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherMachineryLvl3Page("test")(
          FakeRequest(GET, routes.ComputersElectronicsController.loadOtherMachineryLvl3Page("test").url)
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

    "submitOtherMachineryLvl3Page" should {
      "redirect on valid form submission OtherMachineryLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherMachineryLvl3Page("test")(
          FakeRequest(POST, routes.ComputersElectronicsController.submitOtherMachineryLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println {
          redirectLocation(result)
        }
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

  }
}
