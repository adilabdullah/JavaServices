package com.java.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import com.java.controller.Controls;
import com.java.model.Response;

@XmlRootElement(name = "name") 

@Path("/bank")
public class Banking {
	
	@GET
    @Path("/testj")
	@Produces(MediaType.APPLICATION_JSON)
	public String displayMsgJson() {
		return "I am Adil Abdullah";
	}
	
	@GET
    @Path("/testx")
	@Produces(MediaType.APPLICATION_XML)
	public String displayMsgXml() {
		return "I am Adil Abdullah";
	}
	
	@POST
	@Path("/create")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response SaveAccount(@FormParam("account_no") String acct_no,
			@FormParam("account_title") String acct_title,
			@FormParam("min_limit") double min_limit,
			@FormParam("max_limit") double max_limit,
			@FormParam("transaction_limit") int max,
			@FormParam("balance") double bal,
			@FormParam("account_type") String acct_type,
			@FormParam("status") String status,
			@FormParam("max_tran_limit") double tran_limit,
			@HeaderParam("authorization") String authString)
	{
		Response rs=new Response();
		Controls cr=new Controls();

		if(!cr.isUserAuthenticated(authString))
		{
			rs.setCode("95");
		}
		else
		{	
		 try{
		  if(cr.AddAccount(acct_no,acct_title,min_limit,max_limit,max,bal,acct_type,status,tran_limit)==0)
		  {
			 rs.setCode("00");
			 rs.setDesc("Successfully create account");
		  }
		  else
		  {
			rs.setCode("97");
			rs.setDesc("Problem in creating account");
		  } 
		 }
		 catch(Exception ex)
		 { 
			ex.printStackTrace();
			rs.setCode("99");
			rs.setDesc("System malfunction");
			return rs;
		 }
		}
		return rs;
	}
	
	
	@GET
	@Path("/getAll")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getAll(@HeaderParam("authorization") String authString)
	{
		Response res=new Response();
		Controls cc=new Controls();
		if(!cc.isUserAuthenticated(authString))
		{
			res.setCode("95");
			res.setDesc("User Authentication Failed");
		}
		else
		{	
		  res.setCode("00");
		  res.setDesc("Successfull");
		  res.setResult(cc.getAll());
		}
		return res;
	}
			
	
}
