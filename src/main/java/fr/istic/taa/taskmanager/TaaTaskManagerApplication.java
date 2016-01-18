package fr.istic.taa.taskmanager;

import fr.istic.taa.taskmanager.datafixtures.TestingDataFixtures;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "fr.istic.taa")
@EnableAutoConfiguration
public class TaaTaskManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaaTaskManagerApplication.class, args);
	}
}
