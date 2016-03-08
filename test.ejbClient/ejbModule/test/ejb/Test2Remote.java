package test.ejb;

import java.util.Optional;

import javax.ejb.Remote;

@Remote
public interface Test2Remote {

	String greeting(String key);
	
	void create(String key, String value);

	Optional<String> read(String key);

	void update(String key, String value);

	void delete(String key);

}
