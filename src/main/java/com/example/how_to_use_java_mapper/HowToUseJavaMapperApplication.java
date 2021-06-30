package com.example.how_to_use_java_mapper;

import com.example.how_to_use_java_mapper.domain.mapperTest.dto.request.AttachCreateRequest;
import com.example.how_to_use_java_mapper.domain.mapperTest.dto.request.IdRequest;
import com.example.how_to_use_java_mapper.domain.mapperTest.dto.request.MenuCreateRequest;
import com.example.how_to_use_java_mapper.domain.mapperTest.dto.request.RestaurantCreateRequest;
import com.example.how_to_use_java_mapper.domain.mapperTest.service.AttachService;
import com.example.how_to_use_java_mapper.domain.mapperTest.service.MenuService;
import com.example.how_to_use_java_mapper.domain.mapperTest.service.RestaurantService;
import com.example.how_to_use_java_mapper.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RequiredArgsConstructor
public class HowToUseJavaMapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(HowToUseJavaMapperApplication.class, args);
	}
}
