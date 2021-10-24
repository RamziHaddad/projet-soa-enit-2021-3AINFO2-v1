package enit.payement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.persistence.PersistenceException;
import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import enit.payement.repository.*;
import enit.payement.domain.entity.BankAccount;
import enit.payement.domain.entity.OrderToPay;
import org.springframework.beans.factory.annotation.Autowired;

public class PayementService {
    public static List<OrderToPay> ordersToPay = new ArrayList<>();
    public static Iterable<BankAccount> accountsIt = new ArrayList<>();
    final List<BankAccount> accounts = new ArrayList<>();

    @Autowired
    PaymentRepo paymentRepo;
    AccountRepo bankrepo;

    @POST
    public OrderToPay save(OrderToPay orderToPay) {
        paymentRepo.save(orderToPay);
        return orderToPay;
    }

    public Boolean postToBank(OrderToPay ordertopay) {
        accountsIt = bankrepo.findAll();
        accountsIt.forEach(accounts::add);
        if (accounts.contains(ordertopay.codeAccount)) {
            return true;
        } else {
            return false;
        }
    }

}
