package test.domain;

import java.io.Serializable;

public class MyNumber implements Serializable {
	private static final long serialVersionUID = 1L;
	private int i;
	
	public MyNumber(int i) {
		this.i = i;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}
