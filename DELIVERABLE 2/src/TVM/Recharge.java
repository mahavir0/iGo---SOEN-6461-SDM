/**
 * 
 */
package TVM;

import java.util.HashMap;

/**
 * @author 
 *
 */
public class Recharge {

	private HashMap<String, Double> rechargeOption = new HashMap<>();
	
	/**
	 * 
	 */
	public Recharge() {
		// TODO Auto-generated constructor stub
		rechargeOption.put("One Month Recharge", 56.50);
		rechargeOption.put("Three Months Recharge", 150.99);
		rechargeOption.put("20 Trips Recharge", 35.99);
		rechargeOption.put("10 Trips Recharge", 20.50);
	}

	public HashMap<String, Double> getRechargeOption() {
		return rechargeOption;
	}

	public void setRechargeOption(HashMap<String, Double> rechargeOption) {
		this.rechargeOption = rechargeOption;
	}

}
