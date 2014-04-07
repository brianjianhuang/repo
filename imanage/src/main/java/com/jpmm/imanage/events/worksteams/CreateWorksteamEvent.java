package com.jpmm.imanage.events.worksteams;

import com.jpmm.imanage.events.CreateEvent;

public class CreateWorksteamEvent extends CreateEvent {
	private WorkstreamDetail details;

	public CreateWorksteamEvent(WorkstreamDetail details) {
		this.details = details;
	}

	public WorkstreamDetail getDetails() {
		return details;
	}
}
