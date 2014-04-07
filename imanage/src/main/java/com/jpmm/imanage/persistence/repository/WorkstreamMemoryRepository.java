package com.jpmm.imanage.persistence.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.jpmm.imanage.persistence.domain.Workstream;

public class WorkstreamMemoryRepository implements WorkstreamRepository {

	private Map<UUID, Workstream> workstreams = new HashMap<UUID, Workstream>();

	public WorkstreamMemoryRepository() {
		Workstream w1 = new Workstream();
		w1.setId(UUID.randomUUID());
		w1.setName("wk1");
		w1.setDescription("workstream 1");

		Workstream w2 = new Workstream();
		w2.setId(UUID.randomUUID());
		w2.setName("wk1");
		w2.setDescription("workstream 1");

		workstreams.put(w1.getId(), w1);

		workstreams.put(w2.getId(), w2);
	}

	@Override
	public Workstream save(Workstream workstream) {
		workstreams.put(workstream.getId(), workstream);
		return workstream;
	}

	@Override
	public void delete(UUID key) {
		workstreams.remove(key);
	}

	@Override
	public Workstream findById(UUID key) {
		for (Workstream item : workstreams.values()) {
			if (item.getId().equals(key)) {
				return item;
			}
		}
		return null;
	}

	@Override
	public List<Workstream> findAll() {
		return new ArrayList<Workstream>(workstreams.values());
	}
}
