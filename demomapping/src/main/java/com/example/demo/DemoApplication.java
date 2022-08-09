package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext=
		SpringApplication.run(DemoApplication.class, args);
		CartRepository questionRepository=configurableApplicationContext.getBean(CartRepository.class);

		Cart cart1=new Cart("Cart111");//1

		Items item1=new Items("item111",cart1);
		Items item2=new Items("item112",cart1);

		List<Items> itemsList1= Arrays.asList(item1,item2);

		cart1.setItems(itemsList1);
	questionRepository.save(cart1);
		//------------------------------------------------------------------------------------------

		Cart cart2=new Cart("Cart222");//4

		Items item3=new Items("item223",cart2);
		Items item4=new Items("item224",cart2);

		List<Items> itemsList2= Arrays.asList(item3,item4);

		cart2.setItems(itemsList2);
	questionRepository.save(cart2);
	}


}
