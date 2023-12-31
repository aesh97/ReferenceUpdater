import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CitationLocationTests {

	@Test
	void get_id_33_test() {
		CitationLocationTool tool = new CitationLocationTool();
		String citation_33 = "C. A. Becker, R. J. Collier, and A. E. Stone. Invited review: Physiological and behavioral "
				+ "effects of heat stress in dairy cows. Journal of Dairy Science, 103:6751–6770, 2020.";
		assertEquals(citation_33.replaceAll(" ",  ""), tool.find_citation_by_id(33));
	}
	
	@Test
	void get_id_20_test() {
		CitationLocationTool tool = new CitationLocationTool();
		String citation_20 = "D.J.Augustine,J.D.Derner,L.M.Porensky,H.Wilmer,M.Fernandez-Gimenez,andD.D.Briske.Adaptive, multi-paddock, "
				+ "rotational grazing management: An experimental, ranch-scale assessment of effects on multiple ecosystem services. "
				+ "In Proceedings of the XXIV International Grassland Congress / XI International Rangeland Congress "
				+ "(Sustainable Use of Grassland and Rangeland Resources for Improved Livelihoods), pages 1-4, Nairobi, Kenya, 2021."
				+ " Kenya Agricultural and Livestock Research Organization.";
		assertEquals(citation_20.replaceAll(" ", ""), tool.find_citation_by_id(20));
	}
	
	
	@Test
	void get_id_7_test() {
		CitationLocationTool tool = new CitationLocationTool();
		String citation_7 = "Tatsuro Amano, Nicola Gerrett, Yoshimitsu Inoue, Takeshi Nishiyasu, George Havenith, and Narihiko Kondo. Determination of the "
				+ "maximum rate of eccrine sweat glands’ ion reabsorp tion using the galvanic skin conductance to local sweat rate relationship. European Journal of"
				+ "Applied Physiology, 116, 2016.";
		assertEquals(citation_7.replaceAll(" ",  ""), tool.find_citation_by_id(7));
	}
}
