package demo;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;  //provide context information to a JavaSamplerClient implementation
import org.apache.jmeter.samplers.SampleResult;  //a nice packaging for the various information returned from taking a sample of an entry

public class PerformanceTest extends AbstractJavaSamplerClient {
	
	private static SampleResult results;
	private static long start = 0;
	private static long end = 0;
	
	
	
	public void setupTest(JavaSamplerContext jsc){    //每个线程测试前执行一次，做一些初始化工作

		start = System.currentTimeMillis();   //starting time
		
	}
	
	public void teardownTest(JavaSamplerContext jsc){
		end = System.currentTimeMillis();    //ending time
		System.err.println("total cost of time :" + (end - start)/1000);  //elapsed time
		
	}
	
	public Arguments getDefaultParameters(){    //获取界面的参数
		Arguments args = new Arguments();  //A set of Argument objects.
		args.addArgument("testStr", "");
		return args;
		
	}
	

	@Override
	public SampleResult runTest(JavaSamplerContext jsc) {
		// TODO Auto-generated method stub
		
		results.sampleStart();            //Record the start time of a sample
		results.setSuccessful(true);      //Sets the successful attribute of the SampleResult object.
		results.sampleEnd(); 			  //Record the end time of a sample and calculate the elapsed time
		
		return results;
	}
	
	

}
