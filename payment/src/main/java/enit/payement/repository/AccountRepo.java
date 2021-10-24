package enit.payement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import enit.payement.domain.entity.BankAccount;

public interface AccountRepo extends CrudRepository<BankAccount, Long> {
    List<BankAccount> findAll();

}
