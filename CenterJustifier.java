package a5;

/**
 * A {@code TextJustifier} that aligns text to a column having a specified width
 * measured in characters such that the text is centered in the column.
 */
public class CenterJustifier implements TextJustifier {

	/**
	 * Aligns the specified string to a column having the specified width such that
	 * the text is centered in the column. The returned string is padded with spaces
	 * at the front and end of the string so that the length of the string is equal
	 * to the column width.
	 * 
	 * <p>
	 * An equal number of padding spaces are used at the front and end of the string
	 * if possible. If this is not possible, then the end of the string contains
	 * one more space than the front of the string.
	 * 
	 * @param s     a string to align
	 * @param width a column width in characters
	 * @return a string aligned to a column of the specified width
	 * @throws IllegalArgumentException if the length of s is greater than width
	 */
	@Override
	public String justify(String s, int width) {
		if(s.length()>width){
			throw new IllegalArgumentException("string length must be less or equal to width");
		}
		String Justified= "";
		if(s.length()<width){
			int amount1 = width- s.length();
			int amount2 = amount1%2;
			int amount3 = amount1/2;
			if(amount2 ==0){
				//in this case, we just need to add same amount of space in each part
				StringBuilder Justified1 = new StringBuilder();
				for(int i=0;i<amount3;i++){
					Justified1.append(" ");
				}
			    Justified1.append(s);
				for(int i=0;i<amount3;i++){
					Justified1.append(" ");
				}
				Justified = Justified1.toString();
			}
			else if(amount2 != 0){
				//in this case, we need add one more space to the end of string than the beginning
				StringBuilder Justified1 = new StringBuilder();
				for(int i=0;i<amount3;i++){
					Justified1.append(" ");
				}
				Justified1.append(s);
				for(int i=0;i<amount3+amount2;i++){
					Justified1.append(" ");
				}
				Justified = Justified1.toString();
			}
		else if(s.length()==width){
			    Justified = s;
			}
		}

		return Justified;



	}

}
