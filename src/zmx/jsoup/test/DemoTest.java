package zmx.jsoup.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class DemoTest {
	
	public static void main(String[] args) {
		String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";  
		Document doc = Jsoup.parse(html);//解析HTML字符串返回一个Document实现  
		Element link = doc.select("a").first();//查找第一个a元素    
		String text = doc.body().text(); // "An example link"//取得字符串中的文本  
		String linkHref = link.attr("href"); // "http://example.com/"//取得链接地址  
		String linkText = link.text(); // "example""//取得链接地址中的文本    
		String linkOuterH = link.outerHtml(); // "<a href="http://example.com"><b>example</b></a>"  
		String linkInnerH = link.html(); // "<b>example</b>"//取得链接内的html内容
        System.out.println(text);
        System.out.println(linkHref);
        System.out.println(linkText);
        System.out.println(linkOuterH);
        System.out.println(linkInnerH);
	}

}
