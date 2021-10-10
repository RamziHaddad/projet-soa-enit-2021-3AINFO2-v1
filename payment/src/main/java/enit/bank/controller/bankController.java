package enit.bank.controller;

import enit.bank.domain.resource.clientTransaction;
import enit.bank.service.bankService;
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
public class bankController {
    @Inject
    bankService bankService;
    
    @POST
    @Transactional
    public Response Pay(clientTransaction clientTransaction) {

        //check the code + password
        //create a new transaction from the resource got in the request body
        bankService.pay(clientTransaction);
        //persist the new transaction
        //return the response (transaction done or not )
        return Response.ok().status(201).build();
    }

}
