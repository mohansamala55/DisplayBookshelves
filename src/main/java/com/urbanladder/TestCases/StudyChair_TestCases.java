package com.urbanladder.TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.urbanladder.BaseClasses.BaseClass;
import com.urbanladder.PageClasses.LandingPage;
import com.urbanladder.PageClasses.StudyChairsPage;
/*
 * @author Soundarya (2163742);
 */
public class StudyChair_TestCases extends BaseClass {
	LandingPage landingpage;
	StudyChairsPage studychairspage;

	@Test
	public void studychair_TestCases() {
		test = extent.createTest("StudyChair_TestCase");
		invokeBrowser("chrome");
		landingpage = openWedsite();
		studychairspage = landingpage.enterStudyChairs();
		studychairspage.studyChairs();
		quitBrowser();
		test.log(Status.PASS, "Study Chairs Displayed Successfully");
		
	}
}
