package test;

import java.net.URI;

import javax.tools.SimpleJavaFileObject;

public class StringJavaObject extends SimpleJavaFileObject {
	
	//源代码
	private String content = "";

	protected StringJavaObject(URI uri, Kind kind) {
		super(uri, kind);
		
	}
	
	public StringJavaObject(String _javaFileName, String _content) {
		super(_createStringJavaObjectUri(_javaFileName), Kind.SOURCE);
		content = _content;
	}
	
	private static URI _createStringJavaObjectUri(String name){
		//注意此处没有设置包名
		return URI.create("string:///"+ name + Kind.SOURCE.extension);
	}
	
	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors){
		return content;
	}

}
