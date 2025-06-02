package DemoTests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class TestOne {

	Response res;
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void setReportprops() {
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("<b> QA Name:</b> ", "<b> Yashvant A </b>");
		extent.setSystemInfo("Machine Name", System.getenv("COMPUTERNAME")); // Windows
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
	}

	@Test

	public void checkRestApis() {
		test=extent.createTest("Check API Req","<b> Req URL :- </b>"+"<b> https://reqres.in/api/users?page=2</b>");
		res=RestAssured.get("https://reqres.in/api/users?page=2");

		test.info("<b> Status Code: </b>" + res.getStatusCode());
		test.info("<b> Response Time: </b>" + res.getTime() + " ms");
		test.info("<b> Content-Type: </b>" + res.getHeader("Content-Type"));
		test.info("<b> Status Line: </b>" + res.statusLine());
		test.info("<b> Response Body: <pre> </b>" + res.getBody().asPrettyString() + "</pre>");
		int statusCode=res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@AfterTest
	public void getreport() {

		extent.flush();
	}

}
