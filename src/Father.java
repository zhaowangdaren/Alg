
public class Father {
	public String version = "1.0";
	private String name;
	
	private void initName(){
		this.name = "father";
	}
	
	protected void reInitName(){
		this.name = "father";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
