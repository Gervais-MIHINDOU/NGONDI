/**
 * 
 */
package ngondi.ged.ga.exposition.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author gmihindou
 *
 */
@EnableSwagger2
@Configuration
public class ConfigSwagger {

	@Bean
	public Docket productApi() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("ngondi.ged.ga.exposition.api")).paths(regex("/ngondi.*"))
				.build();

	}

}
