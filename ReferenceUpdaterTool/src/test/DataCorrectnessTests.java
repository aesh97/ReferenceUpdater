package test;
import org.junit.jupiter.api.Test;

import main.CitationLocationTool;

import static org.junit.jupiter.api.Assertions.*;


public class DataCorrectnessTests {
	
	@Test
	void makes_sure_that_all_ids_can_be_parsed() {
		CitationLocationTool tool = new CitationLocationTool();
		Integer number_of_references = 568;
		int current_refererence = 1;
		while (current_refererence <= number_of_references) {
			assertTrue(tool.find_string_id_by_id(current_refererence) != null);
			current_refererence++;
		}
	}
	
	@Test
	void makes_sure_all_titles_are_unique() {
		
	}
}
