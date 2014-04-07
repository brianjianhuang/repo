package com.jpmm.imanage.web.domain;

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

	public String toString() {
		return "workstream " + id + " " + name;
	}
	public static Workstream fromWorkstreamDetail(WorkstreamDetail workstreamDetail) {
		Workstream workstream = new Workstream();
		BeanUtils.copyProperties(workstreamDetail, workstream);
		return workstream;
	}
}
