package com.c174.models.market;

import com.c174.models.ticket.TicketResponse;
import com.c174.models.user.ProfileEntity;
import com.c174.models.user.ProfileRequest;
import com.c174.models.user.ProfileResponse;
import lombok.Data;

@Data
public class TransactionRequest {
        private ProfileResponse profileSeller;
        private TicketResponse ticket;
        private ProfileResponse profileBuyer;

        public TransactionRequest( TicketResponse ticket, ProfileResponse profileBuyer) {
            // ProfileSeller get from service
            this.ticket = ticket;
            this.profileBuyer = profileBuyer;
        }
}
