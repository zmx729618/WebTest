package zmx.poi.test.poi;

public class Student {
	
	    private String name;  
	    private String gender;  
	    private int age;  
	    private String sclass;  
	    private int score;  
	    public Student() {}  
	    public Student(String name, String gender, int age, String sclass, int score) {  	  
	        this.name = name;  
	        this.gender = gender;  
	        this.age = age;  
	        this.sclass = sclass;  
	        this.score = score;  
	    }	    
	    	    
	    public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getSclass() {
			return sclass;
		}
		public void setSclass(String sclass) {
			this.sclass = sclass;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		@Override  
	    public String toString() {  
	        return "Student [age=" + age + ", gender=" + gender + ", name=" + name  
	                + ", sclass=" + sclass + ", score=" + score + "]";  
	    }


}
