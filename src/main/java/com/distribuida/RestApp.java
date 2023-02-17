package com.distribuida;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@ApplicationPath("/")@OpenAPIDefinition(
        info = @Info(
                title="Books CRUD",
                version = "1.0.0",
                description = "Permite realizar las siguientes operaciones" +
                        "INSERT" +
                        "DELETE" +
                        "UPDATE" +
                        "READ"

        )
)
public class RestApp extends Application {
}
