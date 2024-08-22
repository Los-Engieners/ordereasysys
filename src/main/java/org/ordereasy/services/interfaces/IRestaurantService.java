package org.ordereasy.services.interfaces;

import org.ordereasy.models.Restaurant;
import org.ordereasy.models.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IRestaurantService {
    Page<Restaurant> findAll(Pageable pageable);

    List<Restaurant> getAll();

    Optional<Restaurant> findOneById(Integer restaurantid);

    Restaurant createOrEditOne(Restaurant restaurant);

    void deleteOneById(Integer restaurantid);
}
