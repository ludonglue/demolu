package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.CarDao;
import com.example.demo.Entity.Car;
import com.example.demo.Service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by river on 2017/7/18.
 */
@Service("carService")
public class CarServiceImpl implements ICarService {
    @Autowired
    private CarDao carDao;
    @Override
    public void save(Car car) {
        carDao.save(car);
    }

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public void delete(Car car) {
        carDao.delete(car);
    }

    @Override
    public void deleteAll() {
        carDao.deleteAll();
    }

    @Override
    public List<Car> findByOwner(String owner) {
        return carDao.findByOwner(owner);
    }

    @Override
    public List<Car> findByOwnerLike(String owner) {
        return carDao.findByOwnerLike(owner);
    }

    @Override
    public Page<Car> findAll(Pageable page) {
        return carDao.findAll(page);
    }

    @Override
    public List<Car> findByLocationNear(Point location) {
        return carDao.findByLocationNear(location);
    }

    @Override
    public List<Car> findByOwnerAndLocation(String owner, int[] location) {
        return carDao.findByOwnerAndLocation(owner,location);
    }

    @Override
    public List<Car> findByOwnerOrLocation(String owner, int[] location) {
        return carDao.findByOwnerOrLocation(owner,location);
    }

    @Override
    public List<Car> findAllByOrderByOwnerDesc() {
        return carDao.findAllByOrderByOwnerDesc();
    }


}
