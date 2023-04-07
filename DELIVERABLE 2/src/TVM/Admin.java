/**
 * 
 */
package TVM;

import java.util.HashMap;

/**
 * @author Mahavir
 *
 */
public class Admin {

	/**
	 * 
	 */
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean changePlan(HashMap<String, Double> hm, String Key, Double price) {
		boolean isDone = false;
		if(hm.containsKey(Key)) {
			hm.put(Key, price);
			isDone = true;
		}else{
			isDone = false;
		}
		return isDone;
	}

}
