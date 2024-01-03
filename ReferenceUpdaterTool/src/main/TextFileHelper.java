package main;
import java.util.ArrayList;

public class TextFileHelper {
	// Note: This method only handles the cases where the pattern ([{number}, 
	// {number}, ... {number}]) holds, it will fail if there are referenced
	// equations or tables
	private ArrayList<Reference> find_instances(String text) throws Exception {
		ArrayList<Reference> references = new ArrayList<>();
		Reference in_progress_reference = null;
		Integer index = 0;  
		while (index < text.length()) {
			char current_character = text.charAt(index);
			if (Character.isDigit(current_character) || current_character == ' ' || current_character == ','
					|| current_character == '[' || current_character == ']') {
				if (in_progress_reference == null) {
					if (current_character == '[') {
						in_progress_reference = new Reference(index);
						index += 1;
					} else if (current_character == ']') {
						throw new Exception("Partial Reference Detected");
					} else {
						index += 1;
					}
				} else {
					if (current_character == '[') {
						throw new Exception("Nested [ characters at location: " + String.valueOf(index));
					} else if (current_character == ',') {
						in_progress_reference.add_parenthesis(index);
						index += 1;
					} else if (Character.isDigit(current_character)) {
						Integer saved_start = index;
						Integer saved_end = index;
						while (saved_end < text.length() && Character.isDigit(text.charAt(saved_end))) {
							saved_end += 1;
						}
						index = saved_end;
						saved_end -= 1;
						in_progress_reference.add_element(saved_start, saved_end);
					} else if (current_character == ']') {
						in_progress_reference.set_right_bracket_location(index);
						references.add(in_progress_reference);
						in_progress_reference = null;
						index += 1;
					} else {
						index += 1;
					}
				}
			} else {
				index += 1;
			}
		}
		if (in_progress_reference != null) {
			throw new Exception("Partial Reference Detected");
		}
		return references;
	}
}