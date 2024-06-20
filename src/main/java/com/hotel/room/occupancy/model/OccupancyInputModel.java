package com.hotel.room.occupancy.model;

import java.math.BigDecimal;
import java.util.List;

public record OccupancyInputModel(Integer freePremiumRooms, Integer freeEconomyRooms,
                                  List<BigDecimal> guestsRoomPrices) {

}
