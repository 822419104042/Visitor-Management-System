package newproject.visitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ServletComponentScan
@EnableSwagger2
@EnableWebMvc
public class VisitorApplication {
	public static void main(String[] args) {
		SpringApplication.run(VisitorApplication.class, args);
		System.out.println("hi");
	}
}

