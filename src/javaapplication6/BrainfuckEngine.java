package javaapplication6;

/**
 *
 * @author Илья
 */
public class BrainfuckEngine {
        private final int[] data;
	private int dataPointer = 0;
	private int charPointer = 0;

        class Symbol {

		public final static char NEXT = '>';
		public final static char PREVIOUS = '<';
		public final static char PLUS = '+';
		public final static char MINUS = '-';
		public final static char OUTPUT = '.';
		public final static char INPUT = ',';
		public final static char BRACKET_LEFT = '[';
		public final static char BRACKET_RIGHT = ']';
	}

	public BrainfuckEngine(int cells) {
		data = new int[cells];
		dataPointer = 0;
		charPointer = 0;
	}

	public void interpret(String str) throws Exception {
		for (; charPointer < str.length(); charPointer++) 
			interpret(str.charAt(charPointer), str.toCharArray());
	}

	private void interpret(char c, char[] chars) throws Exception {
		switch (c) {
		case Symbol.NEXT:
			if ((dataPointer + 1) > data.length) {
				throw new Exception("Выход за пределы массива");
			}
			dataPointer++;
			break;
		case Symbol.PREVIOUS:
			if ((dataPointer - 1) < 0) {
				throw new Exception("Выход за пределы массива");
			}
			dataPointer--;
			break;
		case Symbol.PLUS:
			data[dataPointer]++;
			break;
		case Symbol.MINUS:
			data[dataPointer]--;
			break;
		case Symbol.OUTPUT:
			System.out.print((char) data[dataPointer]);
			break;
		case Symbol.INPUT:
			data[dataPointer] = (int) System.in.read();
			break;
		case Symbol.BRACKET_LEFT:
			if (data[dataPointer] == 0) {
				int i = 1;
				while (i > 0) {
					char c2 = chars[++charPointer];
					if (c2 == Symbol.BRACKET_LEFT)
						i++;
					else if (c2 == Symbol.BRACKET_RIGHT)
						i--;
				}
			}
			break;
		case Symbol.BRACKET_RIGHT:
			int i = 1;
			while (i > 0) {
				char c2 = chars[--charPointer];
				if (c2 == Symbol.BRACKET_LEFT)
					i--;
				else if (c2 == Symbol.BRACKET_RIGHT)
					i++;
			}
			charPointer--;
			break;
		}
	}
}

