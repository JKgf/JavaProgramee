package com.generic;


public class RationalMatrix extends GenericMatrix<Rational>{
	@Override
	protected Rational add(Rational m1, Rational m2) {
		return m1.add(m2);
	}
 
	@Override
	protected Rational multiply(Rational m1, Rational m2) {
		return m1.multiply(m2);
	}
	
	@Override
	protected Rational zero() {
		return new Rational(0,1);
	}
 
}
