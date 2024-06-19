package com.hotel.room.occupancy.model;

import java.math.BigDecimal;
import java.util.List;

public class OccupancyInputModel {

    public OccupancyInputModel(Integer freePremiumRooms, Integer freeEconomyRooms, List<BigDecimal> roomPrices) {
        this.freePremiumRooms = freePremiumRooms;
        this.freeEconomyRooms = freeEconomyRooms;
        this.roomPrices = roomPrices;
    }

    private Integer freePremiumRooms;

    private Integer freeEconomyRooms;

    private List<BigDecimal> roomPrices;

}
