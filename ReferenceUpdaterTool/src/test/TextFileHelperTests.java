package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import main.Reference;
import main.TextFileHelper;

public class TextFileHelperTests {
	
	@Test
	void parse_test_case_1_test() throws Exception {
		String line = "[10, 2, 5]";
		Reference ref = new Reference(0);
		ref.set_right_bracket_location(9);
		ref.add_parenthesis(3);
		ref.add_parenthesis(6);
		ref.add_element(1, 2);
		ref.add_element(5, 5);
		ref.add_element(8, 8);
		TextFileHelper line_parser = new TextFileHelper();
		ArrayList<Reference> expected = new ArrayList<>();
		expected.add(ref);
		Method privateMethod = TextFileHelper.class.getDeclaredMethod("find_instances", String.class);
		privateMethod.setAccessible(true); 
		ArrayList<Reference> result = (ArrayList<Reference>)privateMethod.invoke(line_parser, line);
		assertEquals(expected, result);
	}
	
	@Test
	void parse_test_case_2_test() throws Exception {
		String line = "stressed cattle[112, 280]. ";
		Reference ref = new Reference(15);
		ref.set_right_bracket_location(24);
		ref.add_parenthesis(19);
		ref.add_element(16, 18);
		ref.add_element(21, 23);
		TextFileHelper line_parser = new TextFileHelper();
		ArrayList<Reference> expected = new ArrayList<>();
		expected.add(ref);
		Method privateMethod = TextFileHelper.class.getDeclaredMethod("find_instances", String.class);
		privateMethod.setAccessible(true); 
		ArrayList<Reference> result = (ArrayList<Reference>)privateMethod.invoke(line_parser, line);
		assertEquals(expected, result);
	}

	@Test
	void parse_test_case_3_test() throws Exception {
		String line = "cooling. The message is clear: such thermodynamically challenged animals as humans [27, 127] or cattle [125, 564] depend";
		Reference ref_1 = new Reference(83);
		ref_1.set_right_bracket_location(91);
		ref_1.add_parenthesis(86);
		ref_1.add_element(84, 85);
		ref_1.add_element(88, 90);
		
		Reference ref_2 = new Reference(103);
		ref_2.set_right_bracket_location(112);
		ref_2.add_parenthesis(107);
		ref_2.add_element(104, 106);
		ref_2.add_element(109, 111);
		TextFileHelper line_parser = new TextFileHelper();
		ArrayList<Reference> expected = new ArrayList<>();
		expected.add(ref_1);
		expected.add(ref_2);
		Method privateMethod = TextFileHelper.class.getDeclaredMethod("find_instances", String.class);
		privateMethod.setAccessible(true); 
		ArrayList<Reference> result = (ArrayList<Reference>)privateMethod.invoke(line_parser, line);
		assertEquals(expected, result);
	}
	
	@Test
	void parse_test_should_throw_exception_1() throws Exception {
		String line = "[41, ";
		TextFileHelper line_parser = new TextFileHelper();
		Method privateMethod = TextFileHelper.class.getDeclaredMethod("find_instances", String.class);
		privateMethod.setAccessible(true); 
		assertThrows(Exception.class, () -> {
			privateMethod.invoke(line_parser, line);
		});
	}
	
	@Test
	void parse_test_should_throw_exception_2() throws Exception {
		String line = "272]";
		TextFileHelper line_parser = new TextFileHelper();
		Method privateMethod = TextFileHelper.class.getDeclaredMethod("find_instances", String.class);
		privateMethod.setAccessible(true); 
		assertThrows(Exception.class, () -> {
			privateMethod.invoke(line_parser, line);
		});
	}
}