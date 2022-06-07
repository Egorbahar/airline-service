package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FlightRequestDto {
    @NotNull(message = "{flight.depAirport.notNull}")
    private Long departureAirportId;
    @NotNull(message = "{flight.arrivalAirport.notNull}")
    private Long arrivalAirportId;
    @NotNull(message = "{flight.airplane.notNull}")
    private Long planeId;
    @NotNull(message = "{flight.captain.notNull}")
    private Long captainId;
    @NotNull(message = "{flight.pilot.notNull}")
    private Long secondPilotId;
    @NotNull(message = "{flight.stewardess.notNull}")
    private Long stewardessId;
    @NotNull(message = "{flight.engineer.notNull}")
    private Long engineerId;
    @NotNull(message = "{flight.progress.notNull}")
    private Long flightProgressStatusId;
    @NotNull(message = "{flight.start.notNull}")
    private Long flightStartStatusId;
}
