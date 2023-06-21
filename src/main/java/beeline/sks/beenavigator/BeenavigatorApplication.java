package beeline.sks.beenavigator;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
        info =@Info(
                title = "API",
                description = "API", version = "1.0.0",
                contact = @Contact(
                        name = "Elditar",
                        email = "EAlymbekov@beeline.kg",
                        url = "http://rezka.ag"
                )
        )
)
@SpringBootApplication
public class BeenavigatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeenavigatorApplication.class, args);
    }
}
