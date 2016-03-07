package test.ejb;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import test.ejb.entities.Test;

/**
 * Session Bean implementation class Test2
 */
@Stateless
@WebService
public class Test2 implements Test2Remote, Test2Local {
	@PersistenceContext private EntityManager em;

	@Override
	public String greeting(String key) {
		test.ejb.entities.Test test = em.find(test.ejb.entities.Test.class, key);
		if (test != null) {
			return "Hi " + test.getValue();
		} else {
			return "Hi unknown";
		}
	}
	
	@Override
	public void create(String key, String value) {
		test.ejb.entities.Test test = new Test();
		test.setKey(key);
		test.setValue(value);
		em.persist(test);
	}
	
	@Override
	public String read(String key) {
		test.ejb.entities.Test test = em.find(test.ejb.entities.Test.class, key);
		return test.getValue();
	}
	
	@Override
	public void update(String key, String value) {
		test.ejb.entities.Test test = em.find(test.ejb.entities.Test.class, key);
		test.setValue(value);
	}
	
	@Override
	public void delete(String key) {
		test.ejb.entities.Test test = em.find(test.ejb.entities.Test.class, key);
		em.remove(test);
	}

}
