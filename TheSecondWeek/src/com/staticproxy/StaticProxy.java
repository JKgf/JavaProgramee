package com.staticproxy;

public class StaticProxy {

	/* 老师上课所讲的代码
	 * public interface Speakable{ public void speak(String message); }
	 * 
	 * public class Person implements Speakable{
	 * 
	 * @Override public void speak(String message) { // TODO Auto-generated method
	 * stub System.out.println("Speak : " + message); } }
	 * 
	 * public class PersonProxy implements Speakable{ private Person person; public
	 * PersonProxy(Person preson) { this.person = person; }
	 * 
	 * @Override public void speak(String message) { // TODO Auto-generated method
	 * stub this.person.speak(message); System.out.println("运行时间: " +
	 * System.currentTimeMillis()); } } public class Bootsrap{ public static void
	 * main(String[] args) { Person person = new Person(); PersonProxy proxy = new
	 * PersonProxy(person); proxy.speak("Lesson one!"); } }
	 */
	 public static void main(String[] args) {
		Star real = new RealStar();
		Star proxy = new ProxyStar(real);
		
		proxy.confer();
		proxy.signContract();
		proxy.bookTicket();
		proxy.sing();
		proxy.collect();
	}
	
	
}