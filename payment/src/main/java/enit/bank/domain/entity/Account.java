package enit.bank.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Bank_account")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Account {
    @Id
    private Integer Aid;
    private String Fullname;
    private String password;
    private Long AccountCode;
    private Date initialDate;
    private Double initialBalance;

    @OneToMany(mappedBy="Accounts_transaction")
    private Set<AccountTransaction> accountTransactionSet;
}
