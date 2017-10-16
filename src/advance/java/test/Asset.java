package advance.java.test;

public class Asset {
	
	private int id;
	private String  type;
	
	

	public Asset(){
		System.out.println("Create Asset ...");
	}
	
	

	public Asset(int id, String type) {
		super();
		this.id = id;
		this.type = type;
		System.out.println("Create Asset ...");
	}
	

	public Asset(String type, int id) {
		super();
		this.id = id;
		this.type = type;
		System.out.println("Create Asset ...");
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
