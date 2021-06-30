package com.example.how_to_use_java_mapper.domain.mapperTest.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RestaurantResponse {
	private String name;

	private List<MenuResponse> menuList;
}
