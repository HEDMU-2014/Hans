package test.ejb;

import javax.ejb.Local;

@Local
public interface Test2Local {

	String greeting(String key);

	void create(String key, String value);

	String read(String key);

	void update(String key, String value);

	void delete(String key);

}
