package com.example.how_to_use_java_mapper.domain.mapperTest.service;

import com.example.how_to_use_java_mapper.domain.mapperTest.dto.request.AttachCreateRequest;
import com.example.how_to_use_java_mapper.domain.mapperTest.entity.Attach;
import com.example.how_to_use_java_mapper.domain.mapperTest.entity.Menu;
import com.example.how_to_use_java_mapper.domain.mapperTest.repository.AttachRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AttachService {

	private final AttachRepository attachRepository;

	@Transactional
	public Long createAttach(String filename, String path, String contentType, Long size) {
		return attachRepository.save(Attach.createAttach(filename, path,
				contentType, size)).getId();
	}

	public Attach getAttach(Long id) {

		return attachRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	public List<Attach> getAttach(Menu menu) {

		return attachRepository.findByMenu(menu);
	}
}
