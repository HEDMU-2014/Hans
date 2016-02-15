package test.ejb;

import javax.ejb.Local;

@Local
public interface Test2Local {

	String greeting(String key);

}
