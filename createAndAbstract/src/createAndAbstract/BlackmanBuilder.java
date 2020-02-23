package createAndAbstract;


public class BlackmanBuilder extends HumanBuilder {
 
	private Human blackman = new Human();
	private FactoryProducer factoryProducer = new FactoryProducer();
 
	public void buildHead() {
		// TODO Auto-generated method stub
		AbstractHumanComponentFactory headFactory = factoryProducer.getFactory("head");
		blackman.setHead(headFactory.getHead("black"));
	}
 
	public void buildBody() {
		// TODO Auto-generated method stub
		AbstractHumanComponentFactory bodyFactory = factoryProducer.getFactory("body");
		blackman.setBody(bodyFactory.getBody("black"));
	}
 
	public void buildFoot() {
		// TODO Auto-generated method stub
		AbstractHumanComponentFactory footFactory = factoryProducer.getFactory("foot");
		blackman.setFoot(footFactory.getFoot("black"));
	}
 
	public Human getHuman() {
		// TODO Auto-generated method stub
		return this.blackman;
	}
 
}
