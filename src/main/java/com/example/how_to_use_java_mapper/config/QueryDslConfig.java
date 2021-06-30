package com.example.how_to_use_java_mapper.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QueryDslConfig {

	/**
	 * The Entity manager 영속성 컨텍스트 설정
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Jpa query factory jpa query factory.
	 *
	 * @return the jpa query factory
	 * @author [류성재]
	 * @implNote JPAQueryFactory Bean 등록
	 * @since 2021. 2. 24. 오후 5:33:37
	 */
	@Bean
	public JPAQueryFactory jPAQueryFactory() {
		return new JPAQueryFactory(entityManager);
	}

	/**
	 * Gets entity manager.
	 *
	 * @return the entity manager
	 * @author [류성재]
	 * @implNote Getter Entity Manager
	 * @since 2021. 2. 24. 오후 5:33:37
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
