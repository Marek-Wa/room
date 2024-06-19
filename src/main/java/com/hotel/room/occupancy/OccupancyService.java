package com.hotel.room.occupancy;

import com.hotel.room.occupancy.model.OccupancyInputModel;
import com.hotel.room.occupancy.model.OccupancyOutputModel;
import org.springframework.stereotype.Service;

@Service
public class OccupancyService {

    public OccupancyOutputModel getOccupancyResult(OccupancyInputModel occupancyInputModel){


       return new OccupancyOutputModel();
    }


}
