package enit.bank.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="accounts_transaction")
@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
@ToString
public class AccountTransaction {
    @Id
    private Integer TDbId;
    private Long TransactionAccountCode;
    private Date TransactionDate;
    private Long TransactionAmount;
    @ManyToOne
    @JoinColumn(name="bank_account", nullable=false)
    private BankAccount account;
}
