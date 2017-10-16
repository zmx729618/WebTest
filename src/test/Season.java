package test;

public enum Season {
	
	Spring("春"),Summer("夏"),Autumn("秋"),Winter("冬");
	
	private String description;
	
	private Season(String description) {
		this.description = description;
	}
	
	public String getDescription(){
		return description;
	}
	
	public static Season getComfortableSeason(){
		return Spring;
		
	}
	
	public static void main(String[] args) {
		
		for(Season s : Season.values()){
			System.out.println(s);
		}
		System.out.println(Season.getComfortableSeason());
		
		System.out.println(Season.Spring.getDescription());
	}

}
