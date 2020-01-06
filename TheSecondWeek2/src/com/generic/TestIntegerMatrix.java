package com.generic;

public class TestIntegerMatrix {
	public static void main(String args[]) {
		Integer[][] m1 = new Integer[][] { 
			{ 1, 2, 3 }, 
			{ 4, 5, 6 }, 
			{ 7, 8, 9 } 
		};
		
		Integer[][] m2 = new Integer[][] { 
			{ 2, 3, 4 }, 
			{ 5, 6, 7 }, 
			{ 8, 9, 0 } 
		};
		
		IntegerMatrix integerMatrix = new IntegerMatrix();
		
		System.out.println("\n m1 + m2 =:\t");
		
		GenericMatrix.printResult(m1, m2, integerMatrix.addMatrix(m1, m2), '+');
		
		System.out.println("\n m1 * m2 =: \t");
		
		GenericMatrix.printResult(m1, m2, integerMatrix.mulyiplyMartix(m1, m2), '+');
		
	}
}
