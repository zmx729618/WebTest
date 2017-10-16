package org.zwc.testweb.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


@MappedSuperclass
public class BaseIdEntity implements Serializable, Cloneable
{
   
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Object clone()
    {
      Object o = null;
      try
      {
        o = super.clone();
      }
      catch (CloneNotSupportedException e)
      {
        System.out.println(e.toString());
      }
      return o;
    }

}
