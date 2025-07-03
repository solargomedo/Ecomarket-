package com.ecomarket.user_service.configuracion;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "Ecomarket API", description = "API Servicio de Usuario de Ecomarket", termsOfService = "https://ecomarket.com/terminos y servicios", version = "1.0.0", contact = @Contact(name = "Ecomarket soporte", url = "www.ecomarket.com/soporte", email = "ecomarket@gmail.com"), license = @License(name = "Victor Silva/Jose Astorga/Solange Argomedo", url = "https://www.apache.org/licenses/LICENSE-2.0")),

                servers = {
                                @Server(description = "DEV SERVER", url = "http://localhost:8080"),
                                @Server(description = "PROD SERVER", url = "http://ecomarcket:8080")
                }

)
public class SwaggerConfig {
}
