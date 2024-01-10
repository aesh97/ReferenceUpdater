package test.java;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

import main.java.CitationLocationTool;

class CitationLocationTests {

	@Test
	void get_id_33_test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		CitationLocationTool tool = new CitationLocationTool();
		Method privateMethod = CitationLocationTool.class.getDeclaredMethod("find_citation_by_id", Integer.class);
		privateMethod.setAccessible(true); 
		String citation_33 = "C.A. Becker, R.J. Collier, and A.E. Stone. Invited review: Physiological and behavioral "
				+ "effects of heat stress in dairy cows. Journal of Dairy Science, 103:6751–6770, 2020.";
		String result = (String)privateMethod.invoke(tool, 33);
		assertEquals(citation_33.toLowerCase(), result);
	}
	
	@Test
	void get_id_20_test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		CitationLocationTool tool = new CitationLocationTool();
		Method privateMethod = CitationLocationTool.class.getDeclaredMethod("find_citation_by_id", Integer.class);
		privateMethod.setAccessible(true); 
		String citation_20 = "D.J. Augustine, J.D. Derner, L.M. Porensky, H.Wilmer, M.Fernandez-Gimenez, "
				+ "and D.D. Briske. Adaptive, multi-paddock, rotational grazing management: An experimental, "
				+ "ranch-scale assessment of effects on multiple ecosystem services. In Proceedings of the "
				+ "XXIV International Grassland Congress / XI International Rangeland Congress "
				+ "(Sustainable Use of Grassland and Rangeland Resources for Improved Livelihoods), "
				+ "pages 1-4, Nairobi, Kenya, 2021. Kenya Agricultural and Livestock Research Organization.";
		String result = (String)privateMethod.invoke(tool, 20);
		assertEquals(citation_20.toLowerCase(), result);
	}
	
	@Test
	void get_id_7_test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		CitationLocationTool tool = new CitationLocationTool();
		Method privateMethod = CitationLocationTool.class.getDeclaredMethod("find_citation_by_id", Integer.class);
		privateMethod.setAccessible(true); 
		String citation_7 = "Tatsuro Amano, Nicola Gerrett, Yoshimitsu Inoue, Takeshi Nishiyasu, "
				+ "George Havenith, and Narihiko Kondo. Determination of the maximum rate of eccrine sweat glands' "
				+ "ion reabsorption using the galvanic skin conductance to local sweat rate relationship. "
				+ "European Journal of Applied Physiology, 116, 2016.";
		String result = (String)privateMethod.invoke(tool, 7);
		assertEquals(citation_7.toLowerCase(), result);
	}
	
	@Test
	void get_title_187_test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		CitationLocationTool tool = new CitationLocationTool();
		Method privateMethod = CitationLocationTool.class.getDeclaredMethod("find_title_by_id", Integer.class);
		privateMethod.setAccessible(true); 
		String citation_187_title = "Meat consumption, health, and the environment";
		String result = (String)privateMethod.invoke(tool, 187);
		assertEquals(citation_187_title.toLowerCase(), result);
	}
	
	@Test
	void get_title_190_test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		CitationLocationTool tool = new CitationLocationTool();
		Method privateMethod = CitationLocationTool.class.getDeclaredMethod("find_title_by_id", Integer.class);
		privateMethod.setAccessible(true); 
		String citation_190_title = "Evolution as fact, theory, and path";
		String result = (String)privateMethod.invoke(tool, 190);
		assertEquals(citation_190_title.toLowerCase(), result);
	}
	
	@Test
	void get_title_193_test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		CitationLocationTool tool = new CitationLocationTool();
		Method privateMethod = CitationLocationTool.class.getDeclaredMethod("find_title_by_id", Integer.class);
		privateMethod.setAccessible(true); 
		String citation_193_title = "Meta-analysis of randomized controlled trials of red meat consumption in comparison with various comparison diets on cardiovascular risk factors";
		String result = (String)privateMethod.invoke(tool, 193);
		assertEquals(citation_193_title.toLowerCase(), result);
	}
	
	@Test 
	void get_string_id_196_test() {
		CitationLocationTool tool = new CitationLocationTool();
		String string_id_196 = "HammarEtAl2022";
		assertEquals(string_id_196, tool.find_string_id_by_id(196));
	}
	
	@Test 
	void get_string_id_199_test() {
		CitationLocationTool tool = new CitationLocationTool();
		String string_id_199 = "HarmoneyJaeger2018";
		assertEquals(string_id_199, tool.find_string_id_by_id(199));
	}
	
	@Test 
	void get_string_id_201_test() {
		CitationLocationTool tool = new CitationLocationTool();
		String string_id_201 = "HawkinsEtAl2022";
		assertEquals(string_id_201, tool.find_string_id_by_id(201));
	}
	
	@Test
	void get_id_353_test() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		CitationLocationTool tool = new CitationLocationTool();
		Method privateMethod = CitationLocationTool.class.getDeclaredMethod("find_citation_by_id", Integer.class);
		privateMethod.setAccessible(true); 
		String citation_353 = "United States Department of Agriculture. Quick Stats. 2021.";
		String result = (String)privateMethod.invoke(tool, 353);
		assertEquals(citation_353.toLowerCase(), result);
	}
	
	@Test
	void get_title_353_test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		CitationLocationTool tool = new CitationLocationTool();
		Method privateMethod = CitationLocationTool.class.getDeclaredMethod("find_title_by_id", Integer.class);
		privateMethod.setAccessible(true); 
		String citation_353_title = "Quick stats";
		String result = (String)privateMethod.invoke(tool, 353);
		assertEquals(citation_353_title.toLowerCase(), result);
	}
	
	@Test 
	void get_string_id_353_test() {
		CitationLocationTool tool = new CitationLocationTool();
		String string_id_353 = "quickstats";
		assertEquals(string_id_353, tool.find_string_id_by_id(353));
	}
}
