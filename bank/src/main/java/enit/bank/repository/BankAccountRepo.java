package enit.bank.repository;

import enit.bank.domain.entity.BankAccount;
import org.springframework.data.repository.CrudRepository;


public interface BankAccountRepo extends CrudRepository<BankAccount, Long> {
}