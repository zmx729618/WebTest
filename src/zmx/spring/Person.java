package zmx.spring;

public class Person {
private Hand[] hands;
	
	public Hand[] getHands() {
		return hands;
	}

	public void setHands(Hand[] hands) {
		this.hands = hands;
	}

	public class Hand {
		private int strength;

		public int getStrength() {
			return strength;
		}
		public void setStrength(int strength) {
			this.strength = strength;
		}
		
	}


}
