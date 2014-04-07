package com.jpmm.imanage.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jpmm.imanage.core.services.WorkstreamService;
import com.jpmm.imanage.events.worksteams.AllWorksteamsEvent;
import com.jpmm.imanage.events.worksteams.RequestAllWorksteamsEvent;
import com.jpmm.imanage.events.worksteams.WorkstreamDetail;
import com.jpmm.imanage.web.domain.Workstream;

@Controller
public class WorkstreamController {

	private static final Logger LOG = LoggerFactory.getLogger(WorkstreamController.class);

	@Autowired
	private WorkstreamService workstreamService;

	@RequestMapping(value = "/workstreams", method = RequestMethod.GET)
	public String showWorkstreams(Model model) {

		LOG.debug("workstream view");

		model.addAttribute("workstreams",  getWorkstreams());
		LOG.debug("Show the basket contents");
		return "/imanagehome";
	}

	private List<Workstream> getWorkstreams() {
		List<Workstream> workstreams = new ArrayList<Workstream>();
		AllWorksteamsEvent allWorkstreamEvent = workstreamService.requestAllWorksteams(new RequestAllWorksteamsEvent());

		for (WorkstreamDetail workstreamDetail : allWorkstreamEvent.getWorksteamDetails()) {
			workstreams.add(Workstream.fromWorkstreamDetail(workstreamDetail));
		}
			
		LOG.info("XXXXXXXX" + workstreams.toString());
		return workstreams;
	}

}
