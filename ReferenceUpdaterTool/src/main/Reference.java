package main;
import java.util.ArrayList;

public class Reference {
	private Integer left_bracket_location;
	private Integer right_bracket_location;
	private ArrayList<Integer> parens_locations;
	private Integer number_of_citations;
	private ArrayList<Tuple> element_locations;
	
	public Reference(Integer start, Integer end, ArrayList<Integer> parens_locations, Integer number_of_citations, ArrayList<Tuple> element_locations) {
		this.left_bracket_location = start;
		this.right_bracket_location = end;
		this.parens_locations = parens_locations;
		this.number_of_citations = number_of_citations;
		this.element_locations = element_locations;
	}
	
	public Integer getLeft_bracket_location() {
		return left_bracket_location;
	}

	public Integer getRight_bracket_location() {
		return right_bracket_location;
	}

	public ArrayList<Integer> getParens_locations() {
		return parens_locations;
	}

	public Integer getNumber_of_citations() {
		return number_of_citations;
	}

	public ArrayList<Tuple> getElement_locations() {
		return element_locations;
	}

	class Tuple {
		private Integer start;
		private Integer end;
		
		public Tuple(Integer start, Integer end) {
			this.start = start;
			this.end = end;
		}
		
		public Integer get_start() {
			return this.start;
		}
		
		public Integer get_end() {
			return this.end;
		}
	}
}
