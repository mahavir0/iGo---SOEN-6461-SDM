/**
 * 
 */
package Bank;

/**
 * @author Mahavir
 *
 */
public class CardChecker {

	/**
	 * 
	 */
	public CardChecker() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean validateCardNumber(String cardNumber) {
		int sum = 0;
		boolean alternate = false;
		for (int i = cardNumber.length() - 1; i >= 0; i--) {
			int n = Integer.parseInt(cardNumber.substring(i, i + 1));
			if (alternate) {
				n *= 2;
				if (n > 9) {
					n = (n % 10) + 1;
				}
			}
			sum += n;
			alternate = !alternate;
		}
		if (sum % 10 == 0) {
			System.out.println(cardNumber + " Given cardNumber is a valid card number\r\n");
			return true;
		} else {
			System.out.println(cardNumber + " Given card Number is NOT a valid card number\r\n");
		}
		return false;
	}

}
