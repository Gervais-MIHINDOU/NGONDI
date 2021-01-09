package ngondi.ged.ga.exposition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "ngondi.ged.ga.exposition", "ngondi.ged.ga.infrastructure", "ngondi.ged.ga.domain",
		"ngondi.ged.ga.application" })
public class NgondiExpositionApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgondiExpositionApplication.class, args);
	}

}
