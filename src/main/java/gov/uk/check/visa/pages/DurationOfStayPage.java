package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class DurationOfStayPage extends Utility {
    public DurationOfStayPage(){
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(id="response-0")
    WebElement clickOnLongerThanSixMonth;

    @CacheLookup
    @FindBy(id="response-1")
    WebElement clickOnLessThanSixMonth;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement clickOnContinueButton;

    public void selectLengthOfStay(String moreOrLess){
        clickOnElement1(clickOnLessThanSixMonth);

//        switch (moreOrLess){
//            case "clickOnLessThanSixMonth":
//                System.out.println("6 months or less");
//                break;
//            case "clickOnLongerThanSixMonth":
//                System.out.println("longer than 6 months");
//                break;
//            default:
//                System.out.println("Error message");
//        }
    }
    public void clickOnNextStepButton(){
        Reporter.log("click on start now " + clickOnContinueButton);
        mouseHoverToElementAndClick1(clickOnContinueButton);
        CustomListeners.test.log(Status.PASS,"mouseHover To Element And Click");
    }
}
