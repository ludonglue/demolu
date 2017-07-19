package com.example.demo.Service;

import com.example.demo.Entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Point;


import java.util.List;

/**
 * Created by river on 2017/7/18.
 */
public interface ICarService {
    //增
    public void save(Car car);
    //查
    public List<Car> findAll();
    //删
    public void delete(Car car);
    public void deleteAll();

    public List<Car> findByOwner(String owner);
    public List<Car> findByOwnerLike(String owner);
    //分页
    public Page<Car> findAll(Pageable page);
    List<Car> findByLocationNear(Point location);

    //And条件查询
    List<Car> findByOwnerAndLocation(String owner,int[] location);
    //Or条件查询
    List<Car> findByOwnerOrLocation(String owner,int[] location);
    //降序排列
    List<Car> findAllByOrderByOwnerDesc();
}
