package createAndAbstract;

public abstract class AbstractHumanComponentFactory {
	 
	abstract public Head getHead(String type);
	abstract public Body getBody(String type);
	abstract public Foot getFoot(String type);
}
