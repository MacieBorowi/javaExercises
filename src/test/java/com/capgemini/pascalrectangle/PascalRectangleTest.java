package com.capgemini.pascalrectangle;

import static org.junit.Assert.*;

import org.junit.Test;

public class PascalRectangleTest {
	
	//@Rule public ExpectedException thrown= ExpectedException.none();
	
	private PascalRectangle i = new PascalRectangle();
	
	@Test//(expected=WrongParameter.class)
	public void shouldNegativRow() {

		// given
		int row = -1;
		int column = 0;

		long result;
		// when
		try {
			result = i.pascal(column,row);
		} catch (WrongParameter e) {
			
		// then
			assertEquals(" Wrong data input ", e.getMessage());
		}
		
		
	}
	
	@Test//(expected=WrongParameter.class)
	public void shouldNegativColumn() {

		// given
		int row = 0;
		int column = -1;

		// when
		try {
			i.pascal(column,row);
		} catch (WrongParameter e) {
			
		// then
			assertEquals(" Wrong data input ", e.getMessage());
		}
		
		
	}
	
	@Test
	
	public void shouldPascalPeakOfRectangle() throws WrongParameter {

		// given
		int row = 0;
		int column = 0;

		// when
		long result = i.pascal(column,row);

		// then
		assertEquals(1, result);
		
	}
	
	@Test
	public void shouldPascalFirsRow() throws WrongParameter {

		// given
		int row = 1;
		int column = 0;

		// when
		long result = i.pascal(column,row);

		// then
		assertEquals(1, result);
		
	}
	
	@Test
	public void shouldPascalLeftEdge() throws WrongParameter {

		// given
		int row = 5;
		int column = 0;

		// when
		long result = i.pascal(column,row);

		// then
		assertEquals(1, result);
		
	}
	
	@Test
	public void shouldPascalRightEdge() throws WrongParameter {

		// given
		int row = 5;
		int column = 5;

		// when
		long result = i.pascal(column,row);

		// then
		assertEquals(1, result);
		
	}
	
	@Test
	public void shouldPascalColumn4Row9() throws WrongParameter {

		// given
		int row = 9;
		int column = 4;

		// when
		long result = i.pascal(column,row);

		// then
		assertEquals(126, result);
		
	}
}
