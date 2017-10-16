package java7.character.test;
/**
 * java7 新曾了switch语句的String支持。
 * @author zhangwenchao
 *
 */
public class SwitchTest {
	
	public static void main(String[] args) {
		String name = "张晓晓";
		String sex = "女";
		switch (sex) {
		case "男":
			String title = name +"先生";
			System.out.println(title);
			break;
			
        case "女":
            title = name +"女士";
			System.out.println(title);
			break;

		default:
			title = name +"同学";
			System.out.println(title);
			break;
		}
	}

}
