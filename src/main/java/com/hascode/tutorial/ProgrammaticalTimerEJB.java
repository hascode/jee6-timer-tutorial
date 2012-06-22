package com.hascode.tutorial;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Startup
@Singleton
public class ProgrammaticalTimerEJB {
	private final Logger log = Logger.getLogger(getClass().getName());

	@Resource
	private TimerService timerService;

	@PostConstruct
	public void createProgrammaticalTimer() {
		log.log(Level.INFO, "ProgrammaticalTimerEJB initialized");
		ScheduleExpression everyTenSeconds = new ScheduleExpression()
				.second("*/10").minute("*").hour("*");
		timerService.createCalendarTimer(everyTenSeconds, new TimerConfig(
				"passed message " + new Date(), true));
	}

	@Timeout
	public void handleTimer(final Timer timer) {
		log.info("timer received - contained message is: " + timer.getInfo());
	}
}