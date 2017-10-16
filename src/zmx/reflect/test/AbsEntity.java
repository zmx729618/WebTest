package zmx.reflect.test;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public class AbsEntity {
	 @Id
	 @GeneratedValue
	 public String id;
	 
	 public String getId() {
			return id;
		}

	 public void setId(String id) {
			this.id = id;
		}

}
