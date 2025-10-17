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

class HouseHealthEducationControllerSpec
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

  private val controller = instanceOf[HouseHealthEducationController]
  private val navigator = instanceOf[Navigator]

  "HouseHealthEducationController" should {

    "loadHouseholdsLvl2Page" should {
      "return OK and render the HouseholdsLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadHouseholdsLvl2Page("test")(
          FakeRequest(GET, routes.HouseHealthEducationController.loadHouseholdsLvl2Page("test").url)
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

    "submitHouseholdsLvl2Page" should {
      "redirect on valid form submission HouseholdsLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitHouseholdsLvl2Page("test")(
          FakeRequest(POST, routes.HouseHealthEducationController.submitHouseholdsLvl2Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadUndifferentiatedProducingActivitiesLvl4Page" should {
      "return OK and render the UndifferentiatedProducingActivitiesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadUndifferentiatedProducingActivitiesLvl4Page("test")(
          FakeRequest(
            GET,
            routes.HouseHealthEducationController.loadUndifferentiatedProducingActivitiesLvl4Page("test").url
          )
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

    "submitUndifferentiatedProducingActivitiesLvl4Page" should {
      "redirect on valid form submission UndifferentiatedProducingActivitiesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitUndifferentiatedProducingActivitiesLvl4Page("test")(
          FakeRequest(
            POST,
            routes.HouseHealthEducationController.submitUndifferentiatedProducingActivitiesLvl4Page("test").url
          )
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadHumanHealthLvl2Page" should {
      "return OK and render the HumanHealthLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadHumanHealthLvl2Page("test")(
          FakeRequest(GET, routes.HouseHealthEducationController.loadHumanHealthLvl2Page("test").url)
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

    "submitHumanHealthLvl2Page" should {
      "redirect on valid form submission HumanHealthLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitHumanHealthLvl2Page("test")(
          FakeRequest(POST, routes.HouseHealthEducationController.submitHumanHealthLvl2Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadHumanHealthLvl3Page" should {
      "return OK and render the HumanHealthLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadHumanHealthLvl3Page("test")(
          FakeRequest(GET, routes.HouseHealthEducationController.loadHumanHealthLvl3Page("test").url)
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

    "submitHumanHealthLvl3Page" should {
      "redirect on valid form submission HumanHealthLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitHumanHealthLvl3Page("test")(
          FakeRequest(POST, routes.HouseHealthEducationController.submitHumanHealthLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadMedicalDentalLvl4Page" should {
      "return OK and render the MedicalDentalLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadMedicalDentalLvl4Page("test")(
          FakeRequest(GET, routes.HouseHealthEducationController.loadMedicalDentalLvl4Page("test").url)
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

    "submitMedicalDentalLvl4Page" should {
      "redirect on valid form submission MedicalDentalLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitMedicalDentalLvl4Page("test")(
          FakeRequest(POST, routes.HouseHealthEducationController.submitMedicalDentalLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOtherHumanHealthLvl4Page" should {
      "return OK and render the OtherHumanHealthLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherHumanHealthLvl4Page("test")(
          FakeRequest(GET, routes.HouseHealthEducationController.loadOtherHumanHealthLvl4Page("test").url)
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

    "submitOtherHumanHealthLvl4Page" should {
      "redirect on valid form submission OtherHumanHealthLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherHumanHealthLvl4Page("test")(
          FakeRequest(POST, routes.HouseHealthEducationController.submitOtherHumanHealthLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOtherResidentialCareLvl4Page" should {
      "return OK and render the OtherResidentialCareLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherResidentialCareLvl4Page("test")(
          FakeRequest(GET, routes.HouseHealthEducationController.loadOtherResidentialCareLvl4Page("test").url)
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

    "submitOtherResidentialCareLvl4Page" should {
      "redirect on valid form submission OtherResidentialCareLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherResidentialCareLvl4Page("test")(
          FakeRequest(POST, routes.HouseHealthEducationController.submitOtherResidentialCareLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOtherSocialWorkLvl4Page" should {
      "return OK and render the OtherSocialWorkLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherSocialWorkLvl4Page("test")(
          FakeRequest(GET, routes.HouseHealthEducationController.loadOtherSocialWorkLvl4Page("test").url)
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

    "submitOtherSocialWorkLvl4Page" should {
      "redirect on valid form submission OtherSocialWorkLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherSocialWorkLvl4Page("test")(
          FakeRequest(POST, routes.HouseHealthEducationController.submitOtherSocialWorkLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadResidentialCareLvl3Page" should {
      "return OK and render the ResidentialCareLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadResidentialCareLvl3Page("test")(
          FakeRequest(GET, routes.HouseHealthEducationController.loadResidentialCareLvl3Page("test").url)
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

    "submitResidentialCareLvl3Page" should {
      "redirect on valid form submission ResidentialCareLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitResidentialCareLvl3Page("test")(
          FakeRequest(POST, routes.HouseHealthEducationController.submitResidentialCareLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadSecondaryEducationLvl4Page" should {
      "return OK and render the SecondaryEducationLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadSecondaryEducationLvl4Page("test")(
          FakeRequest(GET, routes.HouseHealthEducationController.loadSecondaryEducationLvl4Page("test").url)
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

    "submitSecondaryEducationLvl4Page" should {
      "redirect on valid form submission SecondaryEducationLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitSecondaryEducationLvl4Page("test")(
          FakeRequest(POST, routes.HouseHealthEducationController.submitSecondaryEducationLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOtherEducationLvl4Page" should {
      "return OK and render the OtherEducationLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherEducationLvl4Page("test")(
          FakeRequest(GET, routes.HouseHealthEducationController.loadOtherEducationLvl4Page("test").url)
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

    "submitOtherEducationLvl4Page" should {
      "redirect on valid form submission OtherEducationLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherEducationLvl4Page("test")(
          FakeRequest(POST, routes.HouseHealthEducationController.submitOtherEducationLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOtherEducationLvl4Page" should {
      "return OK and render the OtherEducationLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherEducationLvl4Page("test")(
          FakeRequest(GET, routes.HouseHealthEducationController.loadOtherEducationLvl4Page("test").url)
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

    "submitOtherEducationLvl4Page" should {
      "redirect on valid form submission OtherEducationLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherEducationLvl4Page("test")(
          FakeRequest(POST, routes.HouseHealthEducationController.submitOtherEducationLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadEducationLvl3Page" should {
      "return OK and render the EducationLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadEducationLvl3Page("test")(
          FakeRequest(GET, routes.HouseHealthEducationController.loadEducationLvl3Page("test").url)
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

    "submitEducationLvl3Page" should {
      "redirect on valid form submission EducationLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitEducationLvl3Page("test")(
          FakeRequest(POST, routes.HouseHealthEducationController.submitEducationLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadEducationalSupportLvl4Page" should {
      "return OK and render the EducationalSupportLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadEducationalSupportLvl4Page("test")(
          FakeRequest(GET, routes.HouseHealthEducationController.loadEducationalSupportLvl4Page("test").url)
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

    "submitEducationalSupportLvl4Page" should {
      "redirect on valid form submission EducationalSupportLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitEducationalSupportLvl4Page("test")(
          FakeRequest(POST, routes.HouseHealthEducationController.submitEducationalSupportLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadSocialWorkLvl3Page" should {
      "return OK and render the SocialWorkLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadSocialWorkLvl3Page("test")(
          FakeRequest(GET, routes.HouseHealthEducationController.loadSocialWorkLvl3Page("test").url)
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

    "submitSocialWorkLvl3Page" should {
      "redirect on valid form submission SocialWorkLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitSocialWorkLvl3Page("test")(
          FakeRequest(POST, routes.HouseHealthEducationController.submitSocialWorkLvl3Page("test").url)
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
