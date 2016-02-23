package test.ejb;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

import test.domain.MyNumber;

/**
 * Session Bean implementation class MyStateful
 */
@Singleton
public class MyStateful implements MyStatefulRemote, MyStatefulLocal {

	private int count = 0;
	
	@Override
	@Lock(LockType.WRITE)
	public MyNumber count() {
		return new MyNumber(++count);
	}
	
	

}
