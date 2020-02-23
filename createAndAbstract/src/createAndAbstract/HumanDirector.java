package createAndAbstract;

public class HumanDirector {
	private HumanBuilder humanBuilder;
 
	public void setHumanBuilder(HumanBuilder humanBuilder) {
		this.humanBuilder = humanBuilder;
	}
 
	public HumanDirector() {
		super();
	}
 
	public HumanDirector(HumanBuilder humanBuilder) {
		super();
		this.humanBuilder = humanBuilder;
	}
 
	// 只负责构建不负责返回
	public void construct() {
		humanBuilder.buildHead();
		humanBuilder.buildBody();
		humanBuilder.buildFoot();
	}
 
}
