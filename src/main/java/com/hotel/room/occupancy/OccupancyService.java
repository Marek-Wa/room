package com.hotel.room.occupancy;

import com.hotel.room.occupancy.model.OccupancyInputModel;
import com.hotel.room.occupancy.model.OccupancyOutputModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OccupancyService {

    private static final BigDecimal PREMIUM_LIMIT = BigDecimal.valueOf(100);

    public OccupancyOutputModel getOccupancyResult(OccupancyInputModel occupancyInputModel){

        Integer freeEconomyRooms = occupancyInputModel.getFreeEconomyRooms();
        Integer freePremiumRooms = occupancyInputModel.getFreePremiumRooms();
        List<BigDecimal> guestsRoomPrices = occupancyInputModel.getGuestsRoomPrices();

        List<BigDecimal> premiumPrices = guestsRoomPrices.stream()
                .filter(p -> p.compareTo(PREMIUM_LIMIT) >= 0)
                .sorted(Comparator.reverseOrder())
                .toList();

        List<BigDecimal> economyPrices = guestsRoomPrices.stream()
                .filter(p -> p.compareTo(PREMIUM_LIMIT) < 0)
                .sorted(Comparator.reverseOrder())
                .toList();


        if ( economyPrices.size() <= freeEconomyRooms || premiumPrices.size() >= freePremiumRooms){

           Integer usedPremiumRooms = premiumPrices.size() > freePremiumRooms ? freePremiumRooms : premiumPrices.size();
           Integer usedEconomyRooms = economyPrices.size() > freeEconomyRooms ? freeEconomyRooms : economyPrices.size();

            BigDecimal premiumRoomsPrice = premiumPrices.stream()
                     .sorted(Comparator.reverseOrder())
                     .limit(usedPremiumRooms)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal economyRoomsPrice = economyPrices.stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(usedEconomyRooms)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            return new OccupancyOutputModel(usedPremiumRooms, usedEconomyRooms, premiumRoomsPrice, economyRoomsPrice);

        } else if (premiumPrices.size() < freePremiumRooms && economyPrices.size() > freeEconomyRooms) {

            Integer availablePremiumRooms =  freePremiumRooms - premiumPrices.size();
            Integer neededPremiumRooms =  economyPrices.size() - freeEconomyRooms;
            Integer additionalUsedPremiumRooms = availablePremiumRooms > neededPremiumRooms ? neededPremiumRooms : availablePremiumRooms;
            Integer usedPremiumRooms = premiumPrices.size() + additionalUsedPremiumRooms;
            Integer usedEconomyRooms = freeEconomyRooms;

            BigDecimal premiumRoomsPrice = premiumPrices.stream()
                    .sorted(Comparator.reverseOrder())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal additionalPremiumRoomsPrice = economyPrices.stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(additionalUsedPremiumRooms)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal totalPremiumRoomsPrice = premiumRoomsPrice.add(additionalPremiumRoomsPrice);

            BigDecimal economyRoomsPrice = economyPrices.stream()
                    .sorted(Comparator.reverseOrder())
                    .skip(additionalUsedPremiumRooms)
                    .limit(usedEconomyRooms)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            return new OccupancyOutputModel(usedPremiumRooms, usedEconomyRooms, totalPremiumRoomsPrice, economyRoomsPrice);

        }





       return new OccupancyOutputModel(3, 4, BigDecimal.TEN, BigDecimal.TWO);
    }


}
