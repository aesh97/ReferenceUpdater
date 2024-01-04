package main;
import java.util.ArrayList;
import java.util.Objects;

public class Reference {
	private Integer left_bracket_location;
	private Integer right_bracket_location;
	private ArrayList<Integer> elements;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false; 
		if (getClass() != obj.getClass())
			return false;
		Reference other = (Reference) obj;
		return Objects.equals(left_bracket_location, other.left_bracket_location)
				&& Objects.equals(elements, other.elements)
				&& Objects.equals(right_bracket_location, other.right_bracket_location);
	}
	
	public Reference(Integer start) {
		this.left_bracket_location = start;
		this.elements = new ArrayList<Integer>();
	}
	
	public Integer get_left_bracket_location() {
		return this.left_bracket_location;
	}

	public Integer get_right_bracket_location() {
		return this.right_bracket_location;
	}

	public Integer get_number_of_citations() {
		return this.elements.size();
	}

	public void add_element(Integer start, Integer end, String text) {
		this.elements.add(Integer.valueOf(text.substring(start, end+1)));
	}
	
	public ArrayList<Integer> get_elements() {
		return this.elements;
	}
	
	public void set_right_bracket_location(Integer location) {
		this.right_bracket_location = location;
	}
}