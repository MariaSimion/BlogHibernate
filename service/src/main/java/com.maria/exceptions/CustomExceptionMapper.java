package com.maria.exceptions;


import javafx.animation.Animation;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by msimion on 9/1/2015.
 */
public class CustomExceptionMapper implements ExceptionMapper<CustomException> {

    Map<String, String> json;

    public Response toResponse(CustomException ex) {

        json = new HashMap<>();
        json.put("errors", ex.toString());

        switch (ex.getErrorCode()) {
            case ("NOT_FOUND"):
                return Response.status(Response.Status.NOT_FOUND.getStatusCode())
                        .entity(json.get("errors"))
                        .type(MediaType.APPLICATION_JSON)
                        .build();
            case ("BAD_REQUEST"):
                return Response.status(Response.Status.BAD_REQUEST.getStatusCode())
                        .entity(json.get("errors"))
                        .type(MediaType.APPLICATION_JSON)
                        .build();
            default:
                return Response.status(Response.Status.ACCEPTED.getStatusCode()).build();
        }
    }
}
