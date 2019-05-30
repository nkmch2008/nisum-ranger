package com.nisum.coding;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.nisum.coding.Ranging;
import com.nisum.coding.ZipCodeRange;

public class ZipRangeTest {
	
	private ArrayList<Ranging> expectedResult;
	
    @Before
    public void setUp() {
    	this.expectedResult = new ArrayList<Ranging>();
    }
    
    @After
    public void tearDown() {
        this.expectedResult.clear();
        ZipCodeRange.clear();
    }

	@Test
	public void ZipCodeRangetestWithData1() {
		setUp();
		Ranging range1 = new Ranging(94133, 94133);
		Ranging range2 = new Ranging(94200, 94299);
		Ranging range3 = new Ranging(94600, 94699);
		
		ZipCodeRange.AddRange(range1);
		ZipCodeRange.AddRange(range2);
		ZipCodeRange.AddRange(range3);
		
		assertEquals( 3, ZipCodeRange.size());
		
		Ranging range11 = new Ranging(94133, 94133);
		Ranging range22 = new Ranging(94200, 94299);
		Ranging range33 = new Ranging(94600, 94699);
		
		expectedResult.add(range11);
		expectedResult.add(range22);
		expectedResult.add(range33);
		
		assertEquals(expectedResult, ZipCodeRange.getZipRanges());
		
		tearDown();
	}
	
	@Test
	public void ZipRangetestWithData2() {
		setUp();
		
		Ranging range1 = new Ranging(94133, 94133);
		Ranging range2 = new Ranging(94200, 94299);
		Ranging range3 = new Ranging(94226, 94399);
		
		ZipCodeRange.AddRange(range1);
		ZipCodeRange.AddRange(range2);
		ZipCodeRange.AddRange(range3);
		
		assertEquals( 2, ZipCodeRange.size());
		
		Ranging range11 = new Ranging(94133, 94133);
		Ranging range22 = new Ranging(94200, 94399);
		
		expectedResult.add(range11);
		expectedResult.add(range22);
		
		assertEquals( expectedResult, ZipCodeRange.getZipRanges());
		
		tearDown();
	}
}
