package com.example.how_to_use_java_mapper.domain.mapperTest.repository;


import com.example.how_to_use_java_mapper.domain.mapperTest.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>, RestaurantRepositoryCustom {


}
