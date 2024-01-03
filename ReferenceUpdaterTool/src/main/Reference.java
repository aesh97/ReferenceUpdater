package main;
import java.util.ArrayList;
import java.util.Objects;

//TODO: Add unit tests for this class (low priority since this is purely to boost the coverage numbers)
public class Reference {
	private Integer left_bracket_location;
	private Integer right_bracket_location;
	private ArrayList<Integer> parens_locations;
	private ArrayList<Tuple> element_locations;
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
		return listsEqual(element_locations, other.element_locations)
				&& Objects.equals(left_bracket_location, other.left_bracket_location)
				&& Objects.equals(parens_locations, other.parens_locations)
				&& Objects.equals(right_bracket_location, other.right_bracket_location);
	}
	
	private boolean listsEqual(ArrayList<Tuple> list1, ArrayList<Tuple> list2) {
	    if (list1 == list2)
	        return true;
	    if (list1 == null || list2 == null || list1.size() != list2.size())
	        return false;
	    for (int i = 0; i < list1.size(); i++) {
	        if (!Objects.equals(list1.get(i), list2.get(i))) {
	            return false;
	        }
	    }
	    return true;
	}

	public Reference(Integer start) {
		this.left_bracket_location = start;
		this.parens_locations = new ArrayList<Integer>();
		this.element_locations = new ArrayList<Tuple>();
		this.elements = new ArrayList<Integer>();
	}
	
	public Integer get_left_bracket_location() {
		return this.left_bracket_location;
	}

	public Integer get_right_bracket_location() {
		return this.right_bracket_location;
	}

	public ArrayList<Integer> get_parens_locations() {
		return this.parens_locations;
	}

	public Integer get_number_of_citations() {
		return this.element_locations.size();
	}

	public ArrayList<Tuple> get_element_locations() {
		return this.element_locations;
	}
	
	public void add_parenthesis(Integer location) {
		this.parens_locations.add(location);
	}
	
	public void add_element(Integer start, Integer end, String text) {
		Tuple new_element = new Tuple(start, end);
		this.elements.add(Integer.valueOf(text.substring(start, end+1)));
		this.element_locations.add(new_element);
	}
	
	public ArrayList<Integer> get_elements() {
		return this.elements;
	}
	
	public void set_right_bracket_location(Integer location) {
		this.right_bracket_location = location;
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
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Tuple other = (Tuple) obj;
			return Objects.equals(start, other.start)
					&& Objects.equals(end, other.end);
		}
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Reference{")
	      .append("left_bracket_location=").append(left_bracket_location)
	      .append(", right_bracket_location=").append(right_bracket_location)
	      .append(", parens_locations=").append(parens_locations)
	      .append(", element_locations=[");
	    for (Tuple tuple : element_locations) {
	        sb.append("(").append(tuple.start).append(",").append(tuple.end).append(")");
	    }
	    sb.append("]}");
	    return sb.toString();
	}
}