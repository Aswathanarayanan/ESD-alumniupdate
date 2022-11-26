package com.example.esdproject.controller;

import com.example.esdproject.Bean.AlumniEducation;
import com.example.esdproject.Bean.AlumniOrgnisation;
import com.example.esdproject.Service.AlumniOrganisationService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/alumniorganisation")
public class AlumniOrganisationController {
    AlumniOrganisationService alumniOrganisationService =new AlumniOrganisationService();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateOrganisation(@QueryParam("id") Integer id,@QueryParam("org") Integer org, AlumniOrgnisation alumniOrgnisation) {
        AlumniOrgnisation orgnisation=alumniOrganisationService.updateorganisation(id,org,alumniOrgnisation);
        System.out.println("send response");
        if(orgnisation!=null)
            return Response.status(200).entity("Success").build();
        return Response.status(404).entity("failed").build();
    }
    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteorganisation(@QueryParam("id") Integer id) {
        AlumniOrgnisation orgnisation=alumniOrganisationService.deleteorganisation(id);
        System.out.println("send response");
        if(orgnisation!=null)
            return Response.status(200).entity("Success").build();
        return Response.status(404).entity("failed").build();
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response changeorgdetails(@QueryParam("id") Integer id,AlumniOrgnisation alumniOrgnisation) {
        AlumniOrgnisation orgnisation=alumniOrganisationService.changeorgdetails(id,alumniOrgnisation);
        System.out.println("send response");
        if(orgnisation!=null)
            return Response.status(200).entity("Success").build();
        return Response.status(404).entity("failed").build();
    }
}
