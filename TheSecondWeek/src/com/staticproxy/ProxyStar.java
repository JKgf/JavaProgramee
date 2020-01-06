package com.staticproxy;

public class ProxyStar implements Star{
	
	private Star star;
	public ProxyStar(Star star) {
		super();
		this.star = star;
	}
	
	@Override
	public void confer() {
		// TODO Auto-generated method stub
		System.out.println("ProxyStar.confer()");
	}

	@Override
	public void signContract() {
		// TODO Auto-generated method stub
		System.out.println("ProxyStar.signContract()");
		
	}

	@Override
	public void bookTicket() {
		// TODO Auto-generated method stub
		System.out.println("ProxyStar.bookTicket()");
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		star.sing();
	}

	@Override
	public void collect() {
		// TODO Auto-generated method stub
		System.out.println("ProxyStar.collect()");
	}

}

