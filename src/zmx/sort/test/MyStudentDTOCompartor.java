package zmx.sort.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyStudentDTOCompartor implements Comparator<StudentDTO>{

	@Override
	public int compare(StudentDTO o1, StudentDTO o2) {

        return o1.getAge().compareTo(o2.getAge());

	}
	
	
	public static void main(String[] args) {
		
		List<StudentDTO> studentList = new ArrayList<>();

		StudentDTO  s = new StudentDTO ();

		s.setName("yuanyuan");

	    s.setAge(22);

		studentList.add(s);

		StudentDTO s1 = new StudentDTO ();

		s1.setName("lily");

		s1.setAge(23);

        studentList.add(s1);
        MyStudentDTOCompartor msc = new MyStudentDTOCompartor();  //定义比较器
		Collections.sort(studentList, msc);   //使用比较器进行排序
		for(StudentDTO sd : studentList){
			System.out.print(sd.getAge()+" ");
		}
        System.out.println();
        
		Collections.reverse(studentList);
		
		for(StudentDTO sd : studentList){
			System.out.print(sd.getAge()+" ");
		}
        System.out.println(); 
	}
	
	

}
