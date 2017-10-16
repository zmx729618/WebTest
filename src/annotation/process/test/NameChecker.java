package annotation.process.test;

import java.util.EnumSet;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner6;
import javax.tools.Diagnostic.Kind;

public class NameChecker {
	
	private final Messager messager;
	
	private NameCheckScanner nameCheckScanner = new NameCheckScanner();


	public NameChecker(ProcessingEnvironment processingEnv) {
    	this.messager = processingEnv.getMessager();
	}


	public void checkNames(Element element) {
		
		nameCheckScanner.scan(element);
	}
	
	
	private  class NameCheckScanner extends ElementScanner6<Void, Void>{
		
		
		
	    /**
	     * 此方法用于检查java类
	     * @param e
	     * @param p
	     * @return
	     */
		@Override
		public Void visitType(TypeElement e, Void p) {
			scan(e.getTypeParameters(),p);
			checkCamelCase(e,true);
			super.visitType(e, p);
			return null;
		}


	    /**
	     * 检查方法命名是否合法
	     * @param e
	     * @param p
	     * @return
	     */
		@Override
		public Void visitExecutable(ExecutableElement e, Void p) {
			if(e.getKind() == ElementKind.METHOD){
				Name name = e.getSimpleName();
				if(name.contentEquals(e.getEnclosingElement().getSimpleName())){
					messager.printMessage(Kind.WARNING,"一个普通方法"+name+"不应当与类名重复", e);
				}
				checkCamelCase(e,false);
				
			}
			super.visitExecutable(e, p);
			return null;
		}
		

        /**
         * 检查变量命名是否合法
         */
		@Override
		public Void visitVariable(VariableElement e, Void p) {
			if(e.getKind() == ElementKind.ENUM_CONSTANT || e.getConstantValue() !=null || heuristicallyConstant(e)){
				checkAllCaps(e);
			}else{
				checkCamelCase(e,false);
			}
			return null;
		}
		
		
		/**
		 * 判断一个常量是否是常量
		 * @param e
		 * @return
		 */
		private boolean heuristicallyConstant(VariableElement e) {
			
			if(e.getEnclosingElement().getKind() == ElementKind.INTERFACE){
				
				return true;
				
			}else if(e.getKind() == ElementKind.FIELD && e.getModifiers().containsAll(EnumSet.of(Modifier.PUBLIC,Modifier.STATIC,Modifier.FINAL))){
				
				return true;
				
			}else{
				
				return false;
				
			}
			
			
		}
		
		
		private void checkCamelCase(Element e, boolean initialCaps) {
			String name = e.getSimpleName().toString();
			boolean previousUpper  = false; //第一个字母是否大写 
			boolean conventional  = true;  // 是否是例外情况
			int firstCodePoint = name.codePointAt(0); //获取第一个字符的unicode编码值
			
			if(Character.isUpperCase(firstCodePoint)){//判断是否为大写，是
				previousUpper = true;
				if(!initialCaps){ //如果一个字符不为驼峰
					messager.printMessage(Kind.WARNING,"名称"+name+"应当以小写字母开头", e);
					return;
				}
					
			}else if(Character.isLowerCase(firstCodePoint)){//判断是否为小写，是
				if(initialCaps){ //如果一个字符是驼峰
					messager.printMessage(Kind.WARNING,"名称"+name+"应当以大写字母开头", e);
					return;
				}
			}else{
				conventional  = false;
			}
			
			if(!conventional){
				messager.printMessage(Kind.WARNING,"名称"+name+"应当符合驼峰命名法", e);
			}
			
			
		}
		
		/**
		 * 大写检查：
		 * @param e
		 */
		private void checkAllCaps(VariableElement e) {
			String name = e.getSimpleName().toString();
			boolean conventional  = true;  // 是否是例外情况
			int firstCodePoint = name.codePointAt(0); //获取第一个字符的unicode编码值
			if(!Character.isUpperCase(firstCodePoint)){
				conventional = false ;
			}else{
				boolean previousUnderscore = false;   //第一个不是下划线
				int cp = firstCodePoint;
				for(int i= Character.charCount(cp); i<name.length(); i +=Character.charCount(cp)){
					cp = name.codePointAt(i);
					if(cp == (int)'_'){//判断字符是否为下划线
						if(previousUnderscore){ //前一个是下划线
							conventional = false ;
							break;
						}
						previousUnderscore = true;
					}else{
						previousUnderscore = false;
						if(!Character.isUpperCase(cp)&& !Character.isDigit(cp)){
							conventional = false ;
							break;
						}
					}
				}
			} 
			
			if(!conventional){
				messager.printMessage(Kind.WARNING,"常量"+name+"应当全部以大写字母或下划线，并且以字母开头", e);
			}
			
			
		}	
		

	}

	
	
	
	

}
