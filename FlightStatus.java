package com.mycompany.fligths;

/**
 * Enum representing the possible status of a flight.
 */
public enum FlightStatus {
    SCHEDULED("Scheduled"),
    DELAYED("Delayed"),
    INFLIGHT("InFlight"),
    CANCELED("Canceled");

    private final String displayName;

    FlightStatus(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
    @Override
    public String toString() {
        return displayName;
    }
}
