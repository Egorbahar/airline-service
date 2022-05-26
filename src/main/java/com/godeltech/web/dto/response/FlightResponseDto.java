package com.godeltech.web.dto.response;

import lombok.Data;

@Data
public class FlightResponseDto {
    private final Long id;
    private final String departureAirportCode;
    private final String arrivalAirportCode;
    private final Long departureAirportId;
    private final Long arrivalAirportId;
    private final Long planeId;
    private final Long captainId;
    private final Long secondPilotId;
    private final Long stewardessId;
    private final Long engineerId;
    private final Long flightProgressStatusId;
    private final Long flightStartStatusId;
    private final String planeName;
    private final String captainName;
    private final String secondPilotName;
    private final String stewardessName;
    private final String engineerName;
    private final String flightProgressStatusName;
    private final String flightStartStatusName;
}
