package Calculator;

import java.util.Scanner;

public class Addition {
	public class Value {
		public int[] a;
		public int[] b;
		public Value() {this.a = null; this.b = null;}
	};

	public int ten;

	public Value ParseNumber(String s) {
		int i;
		for (i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.')
				break;
		}

		//integer part
		Value v = new Value();
		int a_len = i;
		if (a_len > 0) {
			v.a = new int [a_len];
			for (i = 0; i < a_len; i++) {
				v.a[i] = s.charAt(i) - '0';
			}
		}

		//decimal part
		int b_start = a_len;
		int b_len = s.length() - b_start;
		if (b_len > 0) {
			v.b = new int [b_len - 1];
			for (i = b_start + 1; i < s.length(); i++) {
				v.b[i - b_start - 1] = s.charAt(i) - '0';
			}
		}
		if ( b_len == 0 ) {
			v.b = new int [] {0};
		}
		return v;
	}


	public String AddUnderPoint(int[] b1, int[] b2) {
		String s = new String(); //return
		int output = 0;
		int max = 0;
		int min = 0;

		if ( b1.length < b2.length ) {
			max = b2.length;
			min = b1.length;
		}
		else {
			max = b1.length;
			min = b2.length;
		}
		int[] outputs = new int[max];

		//S1과 S2의 소수점 아래의 숫자들의 수가 다를 경우
		if ( min != max ) {
			for ( int i = max - 1; i >= min; i-- ) {
				if ( max == b2.length ) {
					outputs[i] = b2[i];
				}
				if ( max == b1.length ) {
					outputs[i] = b1[i];
				}
			}
		}

		for ( int i = min - 1; i >= 0; i-- ) {
			//S1과 S2의 소수점 숫자들끼리 더함
			output = b1[i] + b2[i];
			if ( ten ==  1 ) {
				output += 1;
				ten = 0;
			}
			if ( 10 <= output ) {
				output %= 10;
				ten = 1;
			}
			outputs[i] = output;
		}
		for ( int i = 0; i < max; i++ ) {
			s += outputs[i];
		}
		return s;
	}


	public String AddInteger(int[] a1, int[] a2, int ten) {
		String s = new String(); //return
		int max = 0;

		if ( a1.length < a2.length ) {
			max = a2.length;
		}
		else {
			max = a1.length;
		}
		int outputs[] = new int[max];

		for ( int i = 1; i <= max; i++ ) {
			if ( a1.length - i < 0 ) {
				outputs[max - i] = a2[a2.length - i];
			}
			else if ( a2.length - i < 0 ) {
				outputs[max - i] = a1[a1.length - i];
			}
			else {
				outputs[max - i] = a1[a1.length - i] + a2[a2.length - i];
			}
			if ( ten == 1 ) {
				outputs[max - i]++;
				ten = 0;
			}
			if ( outputs[max - i] >= 10 && i != max ) {
				outputs[max - i] %= 10;
				ten = 1;
			}
		}

		for ( int i = 0; i < max; i++ ) {
			s += outputs[i];
		}

		return s;

	}


	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		String S1 = sc.nextLine();
		String S2 = sc.nextLine();
		sc.close();

		// parse
		Addition t = new Addition();
		Value v1 = t.ParseNumber(S1);
		Value v2 = t.ParseNumber(S2);

		// add under-point
		String s_b = t.AddUnderPoint(v1.b, v2.b);

		// add integer
		String s_a = t.AddInteger(v1.a, v2.a, t.ten);

		// output
		System.out.print(s_a);
		int check = 0;
		for ( int i = 0; i < s_b.length(); i++ ) {
			check += (s_b.charAt(i) - '0');
		}
		if ( check > 0 ) {
			System.out.println('.' + s_b);
		}
	}
}