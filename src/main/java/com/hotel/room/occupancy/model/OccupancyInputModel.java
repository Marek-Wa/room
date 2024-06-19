package com.hotel.room.occupancy.model;

import java.math.BigDecimal;
import java.util.List;

public class OccupancyInputModel {

    public OccupancyInputModel(Integer freePremiumRooms, Integer freeEconomyRooms, List<BigDecimal> guestsRoomPrices) {
        this.freePremiumRooms = freePremiumRooms;
        this.freeEconomyRooms = freeEconomyRooms;
        this.guestsRoomPrices = guestsRoomPrices;
    }

    private Integer freePremiumRooms;

    private Integer freeEconomyRooms;

    private List<BigDecimal> guestsRoomPrices;

    public Integer getFreePremiumRooms() {
        return freePremiumRooms;
    }

    public Integer getFreeEconomyRooms() {
        return freeEconomyRooms;
    }

    public List<BigDecimal> getGuestsRoomPrices() {
        return guestsRoomPrices;
    }
}
