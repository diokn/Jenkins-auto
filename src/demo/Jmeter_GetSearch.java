package demo;

import java.io.IOException;

//import org.apache.http.client.ClientProtocolException; 
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class Jmeter_GetSearch extends AbstractJavaSamplerClient {

	private static String label = "Jmeter_GetSearchSuggestion "; // 定义label名称，显示在jmeter的结果窗口
	private String url;
	private String data;

	public void setupTest() {
		// 定义测试初始值，setupTest只在测试开始前使用
		System.out.println("setupTest");
	}

	@Override
	public SampleResult runTest(JavaSamplerContext arg0) {

		url = arg0.getParameter("url");
		data = arg0.getParameter("data");
		SampleResult sr;
		sr = new SampleResult();
		sr.setSampleLabel(label);

//		TestApiGetSearchSuggestion t = new TestApiGetSearchSuggestion();
//		sr.sampleStart();
//		try {
//			// 调用被压测接口的方法
//			t.PostJson(url, data);
//			sr.setSuccessful(true);
//		} catch (ClientProtocolException e) {
//			sr.setSuccessful(false);
//			e.printStackTrace();
//		} catch (IOException e) {
//			sr.setSuccessful(false);
//			e.printStackTrace();
//		}

		sr.sampleEnd(); // jmeter 结束统计响应时间标记
		return sr;
	}

	public void teardownTest(JavaSamplerContext arg0) {
		super.teardownTest(arg0);
	}

	public Arguments getDefaultParameters() {
		// 参数定义，显示在前台，也可以不定义
		Arguments params = new Arguments();
		params.addArgument("url", "http://gapp.test.com/merchandise/GetSearchSuggestion");
		params.addArgument("data", "data={\"token\": \"aaaaaaaaaa\",\"body\": {\"keywords\": \"蓝月亮\"}}");
		return params;
	}

}
