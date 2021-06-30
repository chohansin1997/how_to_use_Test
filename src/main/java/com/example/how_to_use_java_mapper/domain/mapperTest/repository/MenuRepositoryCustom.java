package com.example.how_to_use_java_mapper.domain.mapperTest.repository;

import com.example.how_to_use_java_mapper.domain.mapperTest.entity.Menu;
import com.example.how_to_use_java_mapper.vo.RestaurantSearch;
import org.springframework.data.domain.Page;

public interface MenuRepositoryCustom {

	Page<Menu> getPage(Long id, RestaurantSearch search);

}
