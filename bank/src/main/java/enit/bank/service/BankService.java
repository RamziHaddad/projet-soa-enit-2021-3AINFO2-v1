package enit.bank.service;

import enit.bank.domain.inteface.FinancialService;
import enit.bank.domain.resource.ClientTransaction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class BankService implements FinancialService {
    public ClientTransaction MakeTransaction(ClientTransaction clientTransaction){
    }
}
