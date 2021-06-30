package com.example.how_to_use_java_mapper.domain.mapperTest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantCreateRequest {
	@NotBlank(message = "레스토랑 이름을 입력해주세요.")
	private	String name;

	private	List<Long> menuIdList;
}
