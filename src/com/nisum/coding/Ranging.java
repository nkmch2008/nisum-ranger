package com.nisum.coding;

public class Ranging {
	private int lowerValue;
	private int upperValue;

	public Ranging(int lowerValue, int upperValue) {
		if (lowerValue <= upperValue) {
			this.lowerValue = lowerValue;
			this.upperValue = upperValue;
		} else {
			this.lowerValue = upperValue;
			this.upperValue = lowerValue;
		}
	}

	public int getLowerValue() {
		return lowerValue;
	}

	public void setLowerValue(int lowerValue) {
		this.lowerValue = lowerValue;
	}

	public int getUpperValue() {
		return upperValue;
	}

	public void setUpperValue(int upperValue) {
		this.upperValue = upperValue;
	}

	public String toString() {
		return String.format("['%d','%d']", lowerValue, upperValue);
	}

	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof Ranging) {
			Ranging that = (Ranging) other;
			result = (this.getLowerValue() == that.getLowerValue() && this.getUpperValue() == that.getUpperValue());
		}
		return result;
	}
}
