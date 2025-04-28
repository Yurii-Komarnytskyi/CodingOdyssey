package codingbat.warmup1;

public class WarmUpOne {
	
	public boolean in3050(int a, int b) {
		return ( (a >= 30 && a <= 40 && b >= 30 && b <= 40 ) || (a >= 40 && a <= 50 && b >= 40 && b <= 50 ) )? true : false;
	}
	public int max1020(int a, int b) {
		int isAInRange = (a >= 10 && a <= 20)? a : 0;
		int isBInRange = (b >= 10 && b <= 20)? b : 0;
		return (isAInRange > isBInRange)? isAInRange : isBInRange;
	}
	public boolean stringE(String str) {
		int count = 1;
		for(String s : str.split(""))
			if(s.equals("e")) count ++;
		return (count <= 4 && count > 1)? true: false;
	}

	public boolean lastDigit(int a, int b) {
		char aString = String.valueOf(a).charAt(String.valueOf(a).length()-1);
		char bString = String.valueOf(b).charAt(String.valueOf(b).length()-1);
		return (aString == bString)? true: false;
	}

	public String endUp(String str) {
		if(str.length()-1 <= 2) return str.toUpperCase();
		return new StringBuilder(str.substring(0, str.length()-3))
				.append(str.substring(str.length()-3, str.length())
				.toUpperCase()).toString();
	}
	
	public String everyNth(String str, int n) {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i <= str.length()-1; i += n) {
			result.append(str.charAt(i));
		}  
		return result.toString();
	}
	public static void main(String[] args) {
		WarmUpOne warmUp = new WarmUpOne();
		System.out.println(warmUp.everyNth("Miracle", 2));
	}

}
