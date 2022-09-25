package uz.goodness.query;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI darslikApi(){
        return new OpenAPI().
                info(new Info().title("Darslik APP").description("Darslik Application"));
    }
}
