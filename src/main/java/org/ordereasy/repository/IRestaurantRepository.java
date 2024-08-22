package org.ordereasy.repository;

import org.ordereasy.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
