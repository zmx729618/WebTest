package zmx.reference.test;

import java.lang.ref.WeakReference;

public class Car {
	
	private double price;
	private String colour;
	
	public Car(double price, String colour){
		this.price = price;
		this.colour = colour;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public String toString(){
		return colour +"car costs $"+price;
	}
	
	
	public static void main(String[] args) {
		
		 
		
		Car car = new Car(22000,"silver");
		
		WeakReference<Car> weakCar = new WeakReference<Car>(car);
		car = null;
		int i=0;
		while(true){
			if(weakCar.get()!=null){
				i++;
				System.out.println("Object is alive for "+i+" loops - "+weakCar);
				System.out.println(weakCar.get());
				
			}else{
				
				System.out.println("Object has been collected.");
				break;
			}
		}
	}



}
