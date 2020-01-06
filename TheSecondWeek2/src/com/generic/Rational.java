package com.generic;

public class Rational extends Number{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6107969239665386445L;
	private long num = 0;
	private long nomi = 1;
	public Rational(){
		this(0,1);
	}
	public Rational(long num1,long num2){
		long gcd = gcd(num1,num2);
		this.num = (num2 > 0 ? 1 :-1) * num1 / gcd;
		this.nomi = Math.abs(num2)/gcd;
	}
	private static long gcd(long n, long d){
		long n1 = Math.abs(n);
		long n2 = Math.abs(d);
		int gcd = 1;
		for(int k = 1; k <= n1 && k <= n2; k++){
			if(n1 % k == 0&&n2%k==0)
				gcd=k;
		}
		return gcd;
	}
	public String toString(){
		if(nomi==1)
			return num+"";
		else
			return num+"/"+nomi;
	}
	@Override
	public double doubleValue() {
		return num * 1.0/nomi;
	}
	@Override
	public float floatValue() {
		return (float) doubleValue();
	}
	@Override
	public int intValue() {
		return (int) doubleValue();
	}
	@Override
	public long longValue() {
		return (long) doubleValue();
	}
	public long getnum(){
		return num;
	}
	public long Getnomi(){
		return nomi;
	}
	public Rational add(Rational second){
		long n = num * second.Getnomi() + nomi * second.getnum();
		long d = nomi * second.Getnomi();
		return new Rational(n,d);
	}
	public Rational multiply(Rational second){
		long n = num * second.getnum();
		long d = nomi * second.Getnomi();
		return new Rational(n,d);
	}
 
}
