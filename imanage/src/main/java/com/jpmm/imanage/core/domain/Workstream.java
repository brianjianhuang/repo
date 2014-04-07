package com.jpmm.imanage.core.domain;

import org.springframework.beans.BeanUtils;

import com.jpmm.imanage.events.worksteams.WorkstreamDetail;

public class Workstream {

	private String id;
	private String name;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkstreamDetail toWorksteamDetail() {
		WorkstreamDetail details = new WorkstreamDetail(id, name, description);

		return details;
	}

	public static Workstream fromWorksteamDetail(WorkstreamDetail worksteamDetail) {
		Workstream workstream = new Workstream();

		BeanUtils.copyProperties(worksteamDetail, workstream);

		return workstream;
	}

}
