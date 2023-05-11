package com.pentspace.managementportal.configs;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;

@Configuration
@EnableWebMvc

public class SpringFoxConfig {

    @Bean
    public OpenAPI appInfo() {

//        Server server = new Server();
//
//        server.setUrl("https://xx483ppzvi.eu-west-1.awsapprunner.com");
//
//
//        server.setUrl("https://xx483ppzvi.eu-west-1.awsapprunner.com");
//        ArrayList<Server> servers = new ArrayList<>();
//        servers.add(server);

        return new OpenAPI()

                .info(new Info().title("Pentspace Management Service")
                        .version("1.0")
                        .description("Pentspace Management Service")
                        .termsOfService("https://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")));

    }


    @Bean
    public GroupedOpenApi httpApi() {
        return GroupedOpenApi.builder()
                .group("https")
                .pathsToMatch("/**")
                .build();
    }

}
