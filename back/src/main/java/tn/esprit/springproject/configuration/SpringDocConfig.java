package tn.esprit.springproject.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI springShopOpenAPI(){
        return  new OpenAPI().info(infoAPI());
    }
    public Info infoAPI(){
        return  new Info().title("SprincDoc-FoyerProject").description("TP étude de cas").contact(contactAPI());
    }
    public Contact contactAPI(){
        return new Contact().name("ImenFrigui").email("imen.frigui@esprit.tn").url("https://github.com/Imen-Frigui");
    }
    @Bean
    public GroupedOpenApi allPublicApi() {
        return GroupedOpenApi.builder()
                .group("All Management API")
                .pathsToMatch("/**")
                .build();
    }
    @Bean
    public GroupedOpenApi foyerPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Foyer Management API")
                .pathsToMatch("/foyer/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi blocPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Bloc Management API")
                .pathsToMatch("/bloc/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi etudiantPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only etudiant Management API")
                .pathsToMatch("/etudiant/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi universitePublicApi() {
        return GroupedOpenApi.builder()
                .group("Only universite Management API")
                .pathsToMatch("/universite/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi chambrePublicApi() {
        return GroupedOpenApi.builder()
                .group("Only chambre Management API")
                .pathsToMatch("/chambre/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi reservationPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only reservation Management API")
                .pathsToMatch("/reservation/**")
                .pathsToExclude("**")
                .build();
    }
}
