package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class VisaConfirmationTest extends BaseTest {
    StartPage startPage;
    SelectNationalityPage selectNationalityPage;
    ReasonForTravelPage reasonForTravelPage;
    ResultPage resultpage;
    WorkTypePage workTypePage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    DurationOfStayPage durationOfStayPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        startPage = new StartPage();
        selectNationalityPage = new SelectNationalityPage();
        reasonForTravelPage = new ReasonForTravelPage();
        resultpage = new ResultPage();
        workTypePage = new WorkTypePage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
        durationOfStayPage = new DurationOfStayPage();
    }
@Test(groups =  {"smoke","regression"})
public void anAustralianComingToUKForTourism() throws InterruptedException {

//    Click on start button
    Thread.sleep(3000);
      startPage.clickStartNow();
//    Select a Nationality 'Australia'
    selectNationalityPage.selectNationality("Australia");
    //    Click on Continue button
    selectNationalityPage.clickNextStepButton();
//    Select reason 'Tourism'
    reasonForTravelPage.selectReasonForVisit("Tourism");
    //    Click on Continue button
    reasonForTravelPage.clickNextStepButton();
//    verify result 'You will not need a visa to come to the UK'
       resultpage.getResultMessage();


}

@Test(groups = {"sanity","regression"})
public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths(){

//    Click on start button
    startPage.clickStartNow();
//    Select a Nationality 'Chile'
    selectNationalityPage.selectNationality1("Chile");
    //    Click on Continue button
    selectNationalityPage.clickNextStepButton();
//    Select reason 'Work, academic visit or business'
    reasonForTravelPage.selectReasonForVisit2("Work, academic visit or business");
    //    Click on Continue button
   reasonForTravelPage.clickNextStepButton();
    //    Select intendent to stay for 'longer than 6 months'
     durationOfStayPage.selectLengthOfStay("longer than 6 months");
    //    Click on Continue button
    durationOfStayPage.clickOnNextStepButton();
    //    Select have planning to work for 'Health and care professional'
    workTypePage.selectJobType();
    //    Click on Continue button
    workTypePage.clickNextStepButton();
    //    verify result 'You will not need a visa to come to the UK'
   resultpage.getResultMessage1();



}
@Test(groups = {"sanity","smoke","regression"})
public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(){

    //    Click on start button
    startPage.clickStartNow();
//    Select a Nationality 'Colombia'
    selectNationalityPage.selectNationality2("Colombia");
    //    Click on Continue button
    selectNationalityPage.clickNextStepButton();
//    Select reason 'Join partner or family for a long stay'
    reasonForTravelPage.selectReasonForVisit1("Join partner or family for a long stay");
    //    Click on Continue button
   reasonForTravelPage.clickNextStepButton();
    //    verify result 'You may need visa'
   resultpage.getResultMessage2();


}
}
