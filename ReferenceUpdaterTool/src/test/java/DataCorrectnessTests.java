package test.java;
import org.junit.jupiter.api.Test;

import main.java.CitationLocationTool;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class DataCorrectnessTests {
	
	@Test
	void makes_sure_that_all_ids_can_be_parsed() {
		CitationLocationTool tool = new CitationLocationTool();
		Integer number_of_references = 568;
		int current_refererence = 1;
		while (current_refererence <= number_of_references) {
			String result = tool.find_string_id_by_id(current_refererence);
			if (result == null) {
				System.out.println("String ID failed at: " + current_refererence);
			}
			assertTrue(result != null);
			current_refererence++;
		}
	}
	
	@Test
	void makes_sure_all_titles_are_can_be_parsed() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		CitationLocationTool tool = new CitationLocationTool();
		Method privateMethod = CitationLocationTool.class.getDeclaredMethod("find_title_by_id", Integer.class);
		privateMethod.setAccessible(true); 
		Integer number_of_references = 568;
		int current_refererence = 1;
		while (current_refererence <= number_of_references) {
			String result = (String)privateMethod.invoke(tool, current_refererence);
			if (result == null) {
				System.out.println("Title failed at: " + current_refererence);
			}
			assertTrue(result != null);
			current_refererence++;
		}
	}
	
	@Test
	void makes_sure_all_citations_are_can_be_parsed() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		CitationLocationTool tool = new CitationLocationTool();
		Method privateMethod = CitationLocationTool.class.getDeclaredMethod("find_citation_by_id", Integer.class);
		privateMethod.setAccessible(true); 
		Integer number_of_references = 568;
		int current_refererence = 1;
		while (current_refererence <= number_of_references) {
			String result = (String)privateMethod.invoke(tool, current_refererence);
			assertTrue(result != null);
			current_refererence++;
		}
	}
}
