package com.jpmm.imanage.persistence.services;

import com.jpmm.imanage.events.worksteams.*;
import com.jpmm.imanage.events.worksteams.AllWorksteamsEvent;
import com.jpmm.imanage.events.worksteams.CreateWorksteamEvent;
import com.jpmm.imanage.events.worksteams.RequestAllWorksteamsEvent;
import com.jpmm.imanage.events.worksteams.WorkstreamCreatedEvent;
import com.jpmm.imanage.persistence.domain.Workstream;
import com.jpmm.imanage.persistence.repository.WorkstreamRepository;

import java.util.ArrayList;
import java.util.List;

public class WorkstreamPersistenceEventHandler implements
		WorkstreamPersistenceService {

	private WorkstreamRepository workstreamRepository;

	public WorkstreamPersistenceEventHandler(
			WorkstreamRepository workstreamRepository) {
		this.workstreamRepository = workstreamRepository;
	}

	@Override
	public AllWorksteamsEvent requestAllWorkstreams(
			RequestAllWorksteamsEvent requestAllWorksteamsEvent) {
		Iterable<Workstream> workstreams = workstreamRepository.findAll();

		List<WorkstreamDetail> details = new ArrayList<WorkstreamDetail>();

		for (Workstream item : workstreams) {
			WorkstreamDetail detail = item.toWorkstreamDetail();
			System.out.println ("MMMMM " + detail);
			details.add(detail);
		}
        
		return new AllWorksteamsEvent(details);
	}

	@Override
	public WorkstreamCreatedEvent createWorksteam(
			CreateWorksteamEvent createWorksteamEvent) {
		Workstream item = workstreamRepository.save(Workstream
				.fromWorkstreamDetail(createWorksteamEvent.getDetails()));

		return new WorkstreamCreatedEvent(item.getId(),
				item.toWorkstreamDetail());
	}
}
