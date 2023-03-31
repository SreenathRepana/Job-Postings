package com.Develop.joblisting.service;


import com.Develop.joblisting.entity.Entity;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ServiceImpl implements Service{

    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;

    @Override
    public List<Entity> searchByText(String text) {
        final List<Entity> posts=new ArrayList<>();
        MongoDatabase database = client.getDatabase("JobListing");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                        new Document("query", text)
                                .append("path", Arrays.asList("techs", "desc", "profile"))))));

        result.forEach(doc->posts.add(converter.read(Entity.class,doc)));
        return posts;
    }
}
