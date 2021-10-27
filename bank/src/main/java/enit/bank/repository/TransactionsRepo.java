package enit.bank.repository;

import enit.bank.domain.entity.AccountTransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionsRepo  extends CrudRepository<AccountTransaction, Long> {
    List<AccountTransaction> findAllByAccount_AccountCode(Long accountCode);
}
