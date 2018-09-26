package com.cg.service;

import com.cg.beans.Day;
import com.cg.exception.DuplicateElementException;

public interface DayService {

	public Day add(Day day) throws DuplicateElementException;
}
