package test.java;
import org.junit.jupiter.api.Test;

import main.java.Reference;

import static org.junit.jupiter.api.Assertions.*;


public class ReferenceTests {
	
	@Test 
	void equality_test() {
		Reference reference = new Reference(15);
		assertEquals(reference, reference);
		reference.set_right_bracket_location(25);
		assertEquals(0, reference.get_number_of_citations());
		reference.add_element(0, 1, "10");
		assertEquals(1, reference.get_number_of_citations());
		Reference other_reference = new Reference(15);
		other_reference.set_right_bracket_location(25);
		assertNotEquals(reference, other_reference);
		other_reference.add_element(5, 6, "     10");
		assertEquals(reference, other_reference);
	}
}
