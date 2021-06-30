package com.example.how_to_use_java_mapper.service;

import com.example.how_to_use_java_mapper.domain.mapperTest.dto.request.AttachCreateRequest;
import com.example.how_to_use_java_mapper.domain.mapperTest.dto.request.MenuCreateRequest;
import com.example.how_to_use_java_mapper.domain.mapperTest.dto.request.RestaurantCreateRequest;
import com.example.how_to_use_java_mapper.domain.mapperTest.entity.Menu;
import com.example.how_to_use_java_mapper.domain.mapperTest.entity.Restaurant;
import com.example.how_to_use_java_mapper.domain.mapperTest.service.AttachService;
import com.example.how_to_use_java_mapper.domain.mapperTest.service.MenuService;
import com.example.how_to_use_java_mapper.domain.mapperTest.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class TestService {

	private final AttachService attachService;

	private final MenuService menuService;

	private final RestaurantService restaurantService;

	@Transactional
	public Long createAttach(AttachCreateRequest dto) {

		return attachService.createAttach(dto.getFilename(), dto.getPath(), dto.getContentType(), dto.getSize());
	}

	@Transactional
	public Long createMenu(MenuCreateRequest dto) {
		Menu menu = menuService.createMenu(dto.getName(),dto.getPrice());

		dto.getAttachIdList().stream().map(item ->  attachService.getAttach(item.getId())).forEach(attach -> attach.updateMenu(menu));
		return menu.getId();

	}

	@Transactional
	public Long createRestaurant(RestaurantCreateRequest dto) {
		Restaurant restaurant = restaurantService.createRestaurant(dto.getName());
		dto.getMenuIdList().stream().map(item -> menuService.getMenu(item)).forEach(menu -> menu.updateRestaurant(restaurant));

		return restaurant.getId();

	}
}
