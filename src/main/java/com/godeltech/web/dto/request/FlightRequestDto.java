package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FlightRequestDto {
    @NotNull(message = "The departure airport is required")
    private Long departureAirportId;
    @NotNull(message = "The arrival airport is required")
    private Long arrivalAirportId;
    @NotNull(message = "The airplane is required")
    private Long planeId;
    @NotNull(message = "The captain is required")
    private Long captainId;
    @NotNull(message = "The second pilot is required")
    private Long secondPilotId;
    @NotNull(message = "The stewardess is required")
    private Long stewardessId;
    @NotNull(message = "The engineer is required")
    private Long engineerId;
    private Long flightProgressStatusId;
    private Long flightStartStatusId;
}
