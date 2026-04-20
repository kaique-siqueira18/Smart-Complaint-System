package com.smartcomplaint.service;


import com.smartcomplaint.entity.Restaurant;
import org.springframework.stereotype.Service;

@Service
public class RestaurantMonitoringService {

    public boolean isProblematic(Restaurant restaurant) {
        
        if (restaurant.getAverageRating() != null &&
            restaurant.getTotalReviews() != null) {
            
            
            if (restaurant.getAverageRating() < 3.0 && restaurant.getTotalReviews() >= 5) {
                return true;
            }
        }
        return false;
    }
    
    
}