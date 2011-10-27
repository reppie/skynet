package toctep.skynet.backend.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.User;

public class UserTest extends DomainTest {
	
	@Test
	public void testCreatingUser() { 
		User preUser = new User();
		assertNotNull(preUser);
		
		boolean defaultProfile = false;
		preUser.setDefaultProfile(defaultProfile);
		assertTrue(preUser.isDefaultProfile() == defaultProfile);
		
		int statusesCount = 1;
		preUser.setStatusesCount(statusesCount);
		assertEquals(statusesCount, preUser.getStatusesCount());
		
		String name = "Daniel";
		preUser.setName(name);
		assertTrue(name.equals(preUser.getName()));
	}
	
	@Test
	public void testInsertUser() {
		User preUser = new User();
		
		String name = "Test";
		preUser.setName(name);
		
		userDao.insert(preUser);
		assertEquals(1, userDao.count());
		
		User postUser = (User) userDao.select(preUser.getId());
		assertTrue(postUser.getName().equals(preUser.getName()));
		// TODO
	}
	
	@Test
	public void testUpdatingUser() {
		// TODO
	}
	
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
