package com.c174.models.databank;

import com.c174.models.embed.Audit;
import lombok.Data;

@Data
public class DataBankResponse {
    private Long id;
    private String entityBank;
    private String accountNumber;
    private String accountType;
    private Audit audit;

    public DataBankResponse(DataBankEntity dataBankEntity) {
        this.id = dataBankEntity.getId();
        this.entityBank = dataBankEntity.getEntityBank();
        this.accountNumber = dataBankEntity.getAccountNumber();
        this.accountType = dataBankEntity.getAccountType();
        this.audit = dataBankEntity.getAudit();
    }
}
