package com.leet.code;

public class PhoneNumber implements Cloneable {

	private String start;

	private String mid;

	private String end;

	public PhoneNumber(String start, String mid, String end) {
		this.start = start;
		this.mid = mid;
		this.end = end;
	}

	@Override
	public PhoneNumber clone() {
		try {
			return (PhoneNumber) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	@Override
	public int hashCode() {
		int result;
		result = start.hashCode();
		result = 31 * result + mid.hashCode();
		result = 31 * result + end.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof PhoneNumber) {
			PhoneNumber oPhoneNumber = (PhoneNumber) o;
			if (oPhoneNumber.start.equals(this.start) &&
					oPhoneNumber.mid.equals(this.mid) &&
					oPhoneNumber.end.equals(this.end)) {
				return true;
			}
		}
		return false;
	}
}
