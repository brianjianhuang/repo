package com.jpmm.imanage.persistence.repository;

import com.jpmm.imanage.persistence.domain.Workstream;

import java.util.UUID;

public interface WorkstreamRepository {

	Workstream save(Workstream order);

	void delete(UUID key);

	Workstream findById(UUID key);

	Iterable<Workstream> findAll();
}
