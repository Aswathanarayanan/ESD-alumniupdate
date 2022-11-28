package com.example.esdproject.controller;

import com.example.esdproject.Bean.Organisation;
import com.example.esdproject.Service.OrganisationService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Path("/organisation")
public class OrganisationController {
    OrganisationService organisationService=new OrganisationService();
    @GET
    @Path("/getorg")
    public Response getorgs(){
        List<Organisation> orglist=organisationService.getorglist();
        if(orglist.size()==0)
            return Response.status(404).entity(orglist).build();
        return Response.status(200).entity(orglist).build();
    }
}
