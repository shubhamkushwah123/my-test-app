package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestController {
	
	@RequestMapping("/mytest")
	public void myTestMethod() {
		System.out.println("I am running here babe");
	}

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("Hello from test app");
		return "hello from test app";
	}
}
