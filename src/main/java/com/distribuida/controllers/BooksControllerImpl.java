package com.distribuida.controllers;

import com.distribuida.db.Books;
import com.distribuida.servicios.BookRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonBuilderFactory;
import jakarta.json.JsonObject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.util.Collections;
import java.util.List;
@Path("/books")
@ApplicationScoped

public class BooksControllerImpl implements BooksController{
private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());

@Inject
private BookRepository booksService;



@Override
@GET
@Operation(summary = "BUSCAR",
		description = "Listar todos")
@APIResponse(description = "Books: ",
		content = @Content(mediaType = MediaType.APPLICATION_JSON,
				schema = @Schema(implementation = Books.class)),
		responseCode = "200")
@Produces(MediaType.APPLICATION_JSON)
public List<Books> findAll() {
	return booksService.findAll();
}


@GET
@Path("/{id}")
@Operation(summary = "BUSCAR POR id",
		description = "Buscar mediante el id")
@APIResponse(description = "Book: ",
		content = @Content(mediaType = MediaType.APPLICATION_JSON,
				schema = @Schema(implementation = Books.class)),
		responseCode = "200")
@Produces(MediaType.APPLICATION_JSON)
public Books findById(@PathParam("id") int id) {
	return booksService. findById(id);
}

@Override
@PUT
@Path("/{id}")
@Operation(summary = "ACTUALIZAR/UPDATE",
				description = "Actualiza mediante el id")
@APIResponse(description = "Actualizado",
						content = @Content(mediaType = MediaType.APPLICATION_JSON,
						schema = @Schema(implementation = Books.class)),
						responseCode = "200")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Books update(@PathParam("id") int id, Books books) {
	Books singObj = booksService.findById(id);
	if (singObj != null) {
		
		return booksService.update(singObj);
	}
	return null;
}


@POST
@Operation(summary = "INSERTAR/CREAR",
			description = "Nuevo libro")
@APIResponse(description = "Insertado",
		content =  @Content(mediaType = MediaType.APPLICATION_JSON,
		schema = @Schema(implementation = Books.class)),
		responseCode = "200")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Books insert(Books books) {
	return booksService.insert(books);
}

@Override
@DELETE
@Path("/{id}")
@Operation(summary = "ELIMINAR/DELETE",
		description = "Eliminar libro")
@APIResponse(description = "Eliminado",
		content =  @Content(
				schema = @Schema(implementation = Books.class)),
				responseCode = "200")
public void delete(@PathParam("id") int id) {
	booksService.delete(id);
}


}
