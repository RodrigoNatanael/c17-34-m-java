package com.c174.models.databank;

import com.c174.models.embed.Audit;
import com.c174.models.profile.ProfileEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="DataBank")
@Data
public class DataBankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entityBank;
    private String accountNumber;
    private String accountType;

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name="profile_id",
            nullable = true
    )
    private ProfileEntity profile;
    @Embedded
    private Audit audit = new Audit();

}
