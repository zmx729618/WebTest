package zmx.test;

public class GreatestCommonDivisor {
	
	private static int gcd(int a, int b){
		if(a%b==0){
			return b;
		}else{
			return gcd(b,(a%b));
		}
	}
	
	
	public static int getGreatestCommonDivisor(int numberA,int numberB){
		int result=1;
		if(numberA>numberB){
			return gcd(numberA, numberB);
		}else{
			return gcd(numberB,numberA);
		}

	}
	
	public static void main(String[] args) {
		System.out.println(getGreatestCommonDivisor(68,7834));
	}

}
