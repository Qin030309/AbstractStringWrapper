package a5;

/**
 * A {@code TextJustifier} that aligns text to a column having a specified width
 * measured in characters such that the beginning of the text is aligned with
 * the left side of the column.
 */
public class FlushLeftJustifier implements TextJustifier {

	/**
	 * Aligns the specified string to a column having the specified width such that
	 * the beginning of the text is aligned with the left side of the column.
	 * The returned string is padded with spaces at the end of the string so that
	 * the length of the string is equal to the column width.
	 * 
	 * @param s     a string to align
	 * @param width a column width in characters
	 * @return a string aligned to a column of the specified width
	 * @throws IllegalArgumentException if the length of s is greater than width
	 */
	@Override
	public String justify(String s, int width) {
		if(s.length()>width){
			throw new IllegalArgumentException("the length of s is greater than width");
		}
		String Justified = "";
		//initialize a new string
		if(s.length()<width){
			int amount1 = width - s.length();
			StringBuilder Justified1 = new StringBuilder();
			//add string part
			Justified1.append(s);
			//add space to the end of string
			for (int i = 0; i< amount1; i++){
				Justified1.append(" ");
			}
			Justified = Justified1.toString();
		}
		else if(s.length()==width){
			Justified = s;
		}
		return Justified;
	}

}
