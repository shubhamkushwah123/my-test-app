package hello;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@RequestMapping("/")
    public String home() throws Exception {
		log.info("Default / endpoint is called");
		log.debug("it returns hello from Docker World");
		System.out.println("hello");
		String address = InetAddress.getLocalHost().toString();
        return "Hello Docker World" + address;
    }
	
	
	public static void main(String[] args) {
		log.info("Main method has been invoked");
		SpringApplication.run(Application.class,args);
	}

}
