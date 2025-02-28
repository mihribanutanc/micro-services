package com.reversetech.ticketservice.repository.es;

import com.reversetech.ticketservice.model.es.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.UUID;

public interface TicketElasticSearchRepository extends ElasticsearchRepository<TicketModel, UUID> {
}
