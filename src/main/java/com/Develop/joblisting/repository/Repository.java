package com.Develop.joblisting.repository;

import com.Develop.joblisting.entity.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Entity,String> {
}
