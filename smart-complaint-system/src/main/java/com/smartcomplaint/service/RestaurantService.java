package com.smartcomplaint.service;

import com.smartcomplaint.entity.Restaurant;
import com.smartcomplaint.repository.RestaurantRepository;
import com.smartcomplaint.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository repository;
    private final RestaurantMonitoringService monitoringService;

    public RestaurantService(RestaurantRepository repository,
                             RestaurantMonitoringService monitoringService) {
        this.repository = repository;
        this.monitoringService = monitoringService;
    }

    // ================= SAVE =================
    public Restaurant save(Restaurant restaurant) {
        recalcularStatusEProblematico(restaurant);
        return repository.save(restaurant);
    }

    // ================= FIND =================
    public List<Restaurant> findAll() {
        return repository.findAll();
    }

    public Restaurant findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurante não encontrado"));
    }

  
    public Restaurant update(Long id, Restaurant newData) {

        Restaurant restaurant = findById(id);

        restaurant.setName(newData.getName());

       
        restaurant.setLastRating(restaurant.getAverageRating());

        
        restaurant.setAverageRating(newData.getAverageRating());

        restaurant.setTotalReviews(newData.getTotalReviews());

      
        recalcularStatusEProblematico(restaurant);

        return repository.save(restaurant);
    }

 
    public void delete(Long id) {
        repository.deleteById(id);
    }


    public List<Restaurant> findAlerts() {
        return repository.findByProblematicTrue();
    }

    public List<Restaurant> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    public List<Restaurant> getRanking() {
        return repository.findByOrderByAverageRatingAsc();
    }

    public List<Restaurant> findProblematicRestaurants(Double rating, Integer minReviews) {
        return repository.findByAverageRatingLessThanAndTotalReviewsGreaterThanEqual(rating, minReviews);
    }


    private void recalcularStatusEProblematico(Restaurant restaurant) {

        if (restaurant.getAverageRating() != null && restaurant.getAverageRating() < 2.0) {
            restaurant.setStatus("CRITICO");
        } else if (restaurant.getAverageRating() != null && restaurant.getAverageRating() < 3.0) {
            restaurant.setStatus("ALERTA");
        } else {
            restaurant.setStatus("OK");
        }

        boolean problematic = monitoringService.isProblematic(restaurant);
        restaurant.setProblematic(problematic);
    }
}
