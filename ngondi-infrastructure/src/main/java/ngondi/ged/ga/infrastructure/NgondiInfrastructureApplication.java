package ngondi.ged.ga.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@ComponentScan("ngondi.ged.ga.infrastructure")
@EntityScan(basePackages = { "ngondi.ged.ga.infrastructure" })
@SpringBootApplication
public class NgondiInfrastructureApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgondiInfrastructureApplication.class, args);
	}

}
