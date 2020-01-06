package com.generic;

public class IntegerMatrix extends GenericMatrix<Integer>{
	 
	@Override
	protected Integer add(Integer m1, Integer m2) {
		return m1 + m2;
	}
 
	@Override
	protected Integer multiply(Integer m1, Integer m2) {
		return m1 * m2;
	}
 
	@Override
	protected Integer zero() {
		return 0;
	}
	
 
}
