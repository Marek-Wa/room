package com.hotel.room.occupancy;

import com.hotel.room.occupancy.model.OccupancyInputModel;
import com.hotel.room.occupancy.model.OccupancyOutputModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class OccupancyServiceTest {

    // [23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209]
    List<BigDecimal> GUESTS_ROOM_PRICES = List.of(BigDecimal.valueOf(23),
            BigDecimal.valueOf(45),
            BigDecimal.valueOf(155),
            BigDecimal.valueOf(374),
            BigDecimal.valueOf(22),
            BigDecimal.valueOf(99.99),
            BigDecimal.valueOf(100),
            BigDecimal.valueOf(101),
            BigDecimal.valueOf(115),
            BigDecimal.valueOf(209)
            );

    @Autowired
    OccupancyService occupancyService;


    @Test
    public void test1(){
        OccupancyInputModel occupancyInputModel = new OccupancyInputModel(3, 3, GUESTS_ROOM_PRICES);
        OccupancyOutputModel occupancyOutputModel = occupancyService.calculateOccupancy(occupancyInputModel);
        assertEquals(3, occupancyOutputModel.usedPremiumRooms());
        assertEquals(3, occupancyOutputModel.usedEconomyRooms());
        assertEquals(BigDecimal.valueOf(738), occupancyOutputModel.premiumRoomsPrice());
        assertEquals(BigDecimal.valueOf(167.99), occupancyOutputModel.economyRoomsPrice());
    }

    @Test
    public void test2(){
        OccupancyInputModel occupancyInputModel = new OccupancyInputModel(7, 5, GUESTS_ROOM_PRICES);
        OccupancyOutputModel occupancyOutputModel = occupancyService.calculateOccupancy(occupancyInputModel);
        assertEquals(6, occupancyOutputModel.usedPremiumRooms());
        assertEquals(4, occupancyOutputModel.usedEconomyRooms());
        assertEquals(BigDecimal.valueOf(1054), occupancyOutputModel.premiumRoomsPrice());
        assertEquals(BigDecimal.valueOf(189.99), occupancyOutputModel.economyRoomsPrice());
    }

    @Test
    public void test3(){
        OccupancyInputModel occupancyInputModel = new OccupancyInputModel(2, 7, GUESTS_ROOM_PRICES);
        OccupancyOutputModel occupancyOutputModel = occupancyService.calculateOccupancy(occupancyInputModel);
        assertEquals(2, occupancyOutputModel.usedPremiumRooms());
        assertEquals(4, occupancyOutputModel.usedEconomyRooms());
        assertEquals(BigDecimal.valueOf(583), occupancyOutputModel.premiumRoomsPrice());
        assertEquals(BigDecimal.valueOf(189.99), occupancyOutputModel.economyRoomsPrice());
    }

    @Test
    public void test4(){
        OccupancyInputModel occupancyInputModel = new OccupancyInputModel(7, 1, GUESTS_ROOM_PRICES);
        OccupancyOutputModel occupancyOutputModel = occupancyService.calculateOccupancy(occupancyInputModel);
        assertEquals(7, occupancyOutputModel.usedPremiumRooms());
        assertEquals(1, occupancyOutputModel.usedEconomyRooms());
        //assertEquals(BigDecimal.valueOf(1153), occupancyOutputModel.getPremiumRoomsPrice()); //?
        assertEquals(BigDecimal.valueOf(1153.99), occupancyOutputModel.premiumRoomsPrice());
        //assertEquals(BigDecimal.valueOf(45.99), occupancyOutputModel.getEconomyRoomsPrice()); // ?
        assertEquals(BigDecimal.valueOf(45), occupancyOutputModel.economyRoomsPrice()); // ?
    }
}
