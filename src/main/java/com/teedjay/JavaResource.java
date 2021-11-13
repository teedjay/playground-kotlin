package com.teedjay;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/java")
public class JavaResource {

    @Inject
    DoStuffInParallel dsip;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return dsip.callMultipleServices("Hello", "Java", "RESTEasy");
    }

}