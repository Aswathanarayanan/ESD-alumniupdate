package com.example.esdproject.controller;

import com.example.esdproject.Bean.AlumniEducation;
import com.example.esdproject.Bean.AlumniOrgnisation;
import com.example.esdproject.Bean.Organisation;
import com.example.esdproject.Service.AlumniOrganisationService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.PrintStream;
import java.util.List;
import java.util.ListIterator;

@Path("/alumniorganisation")
public class AlumniOrganisationController {
    AlumniOrganisationService alumniOrganisationService =new AlumniOrganisationService();

//    @GET
//    @Path("/getorglist")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getOrgList(@QueryParam("id") Integer id){
//        List<Organisation> organisationList=alumniOrganisationService.getorglidt(id);
//        System.out.println("Got the org list");
//        if(organisationList.size()==0)
//            return Response.status(404).entity(organisationList).build();
//        return Response.status(200).entity(organisationList).build();
//    }

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

    @GET
    @Path("/getalumniorg")
    public Response getalumniorg(@QueryParam("id")Integer id){
        List<AlumniOrgnisation> res=alumniOrganisationService.getalumniorg(id);
        System.out.println("alumniorglist");
        if(res.size()!=0)
            return Response.status(200).entity(res).build();
        return Response.status(404).entity(res).build();
    }
}
