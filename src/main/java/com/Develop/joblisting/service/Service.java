package com.Develop.joblisting.service;

import com.Develop.joblisting.entity.Entity;

import java.util.List;


public interface Service {
    List<Entity> searchByText(String text);
}
