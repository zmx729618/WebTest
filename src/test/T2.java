package test;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;

// 死在了多行输入上
public class T2 {
	private static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int lines = in.nextInt();
		Pattern pattern = Pattern.compile("[,]+1");
		int[] arr = null;
		// 用于接收换行符
		in.nextLine();
		for (int i = 0; i < lines; i++) {
			String[] str = pattern.split(in.nextLine());
			arr = new int[str.length];
			for (int j = 0; j < str.length; j++) {
				// System.out.print(str[j]+" ");
				arr[j] = Integer.parseInt(str[j]);
			}
			// 调用方法
			solution(arr);
			// System.out.println();
		}
		for (int k = 0; k < arr.length; k++) {
			// System.out.println(arr[k]);
		}
		for (Integer a : list) {
			System.out.print(a + "");
		}
	}

	private static void solution(int[] arr) {
		System.out.println(arr.length);
		list.add(1);
	}
}