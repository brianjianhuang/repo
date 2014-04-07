package com.jpmm.imanage.events.worksteams;

public class WorkstreamDetail {

	private String id;
	private String name;
	private String description;
	
	public WorkstreamDetail() {}

	public WorkstreamDetail(String id, String name, String desc) {
		this.id = id;
		this.name = name;
		this.description = desc;
	}

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
    
	public String toString() {
		return "WorkstreamDetails " + id;
	}
}
