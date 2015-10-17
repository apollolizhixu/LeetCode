public number_transform {
	public String printBinary(int num) {
		StringBuilder sb = new StringBuilder();
		return printBinary(int num, sb);
	}
	public String printBinary(int num, StringBuilder sb) {
		if (num <= 1) {
			return Integer.toString(num);
		}
		sb.insert(0, num % 2);
		return printBinary(num >> 1, sb);
	}
	public String printHex(int num) {
		if (num < 16) {
			return Integer.toString(num);
		}
		StringBuilder sb = new StringBuilder();
		char c = null;
		while (num > 0) {
			int digit = num % 16;
			switch(digit) {
				case 10:
					c = 'A';
					break;
				case 11:
					c = 'B';
					break;
				case 12:
					c = 'C';
					break;
				case 13:
					c = 'D';
					break;
				case 14:
					c = 'E';
					break;
				case 15:
					c = 'F';
					break;
				default:
					c = Character.toChar(digit);
			}
			sb.insert(0, c);
			num /= 16;
		}
		return sb.toString();
	}
}