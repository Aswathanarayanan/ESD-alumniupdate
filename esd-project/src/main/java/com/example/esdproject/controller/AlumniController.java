package com.example.esdproject.controller;

import com.example.esdproject.Bean.Alumni;
import com.example.esdproject.DAO.DAOImplementation.AlumniDAOimpl;
import com.example.esdproject.Service.AlumniService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/alumni")
public class AlumniController{
    AlumniService alumniService =new AlumniService();

    @GET
    @Path("/get")
    public Response get_all_alumni(){
        List<com.example.esdproject.Bean.Alumni> alumniList= alumniService.getAlumniList();
        System.out.println("send response");
        return Response.status(200).entity(alumniList).build();
    }
    @POST
    @Path("/set")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add_alumni(Alumni alu){
            if(alumniService.add_alumni(alu)){
                return Response.status(200).entity("Success").build();
        }
        return Response.status(400).entity("Failure while adding department").build();
    }

    /*
    Path: GET /api/alumni?id={alumniid}
    Input: {alumniid}
    Response: 200 Status Code with the Alumni details
    Description: Return alumni with id = {alumniId}
            */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_alumni_details(@QueryParam("id") int id){
        Alumni alumni=alumniService.getIdAlumnilist(id);
        System.out.println("send response - id get");
        return Response.ok().entity(alumni).build();
    }

    @POST
    @Path("/updatecontact")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updatecontact(@QueryParam("id") int id,Alumni alumni){
        Alumni updatedalumni= alumniService.updatedalumnicontact(id,alumni);
        System.out.println("send response");
        return Response.status(200).entity(updatedalumni).build();
    }
}
