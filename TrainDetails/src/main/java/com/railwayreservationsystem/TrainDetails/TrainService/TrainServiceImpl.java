package com.railwayreservationsystem.TrainDetails.TrainService;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railwayreservationsystem.TrainDetails.TrainException.TrainNotFoundException;
import com.railwayreservationsystem.TrainDetails.TrainModel.Train;
import com.railwayreservationsystem.TrainDetails.TrainModel.TrainInfo;
import com.railwayreservationsystem.TrainDetails.TrainModel.TrainStation;
import com.railwayreservationsystem.TrainDetails.TrainRepository.TrainRepository;
import com.railwayreservationsystem.TrainDetails.TrainRepository.TrainStationRepository;


@Service
public class TrainServiceImpl implements TrainService{
	
	@Autowired
	private TrainRepository trainRepo;
	
	@Autowired
	private TrainStationRepository stationRepo;

	@Override
	public TrainInfo addTrain(TrainInfo trainInfo) {
		return trainRepo.save(trainInfo);
	}
	
	
	@Override
	public TrainInfo getTrain(int trainNo) {
		return trainRepo.findById(trainNo).orElseThrow(()-> new TrainNotFoundException("Train not found " , "Train number " , trainNo) );
	}
	
	
	@Override
	public TrainInfo updateTrain(int trainNo, TrainInfo trainInfo) {
		trainRepo.findById(trainNo).orElseThrow(()-> new TrainNotFoundException("Train not found " , "Train number " , trainNo) );
		return trainRepo.save(trainInfo);
	}



	@SuppressWarnings("deprecation")
	@Override
	public List<Train> searchTrain(String from, String to, Date date) {
		List<TrainStation> stationList = stationRepo.findByTrainFromAndTrainTo(from, to);
		
		List<Train> searchedTrains = new ArrayList<>();
		
		for(TrainStation station : stationList) {
			int trainNo = station.getTrainNo();
			
			TrainInfo trainInfo = trainRepo.findByTrainNo(trainNo);
			
			Date trainDate = trainInfo.getTrainDate();
			trainDate.setHours(0);
			trainDate.setMinutes(0);
			
			if(trainDate.equals(date)) {
				
				Train train = new Train();
				
				int stationFare = station.getJourneyFare();
				int journeyFareAC = stationFare + trainInfo.getFareAC();
				int journeyFareSL = stationFare + trainInfo.getFareSL();
				
				train.settrainNo(trainNo);
				train.settrainName(trainInfo.getTrainName());
				train.settrainStart(trainInfo.getTrainStart());
				train.settEnd(trainInfo.getTrainEnd());
				train.setAvailableAC(trainInfo.getSeatsAC());
				train.setAvailableSL(trainInfo.getSeatsSL());
				train.setFareAC(journeyFareAC);
				train.setFareSL(journeyFareSL);
				train.setStations(trainInfo.getStations());
				train.setDepartureTime(station.getDepartureTime());
				train.setArrivalTime(station.getArrivalTime());
				
				searchedTrains.add(train);
			}
		}
		
		return searchedTrains;
	}


	
	
	
	@Override
	public TrainStation addStation(TrainStation station) {
		return stationRepo.save(station);
	}




}
