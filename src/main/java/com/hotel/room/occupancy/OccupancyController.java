package com.hotel.room.occupancy;

import com.hotel.room.occupancy.model.OccupancyInputModel;
import com.hotel.room.occupancy.model.OccupancyOutputModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/occupancy")
public class OccupancyController {

    public OccupancyController(OccupancyService occupancyService) {
        this.occupancyService = occupancyService;
    }

    private final OccupancyService occupancyService;


    @PostMapping(path = "/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public OccupancyOutputModel calculateOccupancy(@RequestBody OccupancyInputModel occupancyInputModel) {
        return occupancyService.getOccupancyResult(occupancyInputModel);
    }

}
