package com.jpmm.imanage.core.services;

import com.jpmm.imanage.events.worksteams.*;


public interface WorkstreamService {

	public AllWorksteamsEvent requestAllWorksteams(
			RequestAllWorksteamsEvent requestAllWorksteamsEvent);

	public WorkstreamCreatedEvent createWorksteam(CreateWorksteamEvent event);

}
