package com.lazerycode.selenium.page_objects.booking.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    private int id;
    private String bookingNumber;
    private String timestamp;
    private String vehicleId;
    private String moocId;
    private String transferId;
    private String companyName;
    private String inOut;
    private String status;
    private String paymentStatus;

}
