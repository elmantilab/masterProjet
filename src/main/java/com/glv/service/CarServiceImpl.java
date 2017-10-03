package com.glv.service;

import com.glv.service.CarService;
import com.glv.service.CarService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: xvitcoder Date: 12/20/12 Time: 11:14 PM
 */
@Service("carService")
public class CarServiceImpl implements CarService {

    private static List<String> carList = new ArrayList<String>();

    private static Long id = 0L;

    @Override
    public List<String> getAllCars() {
        return carList;
    }

    @Override
    public void addCar(String car) {

        carList.add(car);
    }

    @Override
    public void deleteAll() {
        carList.clear();
        id = 0L;
    }

    

    @Override
    public void deleteCar(String car) {
        carList.remove(car); //To change body of generated methods, choose Tools | Templates.
    }
}
