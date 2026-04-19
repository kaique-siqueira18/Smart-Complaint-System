package com.smartcomplaint.service;


import com.smartcomplaint.entity.Restaurant;
import org.springframework.stereotype.Service;

@Service
public class RestaurantMonitoringService {

    public boolean isProblematic(Restaurant restaurant) {
        // Verifica se os dados não são nulos para evitar erro de NullPointerException
        if (restaurant.getAverageRating() != null &&
            restaurant.getTotalReviews() != null) {
            
            // Lógica: Nota menor que 3.0 E pelo menos 5 avaliações
            if (restaurant.getAverageRating() < 3.0 && restaurant.getTotalReviews() >= 5) {
                return true;
            }
        }
        return false;
    }
    
    
}