package zmx.reflect.test;

import static java.lang.System.out;

import java.lang.reflect.Field;

import javassist.Modifier;

public class FieldTest {

	enum Color {

		Blue,

		Red

	}

	class Inner {

	}

	public static void main(String args[]) throws  Exception {

		Role role = new Role();

		role.setId("role1");

		role.setUserId("user1");

		role.setRoleName("Role1");

		//Field idField = getDeclaredField(role.getClass(), "id");
		Field idField = role.getClass().getField("id");

		Field childrenField = getDeclaredField(role.getClass(), "children");

		Field roleTypeField = getDeclaredField(role.getClass(), "roleType");

		Field userField = getDeclaredField(role.getClass(), "user");

		// 获取属性声明时类型对象（返回class对象）

		System.out.println(idField.getType());

		// 返回属性声的Type类型

		System.out.println(idField.getGenericType());

		// 如果属性是一个泛型，从getType只能得到这个属性的接口类型

		System.out.println(childrenField.getType());

		// 如果属性是一个参数化类型，从getGenericType还能得到这个泛型的参数类型

		System.out.println(childrenField.getGenericType());

		// 获取属性声明时名字

		System.out.println(idField.getName());

		// 获得这个属性上所有的注释

		System.out.println(idField.getAnnotations().length);

		// 获取属性的修饰

		System.out.println(Modifier.toString(idField.getModifiers()));

		// 判断这个属性是否是枚举类

		System.out.println(roleTypeField.isEnumConstant());

		// 判断这个属性是否是复合类

		System.out.println(userField.isSynthetic());

		// FieldTest$Color是Color枚举类编译后的名字。

		isSyntheticOrEnumConstant("zmx.reflect.test.FieldTest$Color");

		// FieldTest$Inner是Inner类编译后的名字。

		isSyntheticOrEnumConstant("zmx.reflect.test.FieldTest$Inner");

		try

		{

			// 取得对象这个Field上的值

			System.out.println(idField.get(role));

			// 向对象的这个Field重新设置值

			idField.set(role, "role2");

			System.out.println(idField.get(role));

		} catch(IllegalArgumentException e) {

			e.printStackTrace();

		} catch

		(IllegalAccessException e) {

			e.printStackTrace();

		}

	}

	public static Field getDeclaredField(final Class cla, final String fieldName) {

		for(Class superClass = cla; superClass != null; superClass = superClass.getSuperclass()) {

			try{

				return superClass.getDeclaredField(fieldName);

			} catch (NoSuchFieldException e) {

				e.printStackTrace();

			}

		}

		return null;

	}

	public static void isSyntheticOrEnumConstant(String completePackageName) {

		try

		{

			Class<?> c = Class.forName(completePackageName);

			Field[] flds = c.getDeclaredFields();

			for

			(Field f : flds) {

				out.format("%-8s[ synthetic=%-5b enum_constant=%-5b ]%n",

				c.getName() + ":"

				+ f.getName(), f.isSynthetic(), f.isEnumConstant());

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

}
