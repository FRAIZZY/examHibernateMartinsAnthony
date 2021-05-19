/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.examHibernateMartinsAnthony.services;

import com.humanbooster.examHibernateMartinsAnthony.models.Car;
import com.humanbooster.examHibernateMartinsAnthony.repository.CarRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author HB
 */
@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    EntityManager entityManager;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Integer countCar() {
        List<Car> cars = carRepository.findAll();
        return cars.size();
    }

    public List<Car> getCars() {
        return this.carRepository.findAll();
    }

    @RequestMapping("/query")
    @ResponseBody
    public List<Car> listMarkCar() {
        Query query = entityManager.createQuery("SELECT marque, COUNT(*) as numCar FROM Car GROUP BY marque");
        List<Car> cars = query.getResultList();
        return cars;
    }
    
    @RequestMapping("/query")
    @ResponseBody
    public List<Car> tenLastCar() {
        Query query = entityManager.createQuery("FROM Car ORDER BY id DESC");
        query.setMaxResults(10);
        List<Car> cars = query.getResultList();
        return cars;
    }
}
