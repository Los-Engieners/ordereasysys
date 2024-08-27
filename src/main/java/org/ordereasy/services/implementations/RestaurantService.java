package org.ordereasy.services.implementations;

import org.ordereasy.models.Restaurant;
import org.ordereasy.repository.IRestaurantRepository;
import org.ordereasy.services.interfaces.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService implements IRestaurantService{
    @Autowired
    private IRestaurantRepository restaurantrepository;

    @Override
    public Page<Restaurant> findAll(Pageable pageable) {
        return restaurantrepository.findAll(pageable);
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantrepository.findAll();
    }

    @Override
    public Optional<Restaurant> findOneById(Integer restaurantid) {
        return restaurantrepository.findById(restaurantid);
    }

    @Override
    public Restaurant createOrEditOne(Restaurant restaurant) {
        return restaurantrepository.save(restaurant);
    }

    @Override
    public void deleteOneById(Integer restaurantid) {
        restaurantrepository.deleteById(restaurantid);
    }
}
