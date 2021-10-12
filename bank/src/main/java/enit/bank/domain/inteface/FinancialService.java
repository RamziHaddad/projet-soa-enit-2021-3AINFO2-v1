package enit.bank.domain.inteface;

import enit.bank.domain.resource.ClientTransaction;

import javax.ws.rs.core.Response;

public interface FinancialService {
    ClientTransaction MakeTransaction(ClientTransaction clientTransaction);
}
