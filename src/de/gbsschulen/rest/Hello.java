package de.gbsschulen.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {

    // METHODS
    @GET
    @Produces (MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello";
    } // END public String sayHello()

} // END CLASS HELLO
