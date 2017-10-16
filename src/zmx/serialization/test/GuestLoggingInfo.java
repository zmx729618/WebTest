package zmx.serialization.test;

import java.io.Serializable;
import java.util.Date;

public class GuestLoggingInfo implements Serializable {

	private static final long serialVersionUID = -4377820862232402359L;
	public static long size = 0L;
	private Date loggingDate = new Date();
	private String uid;
	private transient String pwd;
    GuestLoggingInfo()   
    {   
        uid = "guest";   
        pwd = "guest";   
    }

	GuestLoggingInfo(String user, String password) {
		uid = user;
		pwd = password;
	}

	public String toString() {
		String password = null;
		if (pwd == null) {
			password = "NOT SET";
		} else {
			password = pwd;
		}
		return "logon info: \n   " + "user: " + uid + "\n   logging date : "
				+ loggingDate.toString() + "\n   password: " + password+" size : "+ size;
	}

}
