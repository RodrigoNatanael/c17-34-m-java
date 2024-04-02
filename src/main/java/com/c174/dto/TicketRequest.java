package com.c174.dto;

import jakarta.validation.constraints.NotNull;

public record TicketRequest(@NotNull String event,
                            Boolean isPresent,
                            Boolean isLock,
                            Long id) {
}
