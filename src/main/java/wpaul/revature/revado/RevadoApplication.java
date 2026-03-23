package wpaul.revature.revado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class RevadoApplication {

	@Value("${spring.application.name}")
	private String appName;

	public static void main(String[] args) {
		SpringApplication.run(RevadoApplication.class, args);
	}

	@Bean
	public CommandLineRunner inspectorBean(ApplicationContext applicationContext){ // this is where all the beans live
		return args -> {
			System.out.printf("Inspecting spring boot beans in %s \n", appName);

			String[] beans = applicationContext.getBeanDefinitionNames();
			Arrays.sort(beans);

			for(String bean : beans){
				System.out.println(bean);
			}
		};
	}
}
