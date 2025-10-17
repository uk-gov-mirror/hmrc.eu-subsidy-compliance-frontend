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

class MetalsChemicalsControllerSpec
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

  private val controller = instanceOf[MetalsChemicalsController]
  private val navigator = instanceOf[Navigator]

  "HouseHealthEducationController" should {

    "loadPharmaceuticalsLvl3Page" should {
      "return OK and render the PharmaceuticalsLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadPharmaceuticalsLvl3Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadPharmaceuticalsLvl3Page("test").url)
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
    "submitPharmaceuticalsLvl3Page" should {
      "redirect on valid form submission PharmaceuticalsLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitPharmaceuticalsLvl3Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.submitPharmaceuticalsLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadPreciousNonFerrousLvl4Page" should {
      "return OK and render the PreciousNonFerrousLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadPreciousNonFerrousLvl4Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadPreciousNonFerrousLvl4Page("test").url)
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
    "submitPreciousNonFerrousLvl4Page" should {
      "redirect on valid form submission PreciousNonFerrousLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitPreciousNonFerrousLvl4Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.submitPreciousNonFerrousLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadStructuralMetalLvl4Page" should {
      "return OK and render the StructuralMetalLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadStructuralMetalLvl4Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadStructuralMetalLvl4Page("test").url)
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
    "submitStructuralMetalLvl4Page" should {
      "redirect on valid form submission StructuralMetalLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitStructuralMetalLvl4Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.submitStructuralMetalLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadTanksReservoirsContainersLvl4Page" should {
      "return OK and render the TanksReservoirsContainersLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadTanksReservoirsContainersLvl4Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadTanksReservoirsContainersLvl4Page("test").url)
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
    "submitTanksReservoirsContainersLvl4Page" should {
      "redirect on valid form submission TanksReservoirsContainersLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitTanksReservoirsContainersLvl4Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.submitTanksReservoirsContainersLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadTreatmentCoatingMachiningLvl4Page" should {
      "return OK and render the TreatmentCoatingMachiningLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadTreatmentCoatingMachiningLvl4Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadTreatmentCoatingMachiningLvl4Page("test").url)
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
    "submitTreatmentCoatingMachiningLvl4Page" should {
      "redirect on valid form submission TreatmentCoatingMachiningLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitTreatmentCoatingMachiningLvl4Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.submitTreatmentCoatingMachiningLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadWashingLvl4Page" should {
      "return OK and render the WashingLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadWashingLvl4Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadWashingLvl4Page("test").url)
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
    "loadWashingLvl4Page" should {
      "redirect on valid form submission WashingLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadWashingLvl4Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.loadWashingLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadWashingLvl4Page" should {
      "return OK and render the WashingLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadWashingLvl4Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadWashingLvl4Page("test").url)
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
    "submitWashingLvl4Page" should {
      "redirect on valid form submission WashingLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitWashingLvl4Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.submitWashingLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadBasicLvl4Page" should {
      "return OK and render the BasicLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadBasicLvl4Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadBasicLvl4Page("test").url)
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
    "submitBasicLvl4Page" should {
      "redirect on valid form submission BasicLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitBasicLvl4Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.submitBasicLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadBasicMetalsLvl3Page" should {
      "return OK and render the BasicMetalsLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadBasicMetalsLvl3Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadBasicMetalsLvl3Page("test").url)
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
    "submitBasicMetalsLvl3Page" should {
      "redirect on valid form submission BasicMetalsLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitBasicMetalsLvl3Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.submitBasicMetalsLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadCastingMetalsLvl4Page" should {
      "return OK and render the CastingMetalsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadCastingMetalsLvl4Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadCastingMetalsLvl4Page("test").url)
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
    "submitCastingMetalsLvl4Page" should {
      "redirect on valid form submission CastingMetalsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitCastingMetalsLvl4Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.submitCastingMetalsLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadChemicalsProductsLvl3Page" should {
      "return OK and render the ChemicalsProductsLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadChemicalsProductsLvl3Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadChemicalsProductsLvl3Page("test").url)
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
    "submitChemicalsProductsLvl3Page" should {
      "redirect on valid form submission ChemicalsProductsLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitChemicalsProductsLvl3Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.submitChemicalsProductsLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadCokePetroleumLvl3Page" should {
      "return OK and render the CokePetroleumLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadCokePetroleumLvl3Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadCokePetroleumLvl3Page("test").url)
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
    "submitCokePetroleumLvl3Page" should {
      "redirect on valid form submission CokePetroleumLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitCokePetroleumLvl3Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.submitCokePetroleumLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadCutleryToolsHardwareLvl4Page" should {
      "return OK and render the CutleryToolsHardwareLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadCutleryToolsHardwareLvl4Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadCutleryToolsHardwareLvl4Page("test").url)
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
    "submitCutleryToolsHardwareLvl4Page" should {
      "redirect on valid form submission CutleryToolsHardwareLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitCutleryToolsHardwareLvl4Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.submitCutleryToolsHardwareLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadFabricatedMetalsLvl3Page" should {
      "return OK and render the FabricatedMetalsLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadFabricatedMetalsLvl3Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadFabricatedMetalsLvl3Page("test").url)
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
    "submitFabricatedMetalsLvl3Page" should {
      "redirect on valid form submission FabricatedMetalsLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitFabricatedMetalsLvl3Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.submitFabricatedMetalsLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadFirstProcessingSteelLvl4Page" should {
      "return OK and render the FirstProcessingSteelLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadFirstProcessingSteelLvl4Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadFirstProcessingSteelLvl4Page("test").url)
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
    "submitFirstProcessingSteelLvl4Page" should {
      "redirect on valid form submission FirstProcessingSteelLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitFirstProcessingSteelLvl4Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.submitFirstProcessingSteelLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOtherFabricatedProductsLvl4Page" should {
      "return OK and render the OtherFabricatedProductsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherFabricatedProductsLvl4Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadOtherFabricatedProductsLvl4Page("test").url)
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
    "submitOtherFabricatedProductsLvl4Page" should {
      "redirect on valid form submission OtherFabricatedProductsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherFabricatedProductsLvl4Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.submitOtherFabricatedProductsLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOtherProductsLvl4Page" should {
      "return OK and render the loadOtherProductsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherProductsLvl4Page("test")(
          FakeRequest(GET, routes.MetalsChemicalsController.loadOtherProductsLvl4Page("test").url)
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
    "submitOtherProductsLvl4Page" should {
      "redirect on valid form submission OtherProductsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherProductsLvl4Page("test")(
          FakeRequest(POST, routes.MetalsChemicalsController.submitOtherProductsLvl4Page("test").url)
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
