package enit.bank.controller;

import enit.bank.domain.resource.ClientTransaction;
import enit.bank.service.BankService;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("bank")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
@Slf4j
public class BankController {
    @Inject
    BankService bankService;
    
    @POST
    @Transactional
    public Response MakeTransaction(ClientTransaction clientTransaction) {

        //check the code + password
        //create a new transaction from the resource got in the request body
        //persist the new transaction
        //return the response (transaction done or not )
        return Response.ok().status(201).build();
    }

}
