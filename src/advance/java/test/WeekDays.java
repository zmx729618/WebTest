package advance.java.test;

public enum WeekDays {
	
	MONDAY(1) {
		@Override
		String whatToDo() {
			
			return "Worship";
		}
	},
	TUESDAY(2) {
		@Override
		String whatToDo() {
			
			return "Maintain";
		}
	},WEDNESDAY(3) {
		@Override
		String whatToDo() {
			return "Work";
		}
	},THURSDAY(4) {
		@Override
		String whatToDo() {
			
			return "think";
		}
	},FRIDAY(5) {
		@Override
		String whatToDo() {
			
			return "freedom";
		}
	},SATURDAY(6) {
		@Override
		String whatToDo() {
			return "train";
		}
	},SUNDAY(7) {
		@Override
		String whatToDo() {			
			return "rest";
		}
	};
	
	private int number;
	
	private WeekDays(int number) {
		this.number = number;
	}	
	
	abstract String whatToDo();
	
	
	public int getNumber() {
		return number;
	}


	@Override
	public String toString() {
		String s = super.toString();
		return  s.substring(0,1) + s.substring(1).toLowerCase();
	}

	public static void main(String[] args) {
		
		for(WeekDays wd : WeekDays.values()){
			
			System.out.println(wd + ": "+ wd.ordinal() +": "+wd.name()+": "+wd.getNumber()+": "+wd.whatToDo());
		}
		
		System.out.println(TUESDAY.compareTo(MONDAY));
		System.out.println(TUESDAY.compareTo(TUESDAY));
		System.out.println(TUESDAY.compareTo(WEDNESDAY));
		
		
		
	}

}
