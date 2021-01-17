package com.atguigu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;

public class MainTest {
	public static void main(String[] args) {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//		Person bean = (Person) applicationContext.getBean("person");
//		System.out.println(bean.getName());
		
		AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext(MainConfig.class);
		Person beanPerson = applicationContext.getBean(Person.class);
		System.out.println(beanPerson);
		
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String string : beanNamesForType) {
			System.out.println(string);
		}
	}
}
