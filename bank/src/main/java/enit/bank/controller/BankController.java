package enit.bank.controller;

import enit.bank.domain.entity.AccountTransaction;
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
    @Path("/transaction/make")
    @Transactional
    public Response MakeTransaction(AccountTransaction accountTransaction) {

        bankService.MakeTransaction(accountTransaction);
        return Response.ok(accountTransaction).status(201).build();
    }

}
