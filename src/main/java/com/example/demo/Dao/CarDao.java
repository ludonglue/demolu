package com.example.demo.Dao;

import com.example.demo.Entity.Car;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by river on 2017/7/18.
 */
@Repository
public interface CarDao extends MongoRepository<Car,String>{
    List<Car> findByOwner(String owner);
    List<Car> findByOwnerLike(String owner);
    Page<Car> findAll(Pageable page);
    List<Car> findByLocationNear(Point location);
    List<Car> findByOwnerAndLocation(String owner,int[] location);
    List<Car> findByOwnerOrLocation(String owner,int[] location);
    List<Car> findAllByOrderByOwnerDesc();
}
