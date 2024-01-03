package main;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileReader;

//TODO: Add Logic to update planetEating.texRefs before returning the output sentence 
//TODO: Add custom Error Handling in case the tool fails to parse the files
public class CitationLocationTool {
	private Map<Integer, String> id_to_citation = new HashMap<>();
	private Map<String, String> citation_to_string_id = new HashMap<>();
	
	public CitationLocationTool() {
		String filePath = "data/oldRefs2.txt";
		String referencePath = "data/planetEating.texRefs";
		try {
			String text = Files.readString(Paths.get(filePath));
			Pattern pattern = Pattern.compile("\\[(\\d+)]\\s(.*?)(?=\\[\\d+]|$)", Pattern.DOTALL);
	        Matcher matcher = pattern.matcher(text);
	        while (matcher.find()) {
	            String referenceNumber = matcher.group(1);
	            String sentence = matcher.group(2);
	            this.id_to_citation.put(Integer.valueOf(referenceNumber), sentence.replace("\n", ""));
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
		String current_article = null;
		try (BufferedReader br = new BufferedReader(new FileReader(referencePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() > 0 && line.charAt(0) == '@') {
                	String[] split = line.split("\\{");
                	if (split.length > 1) {
                		current_article = split[1];
                        current_article = current_article.substring(0, current_article.length()-1);
                	}	
                }
                else if (line.length() >= 9 && line.substring(0,5).equals("title")) {
                	String title = line.substring(9);
                	if (title.length()-3 > 0) {
                		this.citation_to_string_id.put(title.substring(0, title.length()-3), current_article);                
                	}
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private String find_citation_by_id(Integer id) {
		return this.id_to_citation.get(id);
	}

	private String find_title_by_id(Integer id) {
		String citation = this.find_citation_by_id(id);
		String[] parts = citation.split("(?<!\\..)[.?!]\\s+");
		if (parts.length > 1) {
			return parts[1];
		}
		return null;
	}
	
	public String find_string_id_by_id(Integer id) {
		String title = this.find_title_by_id(id);
		return this.citation_to_string_id.get(title);
	}
}