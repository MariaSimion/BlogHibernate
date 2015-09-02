package com.maria.exceptions;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by msimion on 9/1/2015.
 */
public class CustomExceptionMapper implements ExceptionMapper<CustomException> {

    public Response toResponse(CustomException ex) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("errors", new String[]{ex.getMessage()});

        return Response.status(Response.Status.NOT_FOUND.getStatusCode())
                .entity(json)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
