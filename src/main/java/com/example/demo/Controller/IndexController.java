package com.example.demo.Controller;

import com.example.demo.Entity.Car;
import com.example.demo.Service.ServiceImpl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.geo.Point;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by river on 2017/7/18.
 */
@Controller
public class IndexController {
    @Autowired
    CarServiceImpl carService;
    @RequestMapping("/")
    public ModelAndView index(){
        carService.deleteAll();
        carService.save(new Car(1,"ludonglue",new int[]{2,2}));
        carService.save(new Car(2,"zhangchi",new int[]{2,2}));
        carService.save(new Car(3,"fengjie",new int[]{2,3}));
        carService.save(new Car(4,"chenze",new int[]{5,2}));
        carService.save(new Car(5,"zhangrui",new int[]{2,1}));
        carService.save(new Car(6,"panjiangchao",new int[]{7,7}));
        carService.delete(new Car(6,"panjiangchao",new int[]{7,7}));

        List<Car> findAllresult,findByLikeResult,findByResult,findPage,findByNearResult;
        List<Car> findByAnd,findByOr,findOrderByDesc;
        //查询
        findAllresult = carService.findAll();
        findByLikeResult = carService.findByOwnerLike("zhang");
        findByResult = carService.findByOwner("zhangchi");
        //查询第1页（0开始）的内容，每页显示2条数据
        findPage = carService.findAll(new PageRequest(1,2)).getContent();
        //需要先建立索引
//        findByNearResult = carService.findByLocationNear(new Point(1,2));
        findByAnd = carService.findByOwnerAndLocation("zhangchi",new int[]{2,2});
        findByOr = carService.findByOwnerOrLocation("ludonglue",new int[]{2,2});
        findOrderByDesc = carService.findAllByOrderByOwnerDesc();

        //输出
        System.out.println("=============findAll==============");
        for (Car tmp:findAllresult) {
            System.out.println(tmp);
        }

        System.out.println("=============findPage==============");
        for (Car tmp2:findPage) {
            System.out.println(tmp2);
        }

        System.out.println("=============findByOwnerLike==============");
        for (Car tmp3:findByLikeResult) {
            System.out.println(tmp3);
        }

        System.out.println("=============findByOwner==============");
        for (Car tmp4:findByResult) {
            System.out.println(tmp4);
        }

//        System.out.println("=============findByLocationNear==============");
//        for (Car tmp5:findByNearResult) {
//            System.out.println(tmp5);
//        }

        System.out.println("=============findByOwnerAndLocation==============");
        for (Car tmp6:findByAnd) {
            System.out.println(tmp6);
        }

        System.out.println("=============findByOwnerOrLocation==============");
        for (Car tmp7:findByOr) {
            System.out.println(tmp7);
        }


        System.out.println("=============findAllByOrderByOwnerDesc==============");
        for (Car tmp8:findOrderByDesc) {
            System.out.println(tmp8);
        }




        return new ModelAndView("index");
    }
}
