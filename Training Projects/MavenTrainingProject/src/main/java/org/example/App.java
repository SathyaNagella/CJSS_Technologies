package org.example;

import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext classpath=new ClassPathXmlApplicationContext("Target.xml");
        BeanClass bean=(BeanClass) classpath.getBean("country");
        String name= bean.getName();
        System.out.println("Name : "+name);
        int id= Integer.parseInt(bean.getId());
        System.out.println("Id : "+id);

    }
}
