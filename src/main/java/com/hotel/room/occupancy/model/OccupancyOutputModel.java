package com.hotel.room.occupancy.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.math.BigDecimal;

//@JsonAutoDetect
public class OccupancyOutputModel {

    public OccupancyOutputModel(Integer usedPremiumRooms, Integer usedEconomyRooms, BigDecimal premiumRoomsPrice, BigDecimal economyRoomsPrice) {
        this.usedPremiumRooms = usedPremiumRooms;
        this.usedEconomyRooms = usedEconomyRooms;
        this.premiumRoomsPrice = premiumRoomsPrice;
        this.economyRoomsPrice = economyRoomsPrice;
    }

    private Integer usedPremiumRooms;

    private Integer usedEconomyRooms;

    private BigDecimal premiumRoomsPrice;

    private BigDecimal economyRoomsPrice;

    public Integer getUsedPremiumRooms() {
        return usedPremiumRooms;
    }

    public Integer getUsedEconomyRooms() {
        return usedEconomyRooms;
    }

    public BigDecimal getPremiumRoomsPrice() {
        return premiumRoomsPrice;
    }

    public BigDecimal getEconomyRoomsPrice() {
        return economyRoomsPrice;
    }
}
