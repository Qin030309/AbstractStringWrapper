package a5;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
/**
 * A class that wraps a string by breaking the string into lines
 * of length equal to or less than the desired wrapped line length.
 * The breaking occurs at spaces in the string where possible. If
 * a wrapped line contains no strings before the desired wrapped
 * line length, then the line is broken at the desired wrapped
 * line length.
 *
 */
public class SpacesWrapper extends AbstractStringWrapper {

	/**
	 * Initializes this wrapper with the string to wrap and the
	 * desired maximum wrapped line width.
	 * 
	 * @param toWrap the string to wrap
	 * @param targetWidth the desired maximum wrapped line width
	 */

	public SpacesWrapper(String toWrap, int targetWidth) {
		super(toWrap,targetWidth);
	}
	/**
	 * Wraps the string into separate lines of text.
	 */
	public void wrap(){
		//separate list by space
		String[] parts = toWrap.split(" ");
		//initialize the list will store final space_wrapped text
		List<String> finallist = new ArrayList<>();
		//initialize the list will store each line belong to final space_wrapped text
		List<String> newlist = new ArrayList<>();
		for(int i = 0; i< parts.length;i++){
			int m = 0;
			if(parts[i].length()<maxWidth){
				for(String ik: newlist){
					m = m +ik.length();
				}
                //calculate the temporary line length
				//in this case, the temporary line length will exceed the column width if we add another word to this line
				if(m+parts[i].length()>=maxWidth){
					String singlestring = String.join(" ",newlist );
					finallist.add(singlestring);
					newlist.clear();
					//therefore we make line here
				}
				//in this case, there will be no left string to add on
				if(i+1> parts.length-1){
					newlist.add(parts[i]);
					String singlestring = String.join(" ",newlist );
					finallist.add(singlestring);
					newlist.clear();
					//make a new line here
				}
				//in this case there will be still strings left
				if(i+1<= parts.length-1){
                     if(parts[i+1].length()>=maxWidth){
						 finallist.add(parts[i]);
						 //just make this string as a new line
					 }
				}
				//add string to make the line's length as close as to possible desired column length as possible
               if(m+parts[i].length()<maxWidth){
				   newlist.add(parts[i]);
				   }


			}
			//in this case we need to split string, therefor the string part would not exceed the column width
			else if(parts[i].length()>=maxWidth){
				List<String> chunks = new ArrayList<>();
				for (int z = 0; z < parts[i].length(); z += maxWidth) {
					chunks.add(parts[i].substring(z, Math.min(parts[i].length(), z + maxWidth)));
				}
				for(String word:chunks){
					finallist.add(word);
				}
			}
			lines= finallist;
		}

		}
	@Override
	public List<String> getLines(){
            return lines;
	}

	public static void main(String[] args) {
		int width = 30;
		AbstractStringWrapper w = new SpacesWrapper("ABC DEFGH I JKLMNOPQ RSTUVWXYZ", width);
		w.wrap();
		List<String> wrapped = w.getLines();
		String out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");
		
		width = 20;
		w.width(width);
		w.wrap();
		wrapped = w.getLines();
		out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");
		
		width = 5;
		w.width(width);
		w.wrap();
		wrapped = w.getLines();
		out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");
		
		width = 1;
		w.width(width);
		w.wrap();
		wrapped = w.getLines();
		out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");

	}
}
