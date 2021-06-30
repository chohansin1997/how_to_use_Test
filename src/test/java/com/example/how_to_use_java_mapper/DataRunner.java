package com.example.how_to_use_java_mapper;

import com.example.how_to_use_java_mapper.domain.mapperTest.dto.request.AttachCreateRequest;
import com.example.how_to_use_java_mapper.domain.mapperTest.dto.request.IdRequest;
import com.example.how_to_use_java_mapper.domain.mapperTest.dto.request.MenuCreateRequest;
import com.example.how_to_use_java_mapper.domain.mapperTest.dto.request.RestaurantCreateRequest;
import com.example.how_to_use_java_mapper.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataRunner implements ApplicationRunner {

	@Autowired
	TestService testService;

	public static List<Long> attachIdList = new ArrayList<>();
	public static List<Long> menuIdList = new ArrayList<>();
	public static List<Long> restaurantIdList = new ArrayList<>();

	@Override
	public void run(ApplicationArguments args) throws Exception {
		createAttach();
		createMenu();
		createRestaurant();
	}

	public void createAttach() {
		for (int i = 1; i < 40; i++) {
			AttachCreateRequest dto = new AttachCreateRequest();

			dto.setPath("upload/temp/20210629/6519b6ac-6afe-4e25-9ab0-03bf8ca1ea57.png");
			dto.setFilename("1006.png");
			dto.setContentType("image/png");
			dto.setSize(38200l);

			attachIdList.add(testService.createAttach(dto));
		}

	}

	public void createMenu() {
		for (int i = 1; i < 20; i++) {

			MenuCreateRequest dto = new MenuCreateRequest();

			dto.setName("메뉴" + i);

			List<Long> attachId = new ArrayList<>();

			attachId.add(attachIdList.get(i * 2));
			attachId.add(attachIdList.get(i * 2 - 1));
			dto.setAttachIdList(attachId.stream().map(item -> IdRequest.builder().id(item).build()).collect(Collectors.toList()));
			dto.setPrice(10000l + i * 1000);

			menuIdList.add(testService.createMenu(dto));

		}
	}

	public void createRestaurant() {

		for (int i = 1; i < 10; i++) {
			RestaurantCreateRequest dto = new RestaurantCreateRequest();

			dto.setName("레스토랑" + i);

			List<Long> menuId = new ArrayList<>();

			menuId.add(menuIdList.get(i * 2));
			menuId.add(menuIdList.get(i * 2 - 1));

			dto.setMenuIdList(menuId);

			restaurantIdList.add(testService.createRestaurant(dto));
		}
	}
}