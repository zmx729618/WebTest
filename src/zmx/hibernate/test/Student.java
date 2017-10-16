package zmx.hibernate.test;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="t_student")
public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3664431508596238922L;
	
	@Id
	@GenericGenerator(name="uu_id", strategy="uuid")
	@GeneratedValue(generator="uu_id")
	private String id;
	
	private String name;
	
	@Version
	@Column(name = "version")  
	private int version;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	

}
