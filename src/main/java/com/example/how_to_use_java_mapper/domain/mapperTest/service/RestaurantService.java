package com.example.how_to_use_java_mapper.domain.mapperTest.service;

import com.example.how_to_use_java_mapper.domain.mapperTest.entity.Restaurant;
import com.example.how_to_use_java_mapper.domain.mapperTest.repository.RestaurantRepository;
import com.example.how_to_use_java_mapper.vo.RestaurantSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantService {

	private final MenuService menuService;

	private final RestaurantRepository restaurantRepository;

	@Transactional
	public Restaurant createRestaurant(String name) {
		return restaurantRepository.save(Restaurant.createEntity(name));
	}

	public Restaurant getRestaurant(Long id) {
		return restaurantRepository.getById(id);
	}

	public Page<Restaurant> getRestaurantPage(RestaurantSearch search) {
		return restaurantRepository.getRestaurantPage(search);
	}
}
