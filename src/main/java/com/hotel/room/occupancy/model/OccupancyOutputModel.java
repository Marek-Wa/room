package com.hotel.room.occupancy.model;

import java.math.BigDecimal;


public record OccupancyOutputModel(Integer usedPremiumRooms, Integer usedEconomyRooms, BigDecimal premiumRoomsPrice,
                                   BigDecimal economyRoomsPrice) {

}
