/**
 * 
 */
package Model;

import java.util.HashMap;

/**
 * @author 
 *
 */
public class Ticket {

	private HashMap<String, Double> hm = new HashMap<>();

	/**
	 * 
	 */
	public Ticket() {
		// TODO Auto-generated constructor stub
		hm.put("Daily Pass", 11.00);
		hm.put("Ten Pass", 32.50);
		hm.put("20 trip", 60.50);
		hm.put("One Way", 3.25);
		hm.put("Two Way", 6.50);
		hm.put("Weekend Pass", 15.00);
	}

	public HashMap<String, Double> getValue() {
		return hm;
	}

	public void setValue(HashMap<String, Double> hm) {
		this.hm = hm;
	}

}
