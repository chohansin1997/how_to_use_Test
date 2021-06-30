package com.example.how_to_use_java_mapper.domain.mapperTest.repository;

import com.example.how_to_use_java_mapper.domain.mapperTest.entity.Attach;
import com.example.how_to_use_java_mapper.domain.mapperTest.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachRepository extends JpaRepository<Attach, Long> {

	List<Attach> findByMenu(Menu menu);
}
