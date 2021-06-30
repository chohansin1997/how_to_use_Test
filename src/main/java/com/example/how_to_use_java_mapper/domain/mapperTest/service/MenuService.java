package com.example.how_to_use_java_mapper.domain.mapperTest.service;

import com.example.how_to_use_java_mapper.domain.mapperTest.entity.Menu;
import com.example.how_to_use_java_mapper.domain.mapperTest.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenuService {

	private final MenuRepository menuRepository;

	@Transactional
	public Menu createMenu(String name, Long price) {
		return menuRepository.save(Menu.createMenu(
				name,
				price
		));
	}

	public Menu getMenu(Long id) {
		return menuRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

}
