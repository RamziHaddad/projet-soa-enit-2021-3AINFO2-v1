package enit.bank.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "TDbId")
    private List<AccountTransaction> accountTransactionSet;
}
