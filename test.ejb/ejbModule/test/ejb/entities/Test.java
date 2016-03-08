package test.ejb.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Test
 *
 */
@Entity

public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String key;

	private String value;

	public Test() {
		super();
	}   
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}   
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
   
}
