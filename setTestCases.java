import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class setTestCases {
	SetImplementation test;

	@BeforeEach
	void setUp() throws Exception {
		test = new SetImplementation();
	}
	@Test
	void isEmptyTest() {
		assertTrue(test.isEmpty());
	}
	
	@Test
	void addTest() {
		assertTrue(test.add(8));
	}
	
	@Test
	void addMultipleTest() {
		for(int i=0;i<5;i++)
		assertTrue(test.add(i));
		assertFalse(test.remove(100));
	}
	
	@Test
	void addDuplicateTest() {
		assertTrue(test.add(50));
		assertFalse(test.add(50));
	}
	
	@Test
	void containsTest() {
		assertTrue(test.add(50));
		assertTrue(test.contains(50));
		assertFalse(test.contains(5));
	}
	
	@Test
	void sizeTest() {
		assertTrue(test.add(50));
		assertEquals(1,test.size());
		assertFalse(test.contains(5));
	}
	
	@Test
	void removeTest() {
		assertTrue(test.add(50));
		assertTrue(test.add(0));
		assertTrue(test.add(5));
		assertTrue(test.add(6));
		assertTrue(test.add(33));
		assertTrue(test.remove(50));
	}
	
	@Test
	void removeNonExistingTest() {
		assertFalse(test.remove(50));
	}
	
	@Test
	void containsEmptySetTest() {
		assertFalse(test.contains(50));
	}
	
	@Test
	public void TestSetInsetExtremelyLarge(){
		int extremelyLargeInt = 90;
		for(int i = 0; i< extremelyLargeInt; i++){
			test.add(i);
		}
		assertEquals(extremelyLargeInt, test.size());
				
	}
}