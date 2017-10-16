package zmx.test;


import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;
 
public class T16 {
 
/**
 * 2016-08-09 --02
 * 解救小易
有一片1000*1000的草地，小易初始站在(1,1)(最左上角的位置)。小易在每一秒会横向或者纵向移动到相邻的草地上吃草(小易不会走出边界)。
大反派超超想去捕捉可爱的小易，他手里有n个陷阱。第i个陷阱被安置在横坐标为xi ，纵坐标为yi 的位置上，小易一旦走入一个陷阱，将会被超超捕捉。
你为了去解救小易，需要知道小易最少多少秒可能会走入一个陷阱，从而提前解救小易。
输入描述:
第一行为一个整数n(n ≤ 1000)，表示超超一共拥有n个陷阱。
第二行有n个整数xi，表示第i个陷阱的横坐标
第三行有n个整数yi，表示第i个陷阱的纵坐标
保证坐标都在草地范围内。
输出描述:
输出一个整数,表示小易最少可能多少秒就落入超超的陷阱
输入例子:
3
4 6 8
1 2 1
输出例子:
3
思路:
 计算最短距离
 */
public static void main(String[] args) {
	
	

Scanner in = new Scanner(System.in);
while(in.hasNextLine()){
String n = in.nextLine();
String x = in.nextLine();
String y = in.nextLine();
String [] str;
int num = 0;
ArrayList<Integer> listX = new ArrayList<Integer>();
ArrayList<Integer> listY = new ArrayList<Integer>();
Pattern pattern = Pattern.compile("[ ]");
str = pattern.split(n);
num = Integer.parseInt((str[0]));
str = pattern.split(x);
listX = split(str);
str = pattern.split(y);
listY = split(str);
//int min = listX.get(0) + listY.get(0) - 2;
int min = (listX.get(0)-1)*(listX.get(0)-1) + (listY.get(0)-1) * (listY.get(0)-1);
int value = 0;
int pos = 0, posX, posY;
// 寻找最近的陷阱
for(int i = 1; i < num; i++){
value = (listX.get(i)-1)*(listX.get(i)-1) + (listY.get(i)-1) * (listY.get(i)-1);
//value = listX.get(i) + listY.get(i) - 2;
 if(min > value){
 min = value;
 pos = i;
 }
}
posX = listX.get(pos);
posY = listY.get(pos);
System.out.println(posX + ":" + posY);
int space = (posY - 1) + (posX - 1);
System.out.println(space);
}
}
private static ArrayList<Integer> split(String [] str){
int len = str.length;
ArrayList<Integer> list = new ArrayList<Integer>();
for(int i = 0; i < len; i++){
list.add(i, Integer.parseInt(str[i]));
}
return list;
}
}
