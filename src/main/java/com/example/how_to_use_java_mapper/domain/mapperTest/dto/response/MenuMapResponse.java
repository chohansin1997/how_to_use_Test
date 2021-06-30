package com.example.how_to_use_java_mapper.domain.mapperTest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuMapResponse {

	private String name;
	private Long price;
	private RestaurantForMenuResponse restaurant;

}
