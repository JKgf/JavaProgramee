package createAndAbstract;


public class HeadFactory extends AbstractHumanComponentFactory {
 
	@Override
	public Head getHead(String type) {
		// TODO Auto-generated method stub
		if ("black".equals(type)) {
			return new BlackmanHead();
		}
		if ("white".equals(type)) {
			return new WhitemanHead();
		}
		return null;
	}
 
	@Override
	public Body getBody(String type) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public Foot getFoot(String type) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
