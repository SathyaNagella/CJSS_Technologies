package org.example;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
public class App
{
    public static void main( String[] args )
    {
       FileSystemXmlApplicationContext ac = new FileSystemXmlApplicationContext("C://temp//Config.xml");
        BeanClass countryBean = (BeanClass) ac.getBean("beanClass");
        String name = countryBean.getName();
        System.out.println("Country name: "+name);
        long population = countryBean.getPopulation();
        System.out.println("Country population: "+population);
        ac.close();
    }
}
