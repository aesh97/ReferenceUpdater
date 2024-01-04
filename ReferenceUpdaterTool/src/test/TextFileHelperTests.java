package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import main.Reference;
import main.TextFileHelper;

public class TextFileHelperTests {
	
	@Test
	void parse_test_case_1_test() throws Exception {
		String line = "[10, 2, 5]";
		Reference ref = new Reference(0);
		ref.set_right_bracket_location(9);
		ref.add_element(1, 2, line);
		ref.add_element(5, 5, line);
		ref.add_element(8, 8, line);
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
		ref.add_element(16, 18, line);
		ref.add_element(21, 23, line);
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
		ref_1.add_element(84, 85, line);
		ref_1.add_element(88, 90, line);
		Reference ref_2 = new Reference(103);
		ref_2.set_right_bracket_location(112);
		ref_2.add_element(104, 106, line);
		ref_2.add_element(109, 111, line);
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
	
	@Test 
	void replace_text_example_1() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		String line = "[331]";
		String expected = "\\cite{Moodie2016}";
		TextFileHelper line_parser = new TextFileHelper();
		Method privateMethod = TextFileHelper.class.getDeclaredMethod("replace_text", String.class);
		privateMethod.setAccessible(true); 
		assertEquals(expected, privateMethod.invoke(line_parser,  line));
	}
	
	@Test 
	void replace_text_example_2() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		String line = "skeptical journalists [331, 205, 16] to rebut naive [346, 348, 433] or self serving [233] claims about food, this is where things";
		String expected = "skeptical journalists \\cite{Moodie2016, Heid2016, Arends2020} to rebut naive \\cite{Niman2009, Niman2014, SavoryTedTalk2013} or self serving \\cite{JohnstonEtAl2019} claims about food, this is where things";
		TextFileHelper line_parser = new TextFileHelper();
		Method privateMethod = TextFileHelper.class.getDeclaredMethod("replace_text", String.class);
		privateMethod.setAccessible(true); 
		assertEquals(expected, privateMethod.invoke(line_parser,  line));
	}
	
	@Test 
	void replace_text_example_3() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String line = "was 48, 48, 32, 25, and 14 [353]. Another food that fits the bill is sweet cherry, which 9, 8, 3, and 3 states grew nontrivial ";
		String expected = "was 48, 48, 32, 25, and 14 \\cite{quickstats}. Another food that fits the bill is sweet cherry, which 9, 8, 3, and 3 states grew nontrivial ";
		TextFileHelper line_parser = new TextFileHelper();
		Method privateMethod = TextFileHelper.class.getDeclaredMethod("replace_text", String.class);
		privateMethod.setAccessible(true); 
		assertEquals(expected, privateMethod.invoke(line_parser,  line));
	}
	
	@Test
	void write_to_file_test() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		
		TextFileHelper line_parser = new TextFileHelper();
		Method privateMethod = TextFileHelper.class.getDeclaredMethod("write_lines", List.class, String.class);
		privateMethod.setAccessible(true); 
		String filePath = "src/test/dummy_data/write_lines.txt";
		clear_file(filePath);
		List<String> lines_to_write = new ArrayList<>();
		lines_to_write.add("line 1");
		lines_to_write.add("line 2");
		lines_to_write.add("line 3");
		lines_to_write.add("line 1111awefsfa");
		privateMethod.invoke(line_parser, lines_to_write, filePath);
		privateMethod.invoke(line_parser, lines_to_write, filePath);
		lines_to_write.add("line 1");
		lines_to_write.add("line 2");
		lines_to_write.add("line 3");
		lines_to_write.add("line 1111awefsfa");
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0; 
            while ((line = reader.readLine()) != null) {
            	assertEquals(lines_to_write.get(lineNumber), line);
                lineNumber++; 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@Test 
	void process_input_chapter_test() {
		String input_filepath = "src/test/dummy_data/ch6_dummy.txt";
		String actual_output_filepath = "src/test/dummy_data/ch6_dummy_actual_output.txt";
		String expected_output_filepath = "src/test/dummy_data/ch6_dummy_expected_output.txt";
		List<String> actual_output = new ArrayList<>();
		clear_file(actual_output_filepath);
		TextFileHelper line_parser = new TextFileHelper();
		line_parser.generate_output_document(input_filepath, actual_output_filepath, 2);
		try (BufferedReader reader = new BufferedReader(new FileReader(actual_output_filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	actual_output.add(line); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		try (BufferedReader reader = new BufferedReader(new FileReader(expected_output_filepath))) {
            String line;
            int lineNumber = 0; 
            while ((line = reader.readLine()) != null) {
            	assertEquals(actual_output.get(lineNumber), line);
                lineNumber++; 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	void clear_file(String filePath) {
		try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(""); 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}