package dev.Sameer.BookMyShow.Entity;

import dev.Sameer.BookMyShow.Enum.PaymentMode;
import dev.Sameer.BookMyShow.Enum.PaymentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class Payment extends BaseModel {
    private LocalDateTime paymentTime;
    private double amount;
    @ManyToOne
    private Ticket ticket;
    private int referenceId;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}

/*
    Payment         Ticket
    1                   1
    M                   1
 */
