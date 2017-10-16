package zmx.util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * JACOB一个Java-COM中间件.通过这个组件你可以在Java应用程序中调用COM组件和Win32 libraries
 * 实现Word转换为Html
 * @author zhangwenchao
 *
 */
public class JacobUtil {
	
	// 8 代表word保存成html
	public static final int WORD_HTML = 8; 

	public static void main(String[] args) {
		String docfile = "C:\\Users\\zhangwenchao\\Desktop\\xxx.docx";
		String htmlfile = "C:\\Users\\zhangwenchao\\Desktop\\xxx.html";
		JacobUtil.wordToHtml(docfile, htmlfile);
	}
	
    /**  
     * WORD转HTML  
     * @param docfile WORD文件全路径  
     * @param htmlfile 转换后HTML存放路径  
     */  
    public static void wordToHtml(String docfile, String htmlfile)   
    {   
    	// 启动word应用程序(Microsoft Office Word 2003)
        ActiveXComponent app = new ActiveXComponent("Word.Application");
        System.out.println("正在转换，请稍后...");
        try  
        {	
        	// 设置word应用程序不可见  
            app.setProperty("Visible", new Variant(false));  
            // documents表示word程序的所有文档窗口，（word是多文档应用程序）
            Dispatch docs = app.getProperty("Documents").toDispatch();  
            // 打开要转换的word文件
            Dispatch doc = Dispatch.invoke(   
                    docs,   
                    "Open",   
                    Dispatch.Method,   
                    new Object[] { docfile, new Variant(false), 
                    		new Variant(true) }, new int[1]).toDispatch();   
            // 作为html格式保存到临时文件
            Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {   
                    htmlfile, new Variant(WORD_HTML) }, new int[1]);   
            // 关闭word文件
            Dispatch.call(doc, "Close", new Variant(false));   
        }   
        catch (Exception e)   
        {   
            e.printStackTrace();   
        }   
        finally  
        {   
        	//关闭word应用程序
            app.invoke("Quit", new Variant[] {});   
        } 
        System.out.println("*****转换完毕********");
    }
}