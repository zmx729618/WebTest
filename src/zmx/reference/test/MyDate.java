package zmx.reference.test;

import java.util.Date;

public class MyDate extends Date { 


	private static final long serialVersionUID = 9031930379799167096L;

	/** Creates a new instance of MyDate */
    public MyDate() {
    
    }
    // 覆盖finalize()方法
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("obj [Date: " + this.getTime() + "] is gc");
    }   

    public String toString() {
        return "Date: " + this.getTime();
    }
}
