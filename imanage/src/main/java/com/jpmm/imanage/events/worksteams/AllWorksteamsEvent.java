package com.jpmm.imanage.events.worksteams;

import com.jpmm.imanage.events.ReadEvent;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AllWorksteamsEvent extends ReadEvent {

	private final List<WorkstreamDetail> worksteamDetails;

	public AllWorksteamsEvent(List<WorkstreamDetail> worksteamDetails) {
		this.worksteamDetails = Collections.unmodifiableList(worksteamDetails);
	}

	public Collection<WorkstreamDetail> getWorksteamDetails() {
		return this.worksteamDetails;
	}
}
