package com.railwayreservationsystem.TrainDetails.TrainModel;

import java.util.List;

public class Train {
	private Integer trainNo;
	private String trainName;
	private String trainStart;
	private String tEnd;
	
	private int fareSL;
	private int fareAC;
	
	private int availableAC;
	private int availableSL;
	
	private String departureTime;
	private String arrivalTime;
	List<String> stations;
	
	
	public Integer gettrainNo() {
		return trainNo;
	}
	public void settrainNo(Integer trainNo) {
		this.trainNo = trainNo;
	}
	public String gettrainName() {
		return trainName;
	}
	public void settrainName(String trainName) {
		this.trainName = trainName;
	}
	public String gettrainStart() {
		return trainStart;
	}
	public void settrainStart(String trainStart) {
		this.trainStart = trainStart;
	}
	public String gettEnd() {
		return tEnd;
	}
	public void settEnd(String tEnd) {
		this.tEnd = tEnd;
	}
	public int getFareSL() {
		return fareSL;
	}
	public void setFareSL(int fareSL) {
		this.fareSL = fareSL;
	}
	public int getFareAC() {
		return fareAC;
	}
	public void setFareAC(int fareAC) {
		this.fareAC = fareAC;
	}
	public int getAvailableAC() {
		return availableAC;
	}
	public void setAvailableAC(int availableAC) {
		this.availableAC = availableAC;
	}
	public int getAvailableSL() {
		return availableSL;
	}
	public void setAvailableSL(int availableSL) {
		this.availableSL = availableSL;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public List<String> getStations() {
		return stations;
	}
	public void setStations(List<String> stations) {
		this.stations = stations;
	}
	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Train(Integer tNo, String trainName, String tStart, String tEnd, int fareSL, int fareAC, int availableAC,
			int availableSL, String departureTime, String arrivalTime, List<String> stations) {
		super();
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.trainStart = trainStart;
		this.tEnd = tEnd;
		this.fareSL = fareSL;
		this.fareAC = fareAC;
		this.availableAC = availableAC;
		this.availableSL = availableSL;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.stations = stations;
	}
	@Override
	public String toString() {
		return "train [trainNo=" + trainNo + ", trainName=" + trainName + ", tStart=" + trainStart + ", tEnd=" + tEnd + ", fareSL=" + fareSL
				+ ", fareAC=" + fareAC + ", availableAC=" + availableAC + ", availableSL=" + availableSL
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", stations=" + stations + "]";
	}
	
	
	

}
