
package com.smartcomplaint.repository;

import com.smartcomplaint.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import com.smartcomplaint.repository.RestaurantRepository;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	List<Restaurant> findByAverageRatingLessThanAndTotalReviewsGreaterThanEqual(Double averagerating,
			Integer totalReviews);

	List<Restaurant> findByProblematicTrue();

	List<Restaurant> findByStatus(String status);

	List<Restaurant> findByOrderByAverageRatingAsc();
}