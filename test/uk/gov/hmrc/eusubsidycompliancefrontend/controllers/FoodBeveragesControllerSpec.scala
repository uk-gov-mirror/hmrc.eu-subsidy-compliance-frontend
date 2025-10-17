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

class FoodBeveragesControllerSpec
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

  private val controller = instanceOf[FoodBeveragesController]
  private val navigator = instanceOf[Navigator]
  "FoodBeveragesController" should {

    "loadFoodLvl3Page" should {
      "return OK and render the FoodLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadFoodLvl3Page("test")(
          FakeRequest(GET, routes.FoodBeveragesController.loadFoodLvl3Page("test").url)
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

    "submitFoodLvl3Page" should {
      "redirect on valid form submission FoodLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitFoodLvl3Page("test")(
          FakeRequest(POST, routes.FoodBeveragesController.submitFoodLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadAnimalFeedsLvl4Page" should {
      "return OK and render the AnimalFeedsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadAnimalFeedsLvl4Page("test")(
          FakeRequest(GET, routes.FoodBeveragesController.loadAnimalFeedsLvl4Page("test").url)
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

    "submitAnimalFeedsLvl4Page" should {
      "redirect on valid form submission AnimalFeedsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitAnimalFeedsLvl4Page("test")(
          FakeRequest(POST, routes.FoodBeveragesController.submitAnimalFeedsLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadBakeryAndFarinaceousLvl4Page" should {
      "return OK and render the BakeryAndFarinaceousLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadBakeryAndFarinaceousLvl4Page("test")(
          FakeRequest(GET, routes.FoodBeveragesController.loadBakeryAndFarinaceousLvl4Page("test").url)
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

    "submitBakeryAndFarinaceousLvl4Page" should {
      "redirect on valid form submission BakeryAndFarinaceousLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitBakeryAndFarinaceousLvl4Page("test")(
          FakeRequest(POST, routes.FoodBeveragesController.submitBakeryAndFarinaceousLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadDairyProductsLvl4Page" should {
      "return OK and render the DairyProductsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadDairyProductsLvl4Page("test")(
          FakeRequest(GET, routes.FoodBeveragesController.loadDairyProductsLvl4Page("test").url)
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

    "submitDairyProductsLvl4Page" should {
      "redirect on valid form submission DairyProductsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitDairyProductsLvl4Page("test")(
          FakeRequest(POST, routes.FoodBeveragesController.submitDairyProductsLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadFruitAndVegLvl4Page" should {
      "return OK and render the loadFruitAndVegLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadFruitAndVegLvl4Page("test")(
          FakeRequest(GET, routes.FoodBeveragesController.loadFruitAndVegLvl4Page("test").url)
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

    "submitFruitAndVegLvl4Page" should {
      "redirect on valid form submission FruitAndVegLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitFruitAndVegLvl4Page("test")(
          FakeRequest(POST, routes.FoodBeveragesController.submitFruitAndVegLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadGrainAndStarchLvl4Page" should {
      "return OK and render the GrainAndStarchLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadGrainAndStarchLvl4Page("test")(
          FakeRequest(GET, routes.FoodBeveragesController.loadGrainAndStarchLvl4Page("test").url)
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

    "submitGrainAndStarchLvl4Page" should {
      "redirect on valid form submission GrainAndStarchLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitGrainAndStarchLvl4Page("test")(
          FakeRequest(POST, routes.FoodBeveragesController.submitGrainAndStarchLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadMeatLvl4Page" should {
      "return OK and render the MeatLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadMeatLvl4Page("test")(
          FakeRequest(GET, routes.FoodBeveragesController.loadMeatLvl4Page("test").url)
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

    "submitMeatLvl4Page" should {
      "redirect on valid form submission MeatLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitMeatLvl4Page("test")(
          FakeRequest(POST, routes.FoodBeveragesController.submitMeatLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOilsAndFatsLvl4Page" should {
      "return OK and render the OilsAndFatsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOilsAndFatsLvl4Page("test")(
          FakeRequest(GET, routes.FoodBeveragesController.loadOilsAndFatsLvl4Page("test").url)
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

    "submitOilsAndFatsLvl4Page" should {
      "redirect on valid form submission OilsAndFatsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOilsAndFatsLvl4Page("test")(
          FakeRequest(POST, routes.FoodBeveragesController.submitOilsAndFatsLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOtherFoodProductsLvl4Page" should {
      "return OK and render the OtherFoodProductsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherFoodProductsLvl4Page("test")(
          FakeRequest(GET, routes.FoodBeveragesController.loadOtherFoodProductsLvl4Page("test").url)
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

    "submitOtherFoodProductsLvl4Page" should {
      "redirect on valid form submission OtherFoodProductsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherFoodProductsLvl4Page("test")(
          FakeRequest(POST, routes.FoodBeveragesController.submitOtherFoodProductsLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadBeveragesLvl4Page" should {
      "return OK and render the BeveragesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadBeveragesLvl4Page("test")(
          FakeRequest(GET, routes.FoodBeveragesController.loadBeveragesLvl4Page("test").url)
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

    "submitBeveragesLvl4Page" should {
      "redirect on valid form submission BeveragesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitBeveragesLvl4Page("test")(
          FakeRequest(POST, routes.FoodBeveragesController.submitBeveragesLvl4Page("test").url)
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
