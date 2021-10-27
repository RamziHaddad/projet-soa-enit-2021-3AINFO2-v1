package enit.bank.controller;

import enit.bank.domain.entity.AccountTransaction;
import enit.bank.domain.entity.BankAccount;
import enit.bank.domain.resource.CardCred;
import enit.bank.domain.resource.ClientTransaction;
import enit.bank.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("bank")
@ApplicationScoped
@Slf4j
public class BankController {
    @Inject
    BankService bankService;

    @POST
    @Path("/transaction/make/{accountno}")
    @Transactional
    @Consumes("application/json")
    @Produces(MediaType.TEXT_PLAIN)
    public Response MakeTransaction(@PathParam("accountno") Long code, AccountTransaction accountTransaction) {
        BankAccount ba = bankService.getAccount(code);
        if(ba != null){
            log.info(ba.toString());
            ba.getAccountTransactionSet().add(accountTransaction);
            log.info(ba.toString());
            bankService.CreateAccount(ba);
            bankService.MakeTransaction(accountTransaction);
            return Response.ok(accountTransaction).status(201).build();
        }
        return Response.noContent().build();
    }

    @POST
    @Path("/account/make")
    @Transactional
    @Consumes("application/json")
    @Produces(MediaType.TEXT_PLAIN)
    public String MakeAccount(BankAccount bankAccount) {
        bankService.CreateAccount(bankAccount);
        return bankAccount.toString();
    }

    @GET
    @Path("/accountBalance/")
    @Consumes("application/json")
    @Produces(MediaType.TEXT_PLAIN)
    public List<AccountTransaction> AccountBalance(CardCred c){
        return bankService.findAllByAccount(c.getAccountCode());
    }

    @GET
    @Path("/testresource")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(ClientTransaction c){
        return c.toString();
    }

}
