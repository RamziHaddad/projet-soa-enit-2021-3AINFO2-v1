package enit.bank.controller;

import enit.bank.domain.entity.AccountTransaction;
import enit.bank.domain.entity.BankAccount;
import enit.bank.domain.resource.ClientTransaction;
import enit.bank.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("bank")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
@Slf4j
public class BankController {
    private static Logger logger;

    @Inject
    BankService bankService;

    @POST
    @Path("/transaction/make")
    @Transactional
    public Response MakeTransaction(AccountTransaction accountTransaction) {
        logger.info(String.valueOf(accountTransaction));
        bankService.MakeTransaction(accountTransaction);
        return Response.ok(accountTransaction).status(201).build();
    }

    @POST
    @Path("/account/make")
    @Transactional
    public Response MakeTransaction(BankAccount bankAccount) {
        logger.info(String.valueOf(bankAccount));
        bankService.CreateAccount(bankAccount);
        return Response.ok(bankAccount).status(201).build();
    }
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }
}
