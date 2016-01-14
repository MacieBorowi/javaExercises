package com.capgemini.pascalrectangle;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PascalRectangleTest {
	
	//@Rule public ExpectedException thrown= ExpectedException.none();
	
	private PascalRectangle i = new PascalRectangle();
	
	@Test//(expected=WrongParameter.class)
	public void shouldNegativRow() {

		// given
		int r = -1;
		int c = 0;

		// when
		long result;
		try {
			result = i.pascal(c,r);
		} catch (WrongParameter e) {
			
		// then
			assertEquals(" Wrong data input ", e.getMessage());
		}
		
		
	}
	
	@Test
	
	public void shouldPascalColumn0Row0() throws WrongParameter {

		// given
		int r = 0;
		int c = 0;

		// when
		long result = i.pascal(c,r);

		// then
		assertEquals(1, result);
		
	}
	
	@Test
	public void shouldPascalColumn0Row1() throws WrongParameter {

		// given
		int r = 1;
		int c = 0;

		// when
		long result = i.pascal(c,r);

		// then
		assertEquals(1, result);
		
	}
	
	@Test
	public void shouldPascalColumn1Row1() throws WrongParameter {

		// given
		int r = 1;
		int c = 1;

		// when
		long result = i.pascal(c,r);

		// then
		assertEquals(1, result);
		
	}
	
	@Test
	public void shouldPascalColumn5Row5() throws WrongParameter {

		// given
		int r = 5;
		int c = 5;

		// when
		long result = i.pascal(c,r);

		// then
		assertEquals(1, result);
		
	}
	
	@Test
	public void shouldPascalColumn4Row9() throws WrongParameter {

		// given
		int r = 9;
		int c = 4;

		// when
		long result = i.pascal(c,r);

		// then
		assertEquals(126, result);
		
	}
}
