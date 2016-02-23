package test.ejb;

import javax.ejb.Remote;

@Remote
public interface MyStatefulRemote {

	int count();

}
