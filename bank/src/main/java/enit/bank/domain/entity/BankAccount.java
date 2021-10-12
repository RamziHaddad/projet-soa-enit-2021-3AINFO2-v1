package enit.bank.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="bank_account")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BankAccount {
    @Id
    private Long BnkAccDbId;
    private String AccountOwnerName;
    private String AccountPassword;
    private Long AccountCode;
    private Date AccountInitialDate;
    private Double AccountInitialBalance;

    @OneToMany(mappedBy="Accounts_transaction")
    private Set<AccountTransaction> accountTransactionSet;
}
