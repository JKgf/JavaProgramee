package createAndAbstract;


public class WhitemanBuilder extends HumanBuilder{
 
	private Human whiteman = new Human();
	private FactoryProducer factoryProducer = new FactoryProducer();
	
	@Override
	public void buildHead() {
		// TODO Auto-generated method stub
		//这里通过上面实行的抽象工厂来获得部件
		AbstractHumanComponentFactory headFactory = factoryProducer.getFactory("head");
		whiteman.setHead(headFactory.getHead("white"));
	}
 
	@Override
	public void buildBody() {
		// TODO Auto-generated method stub
		//这里通过上面实现的抽象工厂来获得部件
		AbstractHumanComponentFactory bodyFactory = factoryProducer.getFactory("body");
		whiteman.setBody(bodyFactory.getBody("white"));
	}
 
	@Override
	public void buildFoot() {
		// TODO Auto-generated method stub
		//这里通过上面实现的抽象工厂方法来获得部件
		AbstractHumanComponentFactory footFactory = factoryProducer.getFactory("foot");
		whiteman.setFoot(footFactory.getFoot("white"));
	}
 
	@Override
	public Human getHuman() {
		// TODO Auto-generated method stub
		return this.whiteman;
	}
 
}
