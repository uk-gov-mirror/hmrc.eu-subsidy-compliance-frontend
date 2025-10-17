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

class AgricultureControllerSpec
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

  private val controller = instanceOf[AgricultureController]
  private val navigator = instanceOf[Navigator]
  "AgricultureController" should {

    "loadAgricultureLvl3Page" should {
      "return OK and render the AgricultureLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }

        def performAction() = controller.loadAgricultureLvl3Page("test")(
          FakeRequest(GET, routes.AgricultureController.loadAgricultureLvl3Page("test").url)
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

    "submitAgricultureLvl3Page" should {
      "redirect on valid form submission AgricultureLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitAgricultureLvl3Page("test")(
          FakeRequest(POST, routes.AgricultureController.submitAgricultureLvl3Page("test").url)
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

    "loadSupportActivitiesLvl4Page" should {
      "return OK and render the SupportActivitiesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }

        def performAction() = controller.loadSupportActivitiesLvl4Page("test")(
          FakeRequest(GET, routes.AgricultureController.loadSupportActivitiesLvl4Page("test").url)
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

    "submitSupportActivitiesLvl4Page" should {
      "redirect on valid form submission SupportActivitiesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }

        def performAction() = controller.submitSupportActivitiesLvl4Page("test")(
          FakeRequest(POST, routes.AgricultureController.submitSupportActivitiesLvl4Page("test").url)
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

    "loadAnimalProductionLvl4Page" should {
      "return OK and render the AnimalProductionLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadAnimalProductionLvl4Page("test")(
          FakeRequest(GET, routes.AgricultureController.loadAnimalProductionLvl4Page("test").url)
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

    "submitAnimalProductionLvl4Page" should {
      "redirect on valid form submission AnimalProductionLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitAnimalProductionLvl4Page("test")(
          FakeRequest(POST, routes.AgricultureController.submitAnimalProductionLvl4Page("test").url)
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

    "loadPerennialCropLvl4Page" should {
      "return OK and render the PerennialCropLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadPerennialCropLvl4Page("test")(
          FakeRequest(GET, routes.AgricultureController.loadPerennialCropLvl4Page("test").url)
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

    "submitPerennialCropLvl4Page" should {
      "redirect on valid form submission PerennialCropLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitPerennialCropLvl4Page("test")(
          FakeRequest(POST, routes.AgricultureController.submitPerennialCropLvl4Page("test").url)
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

    "loadNonPerennialCropLvl4Page" should {
      "return OK and render the NonPerennialCropLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadNonPerennialCropLvl4Page("test")(
          FakeRequest(GET, routes.AgricultureController.loadNonPerennialCropLvl4Page("test").url)
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

    "submitNonPerennialCropLvl4Page" should {
      "redirect on valid form submission NonPerennialCropLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitNonPerennialCropLvl4Page("test")(
          FakeRequest(POST, routes.AgricultureController.submitNonPerennialCropLvl4Page("test").url)
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

    "loadForestryLvl3Page" should {
      "return OK and render the ForestryLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadForestryLvl3Page("test")(
          FakeRequest(GET, routes.AgricultureController.loadForestryLvl3Page("test").url)
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

    "submitForestryLvl3Page" should {
      "redirect on valid form submission ForestryLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitForestryLvl3Page("test")(
          FakeRequest(POST, routes.AgricultureController.submitForestryLvl3Page("test").url)
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

    "loadFishingAndAquacultureLvl3Page" should {
      "return OK and render the loadFishingAndAquacultureLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadFishingAndAquacultureLvl3Page("test")(
          FakeRequest(GET, routes.AgricultureController.loadFishingAndAquacultureLvl3Page("test").url)
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

    "submitFishingAndAquacultureLvl3Page" should {
      "redirect on valid form submission FishingAndAquacultureLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitFishingAndAquacultureLvl3Page("test")(
          FakeRequest(POST, routes.AgricultureController.submitFishingAndAquacultureLvl3Page("test").url)
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

    "loadAquacultureLvl4Page" should {
      "return OK and render the AquacultureLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadAquacultureLvl4Page("test")(
          FakeRequest(GET, routes.AgricultureController.loadAquacultureLvl4Page("test").url)
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

    "submitAquacultureLvl4Page" should {
      "redirect on valid form submission AquacultureLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitAquacultureLvl4Page("test")(
          FakeRequest(POST, routes.AgricultureController.submitAquacultureLvl4Page("test").url)
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

    "loadFishingLvl4Page" should {
      "return OK and render the FishingLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadFishingLvl4Page("test")(
          FakeRequest(GET, routes.AgricultureController.loadFishingLvl4Page("test").url)
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

    "submitFishingLvl4Page" should {
      "redirect on valid form submission FishingLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitFishingLvl4Page("test")(
          FakeRequest(POST, routes.AgricultureController.submitFishingLvl4Page("test").url)
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
