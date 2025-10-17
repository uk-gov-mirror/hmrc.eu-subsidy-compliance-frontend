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

class ClothesTextilesHomewareControllerSpec
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

  private val controller = instanceOf[ClothesTextilesHomewareController]
  private val navigator = instanceOf[Navigator]

  "ClothesTextilesHomewareController" should {
    "loadClothingLvl3Page" should {
      "return OK and render the ClothingLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }

        def performAction() = controller.loadClothingLvl3Page("test")(
          FakeRequest(GET, routes.ClothesTextilesHomewareController.loadClothingLvl3Page("test").url)
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

    "submitClothingLvl3Page" should {
      "redirect on valid form submission ClothingLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitClothingLvl3Page("test")(
          FakeRequest(POST, routes.ClothesTextilesHomewareController.submitClothingLvl3Page("test").url)
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

    "loadLeatherLvl3Page" should {
      "return OK and render the LeatherLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }

        def performAction() = controller.loadLeatherLvl3Page("test")(
          FakeRequest(GET, routes.ClothesTextilesHomewareController.loadLeatherLvl3Page("test").url)
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

    "submitLeatherLvl3Page" should {
      "redirect on valid form submission LeatherLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitLeatherLvl3Page("test")(
          FakeRequest(POST, routes.ClothesTextilesHomewareController.submitLeatherLvl3Page("test").url)
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

    "loadRubberPlasticLvl3Page" should {
      "return OK and render the RubberPlasticLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadRubberPlasticLvl3Page("test")(
          FakeRequest(GET, routes.ClothesTextilesHomewareController.loadRubberPlasticLvl3Page("test").url)
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

    "submitRubberPlasticLvl3Page" should {
      "redirect on valid form submission RubberPlasticLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitRubberPlasticLvl3Page("test")(
          FakeRequest(POST, routes.ClothesTextilesHomewareController.submitRubberPlasticLvl3Page("test").url)
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

    "loadTextilesLvl3Page" should {
      "return OK and render the TextilesLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadTextilesLvl3Page("test")(
          FakeRequest(GET, routes.ClothesTextilesHomewareController.loadTextilesLvl3Page("test").url)
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

    "submitTextilesLvl3Page" should {
      "redirect on valid form submission TextilesLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitTextilesLvl3Page("test")(
          FakeRequest(POST, routes.ClothesTextilesHomewareController.submitTextilesLvl3Page("test").url)
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

    "loadWoodCorkStrawLvl3Page" should {
      "return OK and render the WoodCorkStrawLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadWoodCorkStrawLvl3Page("test")(
          FakeRequest(GET, routes.ClothesTextilesHomewareController.loadWoodCorkStrawLvl3Page("test").url)
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

    "submitWoodCorkStrawLvl3Page" should {
      "redirect on valid form submission WoodCorkStrawLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitWoodCorkStrawLvl3Page("test")(
          FakeRequest(POST, routes.ClothesTextilesHomewareController.submitWoodCorkStrawLvl3Page("test").url)
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

    "loadManufactureOfTextilesLvl4Page" should {
      "return OK and render the ManufactureOfTextilesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadManufactureOfTextilesLvl4Page("test")(
          FakeRequest(GET, routes.ClothesTextilesHomewareController.loadManufactureOfTextilesLvl4Page("test").url)
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

    "submitManufactureOfTextilesLvl4Page" should {
      "redirect on valid form submission ManufactureOfTextilesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitManufactureOfTextilesLvl4Page("test")(
          FakeRequest(POST, routes.ClothesTextilesHomewareController.submitManufactureOfTextilesLvl4Page("test").url)
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

    "loadOtherClothingLvl4Page" should {
      "return OK and render the OtherClothingLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherClothingLvl4Page("test")(
          FakeRequest(GET, routes.ClothesTextilesHomewareController.loadOtherClothingLvl4Page("test").url)
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

    "submitOtherClothingLvl4Page" should {
      "redirect on valid form submission OtherClothingLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherClothingLvl4Page("test")(
          FakeRequest(POST, routes.ClothesTextilesHomewareController.submitOtherClothingLvl4Page("test").url)
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

    "loadPlasticLvl4Page" should {
      "return OK and render the PlasticLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadPlasticLvl4Page("test")(
          FakeRequest(GET, routes.ClothesTextilesHomewareController.loadPlasticLvl4Page("test").url)
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

    "submitPlasticLvl4Page" should {
      "redirect on valid form submission PlasticLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitPlasticLvl4Page("test")(
          FakeRequest(POST, routes.ClothesTextilesHomewareController.submitPlasticLvl4Page("test").url)
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

    "loadRubberLvl4Page" should {
      "return OK and render the RubberLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadRubberLvl4Page("test")(
          FakeRequest(GET, routes.ClothesTextilesHomewareController.loadRubberLvl4Page("test").url)
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

    "submitRubberLvl4Page" should {
      "redirect on valid form submission RubberLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitRubberLvl4Page("test")(
          FakeRequest(POST, routes.ClothesTextilesHomewareController.submitRubberLvl4Page("test").url)
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

    "loadSawmillingWoodworkLvl4Page" should {
      "return OK and render the SawmillingWoodworkLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadSawmillingWoodworkLvl4Page("test")(
          FakeRequest(GET, routes.ClothesTextilesHomewareController.loadSawmillingWoodworkLvl4Page("test").url)
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

    "submitSawmillingWoodworkLvl4Page" should {
      "redirect on valid form submission SawmillingWoodworkLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitSawmillingWoodworkLvl4Page("test")(
          FakeRequest(POST, routes.ClothesTextilesHomewareController.submitSawmillingWoodworkLvl4Page("test").url)
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

    "loadTanningDressingDyeingLvl4Page" should {
      "return OK and render the TanningDressingDyeingLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadTanningDressingDyeingLvl4Page("test")(
          FakeRequest(GET, routes.ClothesTextilesHomewareController.loadTanningDressingDyeingLvl4Page("test").url)
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

    "submitTanningDressingDyeingLvl4Page" should {
      "redirect on valid form submission TanningDressingDyeingLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitTanningDressingDyeingLvl4Page("test")(
          FakeRequest(POST, routes.ClothesTextilesHomewareController.submitTanningDressingDyeingLvl4Page("test").url)
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

    "loadWoodCorkStrawPlaitingLvl4Page" should {
      "return OK and render the WoodCorkStrawPlaitingLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadWoodCorkStrawPlaitingLvl4Page("test")(
          FakeRequest(GET, routes.ClothesTextilesHomewareController.loadWoodCorkStrawPlaitingLvl4Page("test").url)
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

    "submitWoodCorkStrawPlaitingLvl4Page" should {
      "redirect on valid form submission WoodCorkStrawPlaitingLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitWoodCorkStrawPlaitingLvl4Page("test")(
          FakeRequest(POST, routes.ClothesTextilesHomewareController.submitWoodCorkStrawPlaitingLvl4Page("test").url)
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
