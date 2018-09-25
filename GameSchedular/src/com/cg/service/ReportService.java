package com.cg.service;

import com.cg.beans.DayReport;
import com.cg.beans.GameReport;
import com.cg.beans.PlayerReport;

public interface ReportService {

	public GameReport gameWiseReport(String gameName);
	
	public PlayerReport playerWiseReport(String playerName);
	
	public DayReport dayWiseReport(String dayName); 
}
