package createAndAbstract;


public class FactoryProducer {
 
	public AbstractHumanComponentFactory getFactory(String type) {
		if ("head".equals(type)) {
			return new HeadFactory();
		}
		if ("body".equals(type)) {
			return new BodyFactory();
		}
		if ("foot".equals(type)) {
			return new FootFactory();
		}
		return null;
	}
}

