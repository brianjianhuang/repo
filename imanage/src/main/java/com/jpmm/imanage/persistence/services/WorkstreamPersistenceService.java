package com.jpmm.imanage.persistence.services;

import com.jpmm.imanage.events.worksteams.*;

public interface WorkstreamPersistenceService {

  AllWorksteamsEvent requestAllWorkstreams(RequestAllWorksteamsEvent requestAllWorksteamsEvent);
  
  WorkstreamCreatedEvent createWorksteam(CreateWorksteamEvent createWorksteamEvent);

}
