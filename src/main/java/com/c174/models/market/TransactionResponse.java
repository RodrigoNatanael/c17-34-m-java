package com.c174.models.market;

import com.c174.models.ticket.TicketResponse;
import com.c174.models.user.ProfileResponse;
import lombok.Data;

@Data
public class TransactionResponse {
    private Long id;
    private ProfileResponse profileSeller;
    private TicketResponse ticket;
    private ProfileResponse profileBuyer;

    public TransactionResponse(Long id, ProfileResponse profileSeller, TicketResponse ticket, ProfileResponse profileBuyer) {
        this.id = id;
        this.profileSeller = profileSeller;
        this.ticket = ticket;
        this.profileBuyer = profileBuyer;
    }
}
