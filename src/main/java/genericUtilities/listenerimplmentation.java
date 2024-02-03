package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listenerimplmentation implements ITestListener {

	private Object web;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"Execution starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"success");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"Fail");
		System.out.println("Failed due to :"+result.getThrowable());
		Webdriverutility web=new  Webdriverutility();
		web.captureScreenshot(BaseClass.sdriver,BaseClass.sjutil,result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"skipped");
		System.out.println("Skipped due to "+result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("suite Execution starts");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	

}
