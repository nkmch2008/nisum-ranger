package com.nisum.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ZipCodeRange {

	private static ArrayList<Ranging> rangeZipCodeList = new ArrayList<Ranging>();

	public static void main(String[] args) {

        System.out.println("Input values = [94133,94133] [94200,94299] [94600,94699] ");
   
	    Ranging range1 = new Ranging(94133,94133);
		Ranging range2 = new Ranging(94200,94299);
		Ranging range3 = new Ranging(94600,94699);
		ZipCodeRange.AddRange(range1);
		ZipCodeRange.AddRange(range2);
		ZipCodeRange.AddRange(range3);
		 
		/*System.out.println("input given values = [94133,94133] [94200,94299] [94226,94399] ");
		 
		Ranging range1 = new Ranging(94133,94133);
		Ranging range2 = new Ranging(94200,94299);
		Ranging range3 = new Ranging(94226,94399);
		ZipCodeRange.AddRange(range1);
		ZipCodeRange.AddRange(range2);
		ZipCodeRange.AddRange(range3); */
		
		displayZipCodeRange();
	}

	public static void AddRange(Ranging toAdd) {
		if (rangeZipCodeList.size() == 0)
			rangeZipCodeList.add(toAdd);
		else {
			ListIterator<Ranging> iter = rangeZipCodeList.listIterator();
			boolean add = true; 
			while (iter.hasNext()) {
				add = checkRanges(toAdd, iter);
			} 
			if (add)
				rangeZipCodeList.add(toAdd);
		}  

	}

	private static boolean checkRanges(Ranging toAdd, ListIterator<Ranging> iter) {
		boolean add;
		Ranging range = iter.next();
		if (range.getLowerValue() <= toAdd.getLowerValue() && range.getUpperValue() >= toAdd.getUpperValue()) {
			add = false;
		}
		else if (range.getLowerValue() > toAdd.getUpperValue() || range.getUpperValue() < toAdd.getLowerValue()) {
			add = true;
		}
		else {
			if (range.getLowerValue() < toAdd.getLowerValue())
				toAdd.setLowerValue(range.getLowerValue());
			if (range.getUpperValue() > toAdd.getUpperValue())
				toAdd.setUpperValue(range.getUpperValue());
			iter.remove();
			add = true;
		}
		return add;
	}

	public static void displayZipCodeRange() {
		if (rangeZipCodeList.size() > 0) {
			for (Ranging range : rangeZipCodeList) {
				System.out.println("Output values are "+range.toString());
			}
		}
	}

	public static int size() {
		return rangeZipCodeList.size();
	}

	public static List<Ranging> getZipRanges() {
		return rangeZipCodeList;
	}

	public static void clear() {
		rangeZipCodeList.clear();
	}

}
