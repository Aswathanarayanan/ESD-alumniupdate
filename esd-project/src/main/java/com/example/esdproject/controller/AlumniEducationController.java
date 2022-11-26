package com.example.esdproject.controller;

import com.example.esdproject.Bean.Alumni;
import com.example.esdproject.Bean.AlumniEducation;
import com.example.esdproject.Service.AlumniEducationService;
import com.example.esdproject.Service.AlumniService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/alumnieducation")
public class AlumniEducationController {
    AlumniEducationService alumniEducationService=new AlumniEducationService();

//    @POST
//    @Path("/add")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response addeducation(@)

    /*
    api : /api/alumnieducation/update?id={alumniid}
     */
    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateALumnieducation(@QueryParam("id") Integer id,AlumniEducation alumniEducation) {
        AlumniEducation education=alumniEducationService.updatealumnieducation(id,alumniEducation);
        System.out.println("send response");
        if(education!=null)
            return Response.status(200).entity("Success").build();
        return Response.status(404).entity("failed").build();
    }
}
