package createAndAbstract;

public class Client {
	public static void main(String[] args) {
		BlackmanBuilder blackmanBuilder = new BlackmanBuilder();
		HumanDirector blackmanDirector = new HumanDirector(blackmanBuilder);
		blackmanDirector.construct();
		Human blackman = blackmanBuilder.getHuman();
		System.out.println("black man performs------------");
		blackman.getHead().function();
		blackman.getBody().function();
		blackman.getFoot().function();
		WhitemanBuilder whitemanBuilder = new WhitemanBuilder();
		HumanDirector whitemanDirector = new HumanDirector(whitemanBuilder);
		whitemanDirector.construct();
		Human whiteman = whitemanBuilder.getHuman();
		System.out.println("white man performs------------");
		whiteman.getHead().function();
		whiteman.getBody().function();
		whiteman.getFoot().function();
	}

}
