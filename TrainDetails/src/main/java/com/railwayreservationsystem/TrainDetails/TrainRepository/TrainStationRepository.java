package com.railwayreservationsystem.TrainDetails.TrainRepository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.railwayreservationsystem.TrainDetails.TrainModel.TrainStation;

public interface TrainStationRepository extends MongoRepository<TrainStation, Integer> {
	
	List<TrainStation> findByTrainFromAndTrainTo(String trainFrom,String trainTo);
}
