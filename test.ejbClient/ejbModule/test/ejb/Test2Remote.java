package test.ejb;

import javax.ejb.Remote;

@Remote
public interface Test2Remote {

	String greeting(String key);

}
