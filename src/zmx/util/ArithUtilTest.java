package zmx.util;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Random;

import junit.framework.Assert;

import org.junit.Test;

public class ArithUtilTest {

	@Test
	public void testAdd() {
		
		Assert.assertEquals(6.02, ArithUtil.add(0.01, 6.01));
	}

	@Test
	public void testSub() {
		for(int i = 0; i < 10; i++)    
	    {    
			double number = Math.random();    
			System.out.println(number);    
		}

		//Date date = new Date();    
		//long timeMill = date.getTime();    
		//System.out.println(timeMill);    
		Random rand = new Random();    
		for(int i = 0; i < 20; i++)    
		{    
		     System.out.println(rand.nextInt(50));    
		}

	}

	@Test
	public void testMul() {
		fail("Not yet implemented");
	}

	@Test
	public void testDivDoubleDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testDivDoubleDoubleInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testRound() {
		fail("Not yet implemented");
	}

}
