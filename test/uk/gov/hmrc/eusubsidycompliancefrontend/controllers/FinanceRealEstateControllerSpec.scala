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

class FinanceRealEstateControllerSpec
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

  private val controller = instanceOf[FinanceRealEstateController]
  private val navigator = instanceOf[Navigator]

  "FinanceRealEstateController" should {

    "loadFeeContractLvl4Page" should {
      "return OK and render the FeeContractLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadFeeContractLvl4Page("test")(
          FakeRequest(GET, routes.FinanceRealEstateController.loadFeeContractLvl4Page("test").url)
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

    "submitFeeContractLvl4Page" should {
      "redirect on valid form submission FeeContractLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitFeeContractLvl4Page("test")(
          FakeRequest(POST, routes.FinanceRealEstateController.submitFeeContractLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadPropertyDevelopmentLvl4Page" should {
      "return OK and render the PropertyDevelopmentLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadPropertyDevelopmentLvl4Page("test")(
          FakeRequest(GET, routes.FinanceRealEstateController.loadPropertyDevelopmentLvl4Page("test").url)
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

    "submitPropertyDevelopmentLvl4Page" should {
      "redirect on valid form submission PropertyDevelopmentLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitPropertyDevelopmentLvl4Page("test")(
          FakeRequest(POST, routes.FinanceRealEstateController.submitPropertyDevelopmentLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadRealEstateLvl3Page" should {
      "return OK and render the RealEstateLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadRealEstateLvl3Page("test")(
          FakeRequest(GET, routes.FinanceRealEstateController.loadRealEstateLvl3Page("test").url)
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

    "submitRealEstateLvl3Page" should {
      "redirect on valid form submission RealEstateLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitRealEstateLvl3Page("test")(
          FakeRequest(POST, routes.FinanceRealEstateController.submitRealEstateLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadAuxiliaryFinancialLvl3Page" should {
      "return OK and render the AuxiliaryFinancialLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadAuxiliaryFinancialLvl3Page("test")(
          FakeRequest(GET, routes.FinanceRealEstateController.loadAuxiliaryFinancialLvl3Page("test").url)
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

    "submitAuxiliaryFinancialLvl3Page" should {
      "redirect on valid form submission AuxiliaryFinancialLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitAuxiliaryFinancialLvl3Page("test")(
          FakeRequest(POST, routes.FinanceRealEstateController.submitAuxiliaryFinancialLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadAuxiliaryInsuranceLvl4Page" should {
      "return OK and render the AuxiliaryInsuranceLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadAuxiliaryInsuranceLvl4Page("test")(
          FakeRequest(GET, routes.FinanceRealEstateController.loadAuxiliaryInsuranceLvl4Page("test").url)
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

    "submitAuxiliaryInsuranceLvl4Page" should {
      "redirect on valid form submission AuxiliaryInsuranceLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitAuxiliaryInsuranceLvl4Page("test")(
          FakeRequest(POST, routes.FinanceRealEstateController.submitAuxiliaryInsuranceLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadAuxiliaryNonInsuranceLvl4Page" should {
      "return OK and render the AuxiliaryNonInsuranceLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadAuxiliaryNonInsuranceLvl4Page("test")(
          FakeRequest(GET, routes.FinanceRealEstateController.loadAuxiliaryNonInsuranceLvl4Page("test").url)
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

    "submitAuxiliaryNonInsuranceLvl4Page" should {
      "redirect on valid form submission AuxiliaryNonInsuranceLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitAuxiliaryNonInsuranceLvl4Page("test")(
          FakeRequest(POST, routes.FinanceRealEstateController.submitAuxiliaryNonInsuranceLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadFinanceInsuranceLvl2Page" should {
      "return OK and render the FinanceInsuranceLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadFinanceInsuranceLvl2Page("test")(
          FakeRequest(GET, routes.FinanceRealEstateController.loadFinanceInsuranceLvl2Page("test").url)
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

    "submitFinanceInsuranceLvl2Page" should {
      "redirect on valid form submission FinanceInsuranceLvl2Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitFinanceInsuranceLvl2Page("test")(
          FakeRequest(POST, routes.FinanceRealEstateController.submitFinanceInsuranceLvl2Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadFinancialServicesLvl3Page" should {
      "return OK and render the FinancialServicesLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadFinancialServicesLvl3Page("test")(
          FakeRequest(GET, routes.FinanceRealEstateController.loadFinancialServicesLvl3Page("test").url)
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

    "submitFinancialServicesLvl3Page" should {
      "redirect on valid form submission FinancialServicesLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitFinancialServicesLvl3Page("test")(
          FakeRequest(POST, routes.FinanceRealEstateController.submitFinancialServicesLvl3Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadHoldingCompaniesLvl4Page" should {
      "return OK and render the HoldingCompaniesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadHoldingCompaniesLvl4Page("test")(
          FakeRequest(GET, routes.FinanceRealEstateController.loadHoldingCompaniesLvl4Page("test").url)
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

    "submitHoldingCompaniesLvl4Page" should {
      "redirect on valid form submission HoldingCompaniesLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitHoldingCompaniesLvl4Page("test")(
          FakeRequest(POST, routes.FinanceRealEstateController.submitHoldingCompaniesLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadTrustsFundsLvl4Page" should {
      "return OK and render the TrustsFundsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadTrustsFundsLvl4Page("test")(
          FakeRequest(GET, routes.FinanceRealEstateController.loadTrustsFundsLvl4Page("test").url)
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

    "submitTrustsFundsLvl4Page" should {
      "redirect on valid form submission TrustsFundsLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitTrustsFundsLvl4Page("test")(
          FakeRequest(POST, routes.FinanceRealEstateController.submitTrustsFundsLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadOtherFinancialLvl4Page" should {
      "return OK and render the OtherFinancialLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadOtherFinancialLvl4Page("test")(
          FakeRequest(GET, routes.FinanceRealEstateController.loadOtherFinancialLvl4Page("test").url)
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

    "submitOtherFinancialLvl4Page" should {
      "redirect on valid form submission OtherFinancialLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitOtherFinancialLvl4Page("test")(
          FakeRequest(POST, routes.FinanceRealEstateController.submitOtherFinancialLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadMonetaryIntermediationLvl4Page" should {
      "return OK and render the MonetaryIntermediationLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadMonetaryIntermediationLvl4Page("test")(
          FakeRequest(GET, routes.FinanceRealEstateController.loadMonetaryIntermediationLvl4Page("test").url)
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

    "submitMonetaryIntermediationLvl4Page" should {
      "redirect on valid form submission MonetaryIntermediationLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitMonetaryIntermediationLvl4Page("test")(
          FakeRequest(POST, routes.FinanceRealEstateController.submitMonetaryIntermediationLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadInsuranceTypeLvl4Page" should {
      "return OK and render the InsuranceTypeLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadInsuranceTypeLvl4Page("test")(
          FakeRequest(GET, routes.FinanceRealEstateController.loadInsuranceTypeLvl4Page("test").url)
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

    "submitInsuranceTypeLvl4Page" should {
      "redirect on valid form submission InsuranceTypeLvl4Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitInsuranceTypeLvl4Page("test")(
          FakeRequest(POST, routes.FinanceRealEstateController.submitInsuranceTypeLvl4Page("test").url)
        )
        val result = performAction()
        contentAsString(result)
        status(result) shouldBe SEE_OTHER
        redirectLocation(result) shouldBe Some(
          navigator.nextPage(Sector.foodBeverageServiceActivities.toString, "test").url
        )
      }
    }

    "loadInsuranceLvl3Page" should {
      "return OK and render the InsuranceLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.loadInsuranceLvl3Page("test")(
          FakeRequest(GET, routes.FinanceRealEstateController.loadInsuranceLvl3Page("test").url)
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

    "submitInsuranceLvl3Page" should {
      "redirect on valid form submission InsuranceLvl3Page" in {
        inSequence {
          mockAuthWithEnrolment()
        }
        def performAction() = controller.submitInsuranceLvl3Page("test")(
          FakeRequest(POST, routes.FinanceRealEstateController.submitInsuranceLvl3Page("test").url)
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
