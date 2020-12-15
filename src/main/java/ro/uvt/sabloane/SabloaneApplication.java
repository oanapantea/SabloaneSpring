package ro.uvt.sabloane;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ro.uvt.sabloane.lab11.ClientComponent;
import ro.uvt.sabloane.lab11.SingletonComponent1;
import ro.uvt.sabloane.lab11.TransientComponent;

@SpringBootApplication
public class SabloaneApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SabloaneApplication.class, args);

        TransientComponent transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        SingletonComponent1 singletonBean = context.getBean(SingletonComponent1.class);
        singletonBean.operation();

        singletonBean = context.getBean(SingletonComponent1.class);
        singletonBean.operation();

        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();

        c = (ClientComponent) context.getBean("clientComponent");
        c.operation();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring boot training  API")
                        .version("1.0")
                        .description("Spring training api description")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));

    }
}
