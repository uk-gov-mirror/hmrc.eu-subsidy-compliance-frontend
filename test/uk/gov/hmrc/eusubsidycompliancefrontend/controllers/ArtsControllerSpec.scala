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

class ArtsControllerSpec
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

  private val controller = instanceOf[ArtsController]
  private val navigator = instanceOf[Navigator]

  "ArtsController" should {
    "loadAmusementAndRecreationLvl4Page" should {
      "return OK and render the AmusementAndRecreationLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadAmusementAndRecreationLvl4Page("test")(
          FakeRequest(GET, routes.ArtsController.loadAmusementAndRecreationLvl4Page("test").url)
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

    "submitAmusementAndRecreationLvl4Page" should {
      "redirect on valid form submission AmusementAndRecreationLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitAmusementAndRecreationLvl4Page("test")(
          FakeRequest(POST, routes.ArtsController.submitAmusementAndRecreationLvl4Page("test").url)
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

    "loadArtsCreationLvl4Page" should {
      "return OK and render the ArtsCreationLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadArtsCreationLvl4Page("test")(
          FakeRequest(GET, routes.ArtsController.loadArtsCreationLvl4Page("test").url)
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

    "submitArtsCreationLvl4Page" should {
      "redirect on valid form submission ArtsCreationLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitArtsCreationLvl4Page("test")(
          FakeRequest(POST, routes.ArtsController.submitArtsCreationLvl4Page("test").url)
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

    "loadArtsCreationPerformingLvl3Page" should {
      "return OK and render the ArtsCreationPerformingLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadArtsCreationPerformingLvl3Page("test")(
          FakeRequest(GET, routes.ArtsController.loadArtsCreationPerformingLvl3Page("test").url)
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

    "submitArtsCreationPerformingLvl3Page" should {
      "redirect on valid form submission ArtsCreationPerformingLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitArtsCreationPerformingLvl3Page("test")(
          FakeRequest(POST, routes.ArtsController.submitArtsCreationPerformingLvl3Page("test").url)
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

    "loadArtsPerformingSupportActivitiesLvl4Page" should {
      "return OK and render the ArtsPerformingSupportActivitiesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadArtsPerformingSupportActivitiesLvl4Page("test")(
          FakeRequest(GET, routes.ArtsController.loadArtsPerformingSupportActivitiesLvl4Page("test").url)
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

    "submitArtsPerformingSupportActivitiesLvl4Page" should {
      "redirect on valid form submission ArtsPerformingSupportActivitiesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitArtsPerformingSupportActivitiesLvl4Page("test")(
          FakeRequest(POST, routes.ArtsController.submitArtsPerformingSupportActivitiesLvl4Page("test").url)
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

    "loadArtsSportsRecreationLvl2Page" should {
      "return OK and render the ArtsSportsRecreationLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadArtsSportsRecreationLvl2Page("test")(
          FakeRequest(GET, routes.ArtsController.loadArtsSportsRecreationLvl2Page("test").url)
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

    "submitArtsSportsRecreationLvl2Page" should {
      "redirect on valid form submission ArtsSportsRecreationLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitArtsSportsRecreationLvl2Page("test")(
          FakeRequest(POST, routes.ArtsController.submitArtsSportsRecreationLvl2Page("test").url)
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

    "loadBotanicalZoologicalReservesLvl4Page" should {
      "return OK and render the BotanicalZoologicalReservesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadBotanicalZoologicalReservesLvl4Page("test")(
          FakeRequest(GET, routes.ArtsController.loadBotanicalZoologicalReservesLvl4Page("test").url)
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

    "submitBotanicalZoologicalReservesLvl4Page" should {
      "redirect on valid form submission BotanicalZoologicalReservesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitBotanicalZoologicalReservesLvl4Page("test")(
          FakeRequest(POST, routes.ArtsController.submitBotanicalZoologicalReservesLvl4Page("test").url)
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

    "loadLibrariesArchivesCulturalLvl3Page" should {
      "return OK and render the LibrariesArchivesCulturalLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadLibrariesArchivesCulturalLvl3Page("test")(
          FakeRequest(GET, routes.ArtsController.loadLibrariesArchivesCulturalLvl3Page("test").url)
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

    "submitLibrariesArchivesCulturalLvl3Page" should {
      "redirect on valid form submission LibrariesArchivesCulturalLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitLibrariesArchivesCulturalLvl3Page("test")(
          FakeRequest(POST, routes.ArtsController.submitLibrariesArchivesCulturalLvl3Page("test").url)
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

    "loadLibrariesArchivesLvl4Page" should {
      "return OK and render the LibrariesArchivesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadLibrariesArchivesLvl4Page("test")(
          FakeRequest(GET, routes.ArtsController.loadLibrariesArchivesLvl4Page("test").url)
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

    "submitLibrariesArchivesLvl4Page" should {
      "redirect on valid form submission LibrariesArchivesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitLibrariesArchivesLvl4Page("test")(
          FakeRequest(POST, routes.ArtsController.submitLibrariesArchivesLvl4Page("test").url)
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

    "loadMuseumsCollectionsMomumentsLvl4Page" should {
      "return OK and render the MuseumsCollectionsMomumentsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadMuseumsCollectionsMomumentsLvl4Page("test")(
          FakeRequest(GET, routes.ArtsController.loadMuseumsCollectionsMomumentsLvl4Page("test").url)
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

    "submitMuseumsCollectionsMomumentsLvl4Page" should {
      "redirect on valid form submission MuseumsCollectionsMomumentsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitMuseumsCollectionsMomumentsLvl4Page("test")(
          FakeRequest(POST, routes.ArtsController.submitMuseumsCollectionsMomumentsLvl4Page("test").url)
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

    "loadSportsAmusementRecreationLvl3Page" should {
      "return OK and render the SportsAmusementRecreationLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadSportsAmusementRecreationLvl3Page("test")(
          FakeRequest(GET, routes.ArtsController.loadSportsAmusementRecreationLvl3Page("test").url)
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

    "submitSportsAmusementRecreationLvl3Page" should {
      "redirect on valid form submission SportsAmusementRecreationLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitSportsAmusementRecreationLvl3Page("test")(
          FakeRequest(POST, routes.ArtsController.submitSportsAmusementRecreationLvl3Page("test").url)
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

    "loadSportsLvl4Page" should {
      "return OK and render the SportsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadSportsLvl4Page("test")(
          FakeRequest(GET, routes.ArtsController.loadSportsLvl4Page("test").url)
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

    "submitSportsLvl4Page" should {
      "redirect on valid form submission SportsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitSportsLvl4Page("test")(
          FakeRequest(POST, routes.ArtsController.submitSportsLvl4Page("test").url)
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
