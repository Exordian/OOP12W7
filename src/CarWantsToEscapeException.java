
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class CarWantsToEscapeException extends Exception {
	//is thrown if car wants to exceed border of lane
	CarWantsToEscapeException(String s) {
		//s != null;
		super(s);
	}
}
