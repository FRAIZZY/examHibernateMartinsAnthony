/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.examHibernateMartinsAnthony.controllers;

import com.humanbooster.examHibernateMartinsAnthony.models.Car;
import com.humanbooster.examHibernateMartinsAnthony.services.CarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HB
 */
@RestController
@RequestMapping(path = "/")
public class DashboardController {
    
    @Autowired
    private CarService carService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView mv = new ModelAndView("dashboard");
        return mv;
    }
    
    @RequestMapping(value = "/requestListMarkCar", method = RequestMethod.GET)
    public ModelAndView requestListMarkCar() {
        ModelAndView mv = new ModelAndView("requestListMarkCar");
        List<Car> cars = carService.listMarkCar();
        mv.addObject("cars", cars);
        return mv;
    }
    
    @RequestMapping(value = "/requestCountCar", method = RequestMethod.GET)
    public ModelAndView requestCountCar() {
        ModelAndView mv = new ModelAndView("requestCountCar");
        Integer numCar = carService.countCar();
        mv.addObject("numCar", numCar);
        return mv;
    }
    
    @RequestMapping(value = "/requestTenLastCar", method = RequestMethod.GET)
    public ModelAndView requestTenLastCar() {
        ModelAndView mv = new ModelAndView("requestTenLastCar");
        List<Car> cars = carService.tenLastCar();
        mv.addObject("cars", cars);
        return mv;
    }
    
    @RequestMapping(value = "/requestListColor", method = RequestMethod.GET)
    public ModelAndView requestListColor() {
        ModelAndView mv = new ModelAndView("requestListColor");
        return mv;
    }
}
