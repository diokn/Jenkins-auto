package demo;

import java.util.Date;

/**
 * 
 * @author gliu067
 *
 *  被测试类
 */
public class TestDemo {
	
	public static void main(String[] args) {

		System.out.println("starting time:" + new Date(System.currentTimeMillis()));
	}
	
	public int tDemo(int a, int b){
		
		int sum = a + b;
		return sum;
	}

}
