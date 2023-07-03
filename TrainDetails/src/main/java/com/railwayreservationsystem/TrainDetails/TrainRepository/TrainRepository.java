package com.railwayreservationsystem.TrainDetails.TrainRepository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.railwayreservationsystem.TrainDetails.TrainModel.TrainInfo;
@Repository
public interface TrainRepository extends MongoRepository<TrainInfo, Integer> {
	TrainInfo findByTrainNo(int trainNo);
}

