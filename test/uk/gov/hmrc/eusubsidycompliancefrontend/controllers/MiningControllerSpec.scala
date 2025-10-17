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

class MiningControllerSpec
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

  private val controller = instanceOf[MiningController]
  private val navigator = instanceOf[Navigator]
  "HouseHealthEducationController" should {

    "loadMiningLvl2Page" should {
      "return OK and render the loadMiningLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadMiningLvl2Page("test")(
          FakeRequest(GET, routes.MiningController.loadMiningLvl2Page("test").url)
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
    "submitMiningLvl2Page" should {
      "redirect on valid form submission MiningLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitMiningLvl2Page("test")(
          FakeRequest(POST, routes.MiningController.submitMiningLvl2Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadMiningSupportLvl3Page" should {
      "return OK and render the MiningSupportLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadMiningSupportLvl3Page("test")(
          FakeRequest(GET, routes.MiningController.loadMiningSupportLvl3Page("test").url)
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
    "submitMiningSupportLvl3Page" should {
      "redirect on valid form submission MiningSupportLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitMiningSupportLvl3Page("test")(
          FakeRequest(POST, routes.MiningController.submitMiningSupportLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadNonFeMetalMiningLvl4Page" should {
      "return OK and render the NonFeMetalMiningLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadNonFeMetalMiningLvl4Page("test")(
          FakeRequest(GET, routes.MiningController.loadNonFeMetalMiningLvl4Page("test").url)
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
    "submitNonFeMetalMiningLvl4Page" should {
      "redirect on valid form submission NonFeMetalMiningLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitNonFeMetalMiningLvl4Page("test")(
          FakeRequest(POST, routes.MiningController.submitNonFeMetalMiningLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOtherMiningLvl3Page" should {
      "return OK and render the OtherMiningLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherMiningLvl3Page("test")(
          FakeRequest(GET, routes.MiningController.loadOtherMiningLvl3Page("test").url)
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
    "submitOtherMiningLvl3Page" should {
      "redirect on valid form submission OtherMiningLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherMiningLvl3Page("test")(
          FakeRequest(POST, routes.MiningController.submitOtherMiningLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOtherMiningLvl4Page" should {
      "return OK and render the OtherMiningLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherMiningLvl4Page("test")(
          FakeRequest(GET, routes.MiningController.loadOtherMiningLvl4Page("test").url)
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
    "submitOtherMiningLvl4Page" should {
      "redirect on valid form submission OtherMiningLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherMiningLvl4Page("test")(
          FakeRequest(POST, routes.MiningController.submitOtherMiningLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadQuarryingLvl4Page" should {
      "return OK and render the QuarryingLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadQuarryingLvl4Page("test")(
          FakeRequest(GET, routes.MiningController.loadQuarryingLvl4Page("test").url)
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
    "submitQuarryingLvl4Page" should {
      "redirect on valid form submission QuarryingLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitQuarryingLvl4Page("test")(
          FakeRequest(POST, routes.MiningController.submitQuarryingLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadCoalMiningLvl3Page" should {
      "return OK and render the CoalMiningLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadCoalMiningLvl3Page("test")(
          FakeRequest(GET, routes.MiningController.loadCoalMiningLvl3Page("test").url)
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
    "submitCoalMiningLvl3Page" should {
      "redirect on valid form submission CoalMiningLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitCoalMiningLvl3Page("test")(
          FakeRequest(POST, routes.MiningController.submitCoalMiningLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadGasMiningLvl3Page" should {
      "return OK and render the GasMiningLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadGasMiningLvl3Page("test")(
          FakeRequest(GET, routes.MiningController.loadGasMiningLvl3Page("test").url)
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
    "submitGasMiningLvl3Page" should {
      "redirect on valid form submission GasMiningLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitGasMiningLvl3Page("test")(
          FakeRequest(POST, routes.MiningController.submitGasMiningLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadMetalMiningLvl3Page" should {
      "return OK and render the MetalMiningLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadMetalMiningLvl3Page("test")(
          FakeRequest(GET, routes.MiningController.loadMetalMiningLvl3Page("test").url)
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
    "submitMetalMiningLvl3Page" should {
      "redirect on valid form submission MetalMiningLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitMetalMiningLvl3Page("test")(
          FakeRequest(POST, routes.MiningController.submitMetalMiningLvl3Page("test").url)
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
