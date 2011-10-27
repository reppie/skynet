package toctep.skynet.backend.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.User;

public class UserTest extends DomainTest {
		
	@Test
	public void testAddingUser() {
		User preUser = new User();
		assertNotNull(preUser);
		
		String name = "Daniel";
		preUser.setName(name);
		assertTrue(name.equals(preUser.getName()));
		
		userDao.insert(preUser);
		assertEquals(1, userDao.count());
		User postUser = (User) userDao.select(preUser.getId());
		assertTrue(postUser.getName().equals(preUser.getName()));
	}
	
	//@Test
	//public void testUpdatingUser() {
	//	
	//}
	
	@Test
	public void testDeletingUser() {
		User user = new User();
		assertNotNull(user);
		userDao.insert(user);
		assertEquals(1, userDao.count());
		userDao.delete(user);
		assertEquals(0, userDao.count());
	}

}
