package com.distribuida.openApi;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.OASFilter;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.Operation;
import org.eclipse.microprofile.openapi.models.info.Info;
import org.eclipse.microprofile.openapi.models.info.License;
import org.eclipse.microprofile.openapi.models.responses.APIResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class apenApi implements OASFilter {

    @Override
    public APIResponse filterAPIResponse(APIResponse apiResponse) {
        if ("Descripcion incompleta".equals(apiResponse.getDescription())) {
            apiResponse.setDescription("null book ");
        }
        return apiResponse;
    }

    @Override
    public void filterOpenAPI(OpenAPI openAPI) {
        openAPI.setInfo(
                OASFactory.createObject(Info.class).title("Books CRUD").version("1.0.0")
                        .description(
                                "CRUD App-Books")
                        .license(
                                OASFactory.createObject(License.class)
                                        .name("Eclipse Public License").url(
                                                "https://www.eclipse.org/legal/epl-v10.html")));

        openAPI.addServer(
                OASFactory.createServer()
                        .url("http://localhost:{port}")
                        .variables(Collections.singletonMap("port",
                                OASFactory.createServerVariable()
                                        .description("puerto HTTP."))));
        var tag = OASFactory.createTag().name("Books");
        List<String> tags = new ArrayList<>();
        tags.add("Books");
        openAPI.setPaths(OASFactory.createPaths()
                .addPathItem("/books", OASFactory.createPathItem()
                                                        .GET(OASFactory.createOperation()
                                                        .description("consultar por id"))));

    }

}
