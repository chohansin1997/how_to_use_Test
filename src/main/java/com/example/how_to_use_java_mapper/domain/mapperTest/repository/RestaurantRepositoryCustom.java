package com.example.how_to_use_java_mapper.domain.mapperTest.repository;

import com.example.how_to_use_java_mapper.domain.mapperTest.entity.Restaurant;
import com.example.how_to_use_java_mapper.vo.RestaurantSearch;
import org.springframework.data.domain.Page;

public interface RestaurantRepositoryCustom {

	Page<Restaurant> getRestaurantPage(RestaurantSearch search);

}
