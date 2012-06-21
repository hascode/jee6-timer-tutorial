package com.hascode.tutorial;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class TimerExampleEJB {
	private final Logger log = Logger
			.getLogger(TimerExampleEJB.class.getName());

	@Schedule(minute = "*/1", hour = "*")
	public void runEveryMinute() {
		log.log(Level.INFO,
				"running every minute .. now it's: " + new Date().toString());
	}
}
