package com.datastax.workshop.exceptions;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionsRepositoryCassandra extends CassandraRepository<ExceptionsEntity, String> {

}




