package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.sourcetype.ISourceType;
import toctep.skynet.backend.dal.domain.sourcetype.NullSourceType;
import toctep.skynet.backend.dal.domain.sourcetype.SourceType;
import toctep.skynet.backend.test.SkynetTest;

public class SourceTypeTest extends SkynetTest implements IDomainTest {

	private SourceType sourceType;
	
	private String text;
	
	@Override
	public void setUp() {
		super.setUp();
		
		sourceType = new SourceType();
		
		text = "Web";
		sourceType.setText(text);
	}
	
	@Test
	public void testCreate() {
		assertNotNull(sourceType);
		assertTrue(text.equals(sourceType.getText()));
	}

	@Test
	public void testInsert() {
		sourceType.save();
		assertEquals(1, SourceType.count());
		assertTrue(new Integer(1).equals(sourceType.getId()));
	}
	
	@Test
	public void testSelect() {
		sourceType.save();
		
		ISourceType postSourceType = SourceType.select(sourceType.getId());
		assertTrue(postSourceType.getText().equals(sourceType.getText()));
		
		ISourceType nullSourceType = SourceType.select(1000);
		assertTrue(nullSourceType instanceof NullSourceType);
	}
	
	@Test
	public void testDelete() {
		sourceType.save();
		assertEquals(1, SourceType.count());
		sourceType.delete();
		assertEquals(0, SourceType.count());
	}

	@Test
	public void testExists() {
		sourceType.save();
		assertTrue(SourceType.exists(sourceType));
	}
	
}
