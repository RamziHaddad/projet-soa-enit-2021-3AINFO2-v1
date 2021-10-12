package enit.bank.domain.inteface;

import enit.bank.domain.entity.BankAccount;
import org.springframework.data.repository.CrudRepository;


public interface AccountManager extends CrudRepository<BankAccount,Long> {
    public BankAccount CreateAccount(BankAccount bancAccount);
}

/*https://quarkus.io/guides/spring-data-jpa*/