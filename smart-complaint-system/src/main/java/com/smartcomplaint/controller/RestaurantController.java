package com.smartcomplaint.controller;

import com.smartcomplaint.entity.Restaurant;

import com.smartcomplaint.service.RestaurantMonitoringService;
import com.smartcomplaint.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService service;
    private final RestaurantMonitoringService monitoringService;
    

    public RestaurantController(RestaurantService service, RestaurantMonitoringService monitoringService) {
        this.service = service;
        this.monitoringService = monitoringService;
        
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Restaurant restaurant) {
        
        Restaurant salvo = service.save(restaurant);
        
        
        
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public List<Restaurant> getAll() {
        return service.findAll();
    }
    @GetMapping("/problematic")
    public List<Restaurant> getProblematic( 
    @RequestParam(value = "rating",  defaultValue = "3.0") Double rating,
    @RequestParam(value = "minReviews", defaultValue = "5") Integer minReviews){
    
    	return service.findProblematicRestaurants(rating,minReviews);
    }
    @GetMapping("/{id}")
    public Restaurant getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Restaurant update(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        return service.update(id, restaurant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    @GetMapping("/alerts")
	public List<Restaurant> getAlerts(){
    	return service.findAlerts();
    }
    @GetMapping("/critical")
    public List<Restaurant> getCritical(){
    	return service.findByStatus("CRITICO");
    }
    @GetMapping("/ranking")
    public List<Restaurant> getRanking(){
    	return service.getRanking();
}
    @GetMapping("/status")
    public List<Restaurant> getStatus(@RequestParam String status){
    	return service.findByStatus(status);
    }
}
