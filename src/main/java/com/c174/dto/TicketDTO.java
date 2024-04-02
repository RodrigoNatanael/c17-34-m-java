package com.c174.dto;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
    private String id;
    private String eventName;
    private Boolean available;
}
