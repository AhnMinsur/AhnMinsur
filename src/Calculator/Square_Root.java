package Calculator;

import java.util.Scanner;

public class Square_Root {
	public static void Square_root(int loop, double least, int a) {
		double add = 1;
		for ( int j = 0; j < loop; j++ ) {
			add /= 10;
			for ( int J = 1; J < 10; J++ ) {
				double co = least + (add * J);
				int n = J + 1;
				double co2 = least + (add * n);
				double cos = co * co;
				double co2s = co2 * co2;
				if ( cos < a && a < co2s ) {
					least = co;
					break;
				}
			}
		}
		System.out.println(least);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("This program can help you know about square root of the numbers."
				+ "\n" + "In the first line, write how far you want to know about the square root decimal."
				+ "\n" + "In second line, write one number that you wonder whose square root decimal.");
		int loop = sc.nextInt();
		if ( loop > 15 ) {
			System.out.println("Sorry, this program can not calculate...");
			return;
		}
		int a = sc.nextInt();
		sc.close();

		int i = 0;
		int least = 0;
		while ( true ) {
			i++;
			int is = i * i;
			if ( a == is ) {
				System.out.println(i);
				return;
			}
			if ( is > a ) {
				least = i-1;
				break;
			}
		}
		Square_root(loop, least, a);
	}
}
