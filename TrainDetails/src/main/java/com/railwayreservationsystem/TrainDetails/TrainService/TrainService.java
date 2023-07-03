package com.railwayreservationsystem.TrainDetails.TrainService;

import java.util.Date;
import java.util.List;

import com.railwayreservationsystem.TrainDetails.TrainModel.Train;
import com.railwayreservationsystem.TrainDetails.TrainModel.TrainInfo;
import com.railwayreservationsystem.TrainDetails.TrainModel.TrainStation;

public interface TrainService {
	TrainInfo addTrain(TrainInfo trainInfo);
	TrainInfo getTrain(int trainNo);
	TrainInfo updateTrain(int detailId,TrainInfo trainInfo);
	List<Train> searchTrain(String from,String to,Date date);
	
	TrainStation addStation(TrainStation station);
}

//author:
//	modified by:
//		modified time:
//			description: