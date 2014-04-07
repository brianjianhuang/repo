package com.jpmm.imanage.events.worksteams;

import com.jpmm.imanage.events.CreatedEvent;

import java.util.UUID;

public class WorkstreamCreatedEvent extends CreatedEvent {

	private final UUID newWorksteamKey;
	private final WorkstreamDetail details;

	public WorkstreamCreatedEvent(final UUID newWorksteamKey,
			final WorkstreamDetail details) {
		this.newWorksteamKey = newWorksteamKey;
		this.details = details;
	}

	public WorkstreamDetail getDetails() {
		return details;
	}

	public UUID getNewOrderKey() {
		return newWorksteamKey;
	}
}
