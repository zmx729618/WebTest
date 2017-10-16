package zmx.reflect.test.asm;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.mockito.asm.ClassReader;
import org.mockito.asm.MethodVisitor;
import org.mockito.asm.Opcodes;
import org.mockito.asm.Type;
import org.mockito.asm.tree.AbstractInsnNode;
import org.mockito.asm.tree.AnnotationNode;
import org.mockito.asm.tree.ClassNode;
import org.mockito.asm.tree.FieldNode;
import org.mockito.asm.tree.LdcInsnNode;
import org.mockito.asm.tree.LocalVariableNode;
import org.mockito.asm.tree.MethodNode;


public class MainTest {
	
	public static void main(String[] args){
		
		/*try { 
			    ClassReader reader = new ClassReader("zmx.reflect.test.asm.ForReadClass"); 
			    ClassNode cn = new ClassNode(); 
			    reader.accept(cn, 0); 
			    System.out.println(cn.name); 
			    List<FieldNode> fieldList = cn.fields; 
			    for (FieldNode fieldNode : fieldList) { 
			        System.out.println("Field name: " + fieldNode.name); 
			        System.out.println("Field desc: " + fieldNode.desc); 
			        System.out.println("Filed value: " + fieldNode.value); 
			        System.out.println("Filed access: " + fieldNode.access); 
			     } 
		} catch (IOException e) { 
		    e.printStackTrace(); 
		}*/ 
		
		
		try { 
			            ClassReader reader = new ClassReader("zmx.reflect.test.asm.ForReadClass"); 
			            ClassNode cn = new ClassNode(); 
			            reader.accept(cn, 0); 
			            List<MethodNode> methodList = cn.methods; 
			            for (MethodNode md : methodList) { 
			                System.out.println(md.name); 
			                System.out.println(md.access); 
		                    System.out.println(md.desc); 
			                System.out.println(md.signature); 
			                List<LocalVariableNode> lvNodeList = md.localVariables; 
			                for (LocalVariableNode lvn : lvNodeList) { 
			                    System.out.println("Local name: " + lvn.name); 
			                    System.out.println("Local name: " + lvn.start.getLabel()); 
			                    System.out.println("Local name: " + lvn.desc); 
			                    System.out.println("Local name: " + lvn.signature); 
			                } 
			                Iterator<AbstractInsnNode> instraIter = md.instructions.iterator(); 
			                while (instraIter.hasNext()) { 
			                    AbstractInsnNode abi = instraIter.next(); 
			                    if (abi instanceof LdcInsnNode) { 
			                        LdcInsnNode ldcI = (LdcInsnNode) abi; 
			                        System.out.println("LDC node value: " + ldcI.cst); 
			                    } 
			                } 
			            } 
			            MethodVisitor mv = cn.visitMethod(Opcodes.AALOAD, "<init>", Type 
			                    .getType(String.class).toString(), null, null); 
			            mv.visitFieldInsn(Opcodes.GETFIELD, Type.getInternalName(String.class), "str", Type 
			                    .getType(String.class).toString()); 
			            System.out.println(cn.name); 
			            List<FieldNode> fieldList = cn.fields; 
			            for (FieldNode fieldNode : fieldList) { 
			                System.out.println("Field name: " + fieldNode.name); 
			                System.out.println("Field desc: " + fieldNode.desc); 
			                System.out.println("Filed value: " + fieldNode.value); 
			                System.out.println("Filed access: " + fieldNode.access); 
			                if (fieldNode.visibleAnnotations != null) { 
			                    for (Object anNode : fieldNode.invisibleAnnotations) { 
			                        System.out.println(((AnnotationNode)anNode).desc); 
			                    } 
			                } 
			            } 
			        } catch (IOException e) { 
			            e.printStackTrace(); 
			        } catch (SecurityException e) { 
			            e.printStackTrace(); 
			        } catch (IllegalArgumentException e) { 
			            e.printStackTrace(); 
			        } 
		    } 

	

}
