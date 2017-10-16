package program.test;

public class ClonabledObj implements Cloneable{
	
    private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
    
	
    
    
}
