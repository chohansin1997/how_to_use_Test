package com.example.how_to_use_java_mapper.vo;

import lombok.Data;

@Data
public class RestaurantSearch {

	//페이지 수 [0 부터 시작]
	private Integer page = 0;

	//페이지에 보여질 컨텐츠 수
	private Integer cpp = 5;

	private String keyword;

	private String otype;

	boolean desc;
}
