/*
 * Copyright 2025 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.eusubsidycompliancefrontend.controllers

import org.jsoup.Jsoup
import play.api.test.Helpers._
import org.scalatest.concurrent.{IntegrationPatience, ScalaFutures}
import org.scalatest.matchers.should.Matchers
import play.api.inject
import play.api.inject.guice.GuiceableModule
import play.api.test.FakeRequest
import uk.gov.hmrc.auth.core.AuthConnector
import uk.gov.hmrc.eusubsidycompliancefrontend.models.types.Sector
import uk.gov.hmrc.eusubsidycompliancefrontend.navigation.Navigator
import uk.gov.hmrc.eusubsidycompliancefrontend.test.util.FakeTimeProvider
import uk.gov.hmrc.eusubsidycompliancefrontend.util.TimeProvider

class AccomodationUtilitiesControllerSpec
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

  private val controller = instanceOf[AccomodationUtilitiesController]
  private val navigator = instanceOf[Navigator]
  "AccomodationUtilitiesController" should {

    "loadAccommodationFoodLvl2Page" should {
      "return OK and render the AccommodationFoodLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadAccommodationFoodLvl2Page("test")(
          FakeRequest(GET, routes.AccomodationUtilitiesController.loadAccommodationFoodLvl2Page("test").url)
        )
        val result =
          performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-accommodationAndFoodService")
          .text shouldBe "Accommodation"
      }
    }

    "submitAccommodationFoodLvl2Page" should {
      "redirect on valid form submission AccommodationFoodLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitAccommodationFoodLvl2Page("test")(
          FakeRequest(POST, routes.AccomodationUtilitiesController.submitAccommodationFoodLvl2Page("test").url)
            .withFormUrlEncodedBody("accommodation2" -> "56")
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

    "loadAccommodationLvl3Page" should {
      "return OK and render the AccommodationLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadAccommodationLvl3Page("test")(
          FakeRequest(GET, routes.AccomodationUtilitiesController.loadAccommodationLvl3Page("test").url)
        )
        val result =
          performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-accommodationAndFoodService")
          .text shouldBe "Camping grounds and recreational vehicle parks"
      }
    }

    "submitAccommodationLvl3Page" should {
      "redirect on valid form submission AccommodationLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitAccommodationLvl3Page("test")(
          FakeRequest(POST, routes.AccomodationUtilitiesController.submitAccommodationLvl3Page("test").url)
            .withFormUrlEncodedBody("accommodation3" -> "55.3")
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage("other", "test").url
        )
      }
    }

    "loadEventCateringOtherFoodActivitiesLvl4Page" should {
      "return OK and render the EventCateringOtherFoodActivitiesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadEventCateringOtherFoodActivitiesLvl4Page("test")(
          FakeRequest(GET, routes.AccomodationUtilitiesController.loadEventCateringOtherFoodActivitiesLvl4Page("test").url)
        )
        val result =
          performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-accommodationAndFoodService")
          .text shouldBe "Contract catering and other food service activities"
      }
    }

    "submitEventCateringOtherFoodActivitiesLvl4Page" should {
      "redirect on valid form submission EventCateringOtherFoodActivitiesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitEventCateringOtherFoodActivitiesLvl4Page("test")(
          FakeRequest(POST, routes.AccomodationUtilitiesController.submitEventCateringOtherFoodActivitiesLvl4Page("test").url)
            .withFormUrlEncodedBody("catering4" -> "56.21")
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage("other", "test").url
        )
      }
    }

    "loadFoodBeverageActivitiesLvl3Page" should {
      "return OK and render the FoodBeverageActivitiesLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadFoodBeverageActivitiesLvl3Page("test")(
          FakeRequest(GET, routes.AccomodationUtilitiesController.loadFoodBeverageActivitiesLvl3Page("test").url)
        )
        val result =
          performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-accommodationAndFoodService")
          .text shouldBe "Event catering, contract catering and other food service activities"
      }
    }

    "submitFoodBeverageActivitiesLvl3Page" should {
      "redirect on valid form submission FoodBeverageActivitiesLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitFoodBeverageActivitiesLvl3Page("test")(
          FakeRequest(POST, routes.AccomodationUtilitiesController.submitFoodBeverageActivitiesLvl3Page("test").url)
            .withFormUrlEncodedBody("foodActs3" -> "56.2")
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.eventAndContractCatering.toString, "test").url
        )
      }
    }

    "loadRestaurantFoodServicesLvl4Page" should {
      "return OK and render the RestaurantFoodServicesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadRestaurantFoodServicesLvl4Page("test")(
          FakeRequest(GET, routes.AccomodationUtilitiesController.loadRestaurantFoodServicesLvl4Page("test").url)
        )
        val result =
          performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-accommodationAndFoodService")
          .text shouldBe "Restaurants"
      }
    }

    "submitRestaurantFoodServicesLvl4Page" should {
      "redirect on valid form submission RestaurantFoodServicesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitRestaurantFoodServicesLvl4Page("test")(
          FakeRequest(POST, routes.AccomodationUtilitiesController.submitRestaurantFoodServicesLvl4Page("test").url)
            .withFormUrlEncodedBody("restaurant4" -> "56.12")
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage("other", "test").url
        )
      }
    }

    "loadElectricityLvl3Page" should {
      "return OK and render the ElectricityLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadElectricityLvl3Page("test")(
          FakeRequest(GET, routes.AccomodationUtilitiesController.loadElectricityLvl3Page("test").url)
        )
        val result =
          performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-electric-power")
          .text shouldBe "Electric power generation, transmission and distribution"
      }
    }

    "submitElectricityLvl3Page" should {
      "redirect on valid form submission FoodBeverageActivitiesLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitElectricityLvl3Page("test")(
          FakeRequest(POST, routes.AccomodationUtilitiesController.submitElectricityLvl3Page("test").url)
            .withFormUrlEncodedBody("electricity3" -> "35.1")
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.electricPowerGenerationAndDistribution.toString, "test").url
        )
      }
    }

    "loadElectricityLvl4Page" should {
      "return OK and render the ElectricityLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadElectricityLvl4Page("test")(
          FakeRequest(GET, routes.AccomodationUtilitiesController.loadElectricityLvl4Page("test").url)
        )
        val result =
          performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-electricity-nonrenewable")
          .text shouldBe "Production of electricity from non-renewable sources"
      }
    }

    "submitElectricityLvl4Page" should {
      "redirect on valid form submission ElectricityLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitElectricityLvl4Page("test")(
          FakeRequest(POST, routes.AccomodationUtilitiesController.submitElectricityLvl4Page("test").url)
            .withFormUrlEncodedBody("electricity4" -> "35.14")
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage("other", "test").url
        )
      }
    }

    "loadGasManufactureLvl4Page" should {
      "return OK and render the GasManufactureLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadGasManufactureLvl4Page("test")(
          FakeRequest(GET, routes.AccomodationUtilitiesController.loadGasManufactureLvl4Page("test").url)
        )
        val result =
          performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-manufacture-gas")
          .text shouldBe "Manufacture of gas"
      }
    }

    "submitGasManufactureLvl4Page" should {
      "redirect on valid form submission GasManufactureLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitGasManufactureLvl4Page("test")(
          FakeRequest(POST, routes.AccomodationUtilitiesController.submitGasManufactureLvl4Page("test").url)
            .withFormUrlEncodedBody("gas4" -> "35.21")
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage("other", "test").url
        )
      }
    }

    "loadWasteCollectionLvl4Page" should {
      "return OK and render the WasteCollectionLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadWasteCollectionLvl4Page("test")(
          FakeRequest(GET, routes.AccomodationUtilitiesController.loadWasteCollectionLvl4Page("test").url)
        )
        val result =
          performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-hazardous-waste")
          .text shouldBe "Collection of hazardous waste"
      }
    }

    "submitWasteCollectionLvl4Page" should {
      "redirect on valid form submission WasteCollectionLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitWasteCollectionLvl4Page("test")(
          FakeRequest(POST, routes.AccomodationUtilitiesController.submitWasteCollectionLvl4Page("test").url)
            .withFormUrlEncodedBody("wasteCollection4" -> "38.12")
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage("other", "test").url
        )
      }
    }

    "loadWasteCollectionRecoveryLvl3Page" should {
      "return OK and render the WasteCollectionRecoveryLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadWasteCollectionRecoveryLvl3Page("test")(
          FakeRequest(GET, routes.AccomodationUtilitiesController.loadWasteCollectionRecoveryLvl3Page("test").url)
        )
        val result =
          performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-hazardous-waste")
          .text shouldBe "Collection of hazardous waste"
      }
    }

    "submitWasteCollectionRecoveryLvl3Page" should {
      "redirect on valid form submission WasteCollectionRecoveryLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitWasteCollectionRecoveryLvl3Page("test")(
          FakeRequest(POST, routes.AccomodationUtilitiesController.submitWasteCollectionRecoveryLvl3Page("test").url)
            .withFormUrlEncodedBody("wasteCollection4" -> "38.12")
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage("other", "test").url
        )
      }
    }

    "loadWasteDisposalLvl4Page" should {
      "return OK and render the WasteDisposalLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadWasteDisposalLvl4Page("test")(
          FakeRequest(GET, routes.AccomodationUtilitiesController.loadWasteDisposalLvl4Page("test").url)
        )
        val result =
          performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-hazardous-waste")
          .text shouldBe "Collection of hazardous waste"
      }
    }

    "submitWasteDisposalLvl4Page" should {
      "redirect on valid form submission WasteDisposalLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitWasteDisposalLvl4Page("test")(
          FakeRequest(POST, routes.AccomodationUtilitiesController.submitWasteDisposalLvl4Page("test").url)
            .withFormUrlEncodedBody("wasteCollection4" -> "38.12")
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage("other", "test").url
        )
      }
    }

    "loadWasteRecoveryLvl4Page" should {
      "return OK and render the WasteRecoveryLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadWasteRecoveryLvl4Page("test")(
          FakeRequest(GET, routes.AccomodationUtilitiesController.loadWasteRecoveryLvl4Page("test").url)
        )
        val result =
          performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-hazardous-waste")
          .text shouldBe "Collection of hazardous waste"
      }
    }

    "submitWasteRecoveryLvl4Page" should {
      "redirect on valid form submission WasteRecoveryLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitWasteRecoveryLvl4Page("test")(
          FakeRequest(POST, routes.AccomodationUtilitiesController.submitWasteRecoveryLvl4Page("test").url)
            .withFormUrlEncodedBody("wasteCollection4" -> "38.12")
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage("other", "test").url
        )
      }
    }

    "loadWaterLvl2Page" should {
      "return OK and render the WaterLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadWaterLvl2Page("test")(
          FakeRequest(GET, routes.AccomodationUtilitiesController.loadWaterLvl2Page("test").url)
        )
        val result =
          performAction()
        contentAsString(result)
        status(result) shouldBe OK
        val document = Jsoup.parse(contentAsString(result))
        document
          .getElementById("sector-label-hazardous-waste")
          .text shouldBe "Collection of hazardous waste"
      }
    }

    "submitWaterLvl2Page" should {
      "redirect on valid form submission WaterLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitWaterLvl2Page("test")(
          FakeRequest(POST, routes.AccomodationUtilitiesController.submitWaterLvl2Page("test").url)
            .withFormUrlEncodedBody("wasteCollection4" -> "38.12")
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        println(redirectLocation(result))
        redirectLocation(result) shouldBe Some(
          navigator.nextPage("other", "test").url
        )
      }
    }


  }
}
