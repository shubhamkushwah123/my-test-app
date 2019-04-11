package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestController {
	
	private static final Logger log = LoggerFactory.getLogger(MyTestController.class);
	
	@RequestMapping("/mytest")
	public String myTestMethod() {
		log.info("hello, its an info");
		log.debug("hello, its an debug");
		return "mytest";
	}

	@RequestMapping("/hello")
	public String hello() {
		//System.out.println("Hello from test app");
		log.info("hello from test app1");
		return "hello from test app1";
	}
}
