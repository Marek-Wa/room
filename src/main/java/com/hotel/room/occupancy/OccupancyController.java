package com.hotel.room.occupancy;

import com.hotel.room.occupancy.model.OccupancyInputModel;
import com.hotel.room.occupancy.model.OccupancyOutputModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/occupancy")
public class OccupancyController {

    public OccupancyController(OccupancyService occupancyService){
        this.occupancyService = occupancyService;
    }

    private OccupancyService occupancyService;

    @GetMapping("/tmp")
    public String getTmpData(){
      return "111";
    }

    @PostMapping(path = "/calculate", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public OccupancyOutputModel calculateOccupancy(OccupancyInputModel occupancyInputModel){
        BigDecimal room1 = BigDecimal.valueOf(23);
        BigDecimal room2 = BigDecimal.valueOf(45);
        BigDecimal room3 = BigDecimal.valueOf(155);
        List<BigDecimal> roomPrices = List.of(room1, room2, room3);
        OccupancyInputModel occupancyInputModel1 = new OccupancyInputModel(5, 6, roomPrices);
        return occupancyService.getOccupancyResult(occupancyInputModel1);

    }

}
