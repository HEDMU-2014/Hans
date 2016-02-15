package test.ejb;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
