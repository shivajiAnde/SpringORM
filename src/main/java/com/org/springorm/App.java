package com.org.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.org.orm.dao.StudentDao;
import com.org.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//       ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
//      StudentDao dao = context.getBean("studentDao",StudentDao.class);
//       Student student = new Student(1,"shivaji","mydukur");
//       int result = dao.insert(student);
//       System.out.println(result);
      
      		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      		
      		boolean go=true;
      		while(go) {
		      		System.out.println("Press 1 for adding new Student");
		      		System.out.println("Press 2 for displaying single student data");
		      		System.out.println("Press 3 for displaying all students data");
		      		System.out.println("Press 4 for delete the student");
		      		System.out.println("Press 5 for update the student");
		      		System.out.println("Press 6 for exit");
		      		
		      		try {
		      			int choice = Integer.parseInt(br.readLine());
		      			switch (choice) {
						case 1:
							int id=Integer.parseInt(br.readLine());
							String name=br.readLine();
							String city=br.readLine();
							Student student=new Student(id,name,city);
//							int result = dao.insert(student);
							System.out.println("no of rows inserted are: ");
							break;
						case 6:
							go=false;
							break;
						default:
							break;
						}
		      			
		      			
		      			
		      			
		      			
		      			
						
					} catch (Exception e) {
						System.out.println("invalid input try with another one");
						System.out.println(e.getMessage());
					}
		      			
      		}
    }
}
