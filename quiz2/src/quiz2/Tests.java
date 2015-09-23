package quiz2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class Tests {

	
//my test cases to test my two methods
	tuition Test1 = new tuition(5000, .02, .07, 7);
	tuition Test2 = new tuition(24000, .07, .09, 15);
	tuition Test3 = new tuition(12000, .04, .05, 5);
	
	//this sets the tests to the monthly pay and the fullTuition
	@Before
	public void setUp() throws Exception{
		Test1.tuitionFourYears();
		Test2.tuitionFourYears();
		Test3.tuitionFourYears();
		
		Test1.monthly();
		Test2.monthly();
		Test3.monthly();
	}
	
	//test cases for my monthly pay
	@Test
	public void testMonthly() {
		Test1.getMonthlyPay();
		assertTrue(Test1.getMonthlyPay() == 191.8);
		Test2.getMonthlyPay();
		assertTrue(Test2.getMonthlyPay() == 287.04);
		Test3.getMonthlyPay();
		assertTrue(Test3.getMonthlyPay() == 757.25);
	}
	
	//test cases for my fullTuition
	@Test
	public void testTuition(){
		Test1.getFullTuition();
		assertTrue(Test1.getFullTuition() == 20714.16);
		Test2.getFullTuition();
		assertTrue(Test2.getFullTuition() == 108616.7);
		Test3.getFullTuition();
		assertTrue(Test3.getFullTuition() == 51497.5);
	}

}
