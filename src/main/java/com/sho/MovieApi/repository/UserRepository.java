package com.sho.MovieApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.sho.MovieApi.model.User;


public interface UserRepository extends CrudRepository<User, Long>{
    User findByName(String name);
}
