package com.DeliveryBoy.dto;

public class LocationDTO {
    private String coordinates;

    public LocationDTO() {
    }

    public LocationDTO(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}
