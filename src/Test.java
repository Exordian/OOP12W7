
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class Test {
	public static void main(String[] args) {
		System.out.println(drawField(20, 10,'0')); //draws a field with x=20, y=10 & char 0 as filling

	}

	public static String drawField(int x, int y, char c) {
		String temp = "";
		for(int i = 0; i < y; i++) {
			if (i == 0) {
				temp += '.';
				for(int j = 0; j < x-2; j++) {
					temp += '-';
				}
				temp += '.';
			} else if (i == y-1){
				temp += '`';
				for(int j = 0; j < x-2; j++) {
					temp += '-';
				}
				temp += '´';
			} else {
				for(int j = 0; j < x; j++) {
					if (j==0 || j==x-1) {
						temp += '|';
					} else {
						temp += c;
					}
				}
			}
			temp += "\n";
		}
		return temp;
	}

}
