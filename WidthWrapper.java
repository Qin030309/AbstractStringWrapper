package a5;

import java.util.List;
import java.util.ArrayList;

/**
 * A class that wraps a string by breaking the string into lines
 * of length equal to the desired wrapped line length (except
 * for possibly the last wrapped line which may be shorter
 * than the desired wrapped line length).
 */
public class WidthWrapper extends AbstractStringWrapper {

	/**
	 * Initializes this wrapper with the string to wrap and the
	 * desired maximum wrapped line width.
	 *
	 * @param toWrap      the string to wrap
	 * @param targetWidth the desired maximum wrapped line width
	 */


	public WidthWrapper(String toWrap, int targetWidth) {
		super(toWrap, targetWidth);
	}

	/**
	 * Wraps the string into separate lines of text.
	 */
	@Override
	public void wrap() {

		List<String> chunks = new ArrayList<>();
		//use substring method to divide the string into desired length
		//width method change maxWidth in AbstractStringWrapper superclass
		for (int i = 0; i < toWrap.length(); i += maxWidth) {
			chunks.add(toWrap.substring(i, Math.min(toWrap.length(), i + maxWidth)));
			lines = chunks;
		}
	}
	@Override
	public List<String> getLines() {
		return lines;
	}
	public static void main(String[] args) {
		int width = 30;
		AbstractStringWrapper w = new WidthWrapper("ABCDEFGHIJKLMNOPQRSTUVWXYZ", width);
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
