package com.railwayreservationsystem.TrainDetails.TrainController;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.railwayreservationsystem.TrainDetails.TrainModel.Train;
import com.railwayreservationsystem.TrainDetails.TrainModel.TrainInfo;
import com.railwayreservationsystem.TrainDetails.TrainModel.TrainStation;
import com.railwayreservationsystem.TrainDetails.TrainService.TrainService;

@RestController	
@RequestMapping("/train")
public class TrainController {
	
	Logger logger = LoggerFactory.getLogger(TrainController.class);
		
	@Autowired
	private TrainService trainService;
	

//  Add New Train Details 	
	@PostMapping("/addtrain")
	public ResponseEntity<TrainInfo> addTrain(@RequestBody TrainInfo trainInfo){
		TrainInfo info = trainService.addTrain(trainInfo);
		
		logger.info("New Train Details Added");
		
		return new ResponseEntity<TrainInfo>(info,HttpStatus.OK);
	}
	
	
//  Get Train by TrainNumber
	@GetMapping("/find/{trainNo}")
	public ResponseEntity<TrainInfo> getTrain(@PathVariable int trainNo){
		TrainInfo info = trainService.getTrain(trainNo);
		
		logger.info("getTrain method called");
		
		return new ResponseEntity<TrainInfo>(info,HttpStatus.OK);
	}
	

//  Update Existing Train Details
	@PutMapping("/updatetrain/{trainNo}")
	public ResponseEntity<TrainInfo> updateTrain(@PathVariable int trainNo,@RequestBody TrainInfo trainInfo){
		TrainInfo info = trainService.updateTrain(trainNo, trainInfo);
		
		logger.info("updateTrain Method called");
		
		return new ResponseEntity<TrainInfo>(info,HttpStatus.OK);
	}
	
	
//  Search Trains for Source to Destination
	@GetMapping("/search/{from}/{to}/{date}")
	public List<Train> searchTrain(@PathVariable String from, @PathVariable String to,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
		return trainService.searchTrain(from,to,date);
	}
	
	
//  Add new Station Details
	@PostMapping("/addstation")
	public ResponseEntity<TrainStation> addStation(@RequestBody TrainStation station){
		TrainStation trainsStation = trainService.addStation(station);
		
		logger.info("New Train Stations Added");
		
		return new ResponseEntity<TrainStation>(trainsStation,HttpStatus.OK);
	}
}