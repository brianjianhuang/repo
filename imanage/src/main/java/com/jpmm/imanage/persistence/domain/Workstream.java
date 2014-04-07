package com.jpmm.imanage.persistence.domain;

import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.jpmm.imanage.events.worksteams.WorkstreamDetail;

public class Workstream {

	private UUID id;
	private String name;
	private String description;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WorkstreamDetail toWorkstreamDetail() {
		WorkstreamDetail detail = new WorkstreamDetail(id.toString(), name, description);

		

		return detail;
	}

	public static Workstream fromWorkstreamDetail(
			WorkstreamDetail workstreamDetail) {
		Workstream workstream = new Workstream();

		BeanUtils.copyProperties(workstreamDetail, workstream);

		return workstream;
	}
}
