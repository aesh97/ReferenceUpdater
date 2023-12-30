import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CitationLocationTool {
	private Map<Integer, String> hashMap = new HashMap<>();
	
	public CitationLocationTool() {
		String filePath = "data/oldRefs2.txt";
		try {
			String text = Files.readString(Paths.get(filePath));
			Pattern pattern = Pattern.compile("\\[(\\d+)]\\s(.*?)(?=\\[\\d+]|$)", Pattern.DOTALL);
	        Matcher matcher = pattern.matcher(text);
	        while (matcher.find()) {
	            String referenceNumber = matcher.group(1);
	            String sentence = matcher.group(2);
	            this.hashMap.put(Integer.valueOf(referenceNumber), sentence.replaceAll("\\s+", "").trim());
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//TODO: Add Logic to update planetEating.texRefs before returning the output sentence
	public String find_citation_by_id(Integer id) {
		return this.hashMap.get(id);
	}
}
