package com.example.how_to_use_java_mapper.domain.mapperTest.repository;


import com.example.how_to_use_java_mapper.domain.mapperTest.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long>, MenuRepositoryCustom {


}
