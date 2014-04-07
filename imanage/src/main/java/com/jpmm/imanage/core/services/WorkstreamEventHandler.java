package com.jpmm.imanage.core.services;

import com.jpmm.imanage.events.worksteams.AllWorksteamsEvent;
import com.jpmm.imanage.events.worksteams.CreateWorksteamEvent;
import com.jpmm.imanage.events.worksteams.RequestAllWorksteamsEvent;
import com.jpmm.imanage.events.worksteams.WorkstreamCreatedEvent;
import com.jpmm.imanage.persistence.services.WorkstreamPersistenceService;

;

public class WorkstreamEventHandler implements WorkstreamService {

	private final WorkstreamPersistenceService workstreamsPersistenceService;

	public WorkstreamEventHandler(final WorkstreamPersistenceService worksteamsPersistenceService) {
		this.workstreamsPersistenceService = worksteamsPersistenceService;
	}

	@Override
	public WorkstreamCreatedEvent createWorksteam(CreateWorksteamEvent createWorksteamEvent) {

		// atomic
		WorkstreamCreatedEvent event = workstreamsPersistenceService.createWorksteam(createWorksteamEvent);

		// TODO, where should this go?

		return event;
	}

	@Override
	public AllWorksteamsEvent requestAllWorksteams(RequestAllWorksteamsEvent requestAllWorksteamsEvent) {

		return workstreamsPersistenceService.requestAllWorkstreams(requestAllWorksteamsEvent);

	}

}
