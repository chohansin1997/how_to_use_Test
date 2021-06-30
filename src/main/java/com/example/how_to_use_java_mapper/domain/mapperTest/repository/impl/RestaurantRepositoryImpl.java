package com.example.how_to_use_java_mapper.domain.mapperTest.repository.impl;

import com.example.how_to_use_java_mapper.domain.mapperTest.entity.Restaurant;
import com.example.how_to_use_java_mapper.domain.mapperTest.repository.RestaurantRepositoryCustom;
import com.example.how_to_use_java_mapper.vo.RestaurantSearch;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;

import static com.example.how_to_use_java_mapper.domain.mapperTest.entity.QRestaurant.restaurant;

@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public Page<Restaurant> getRestaurantPage(RestaurantSearch search) {

		JPAQuery<Restaurant> query = queryFactory
				.selectFrom(restaurant)
				.where(restaurant.delFlag.isFalse(), restaurant.useFlag.isTrue());

		String keyword = search.getKeyword();

		if (StringUtils.hasLength(keyword)) {
			BooleanBuilder keywordBoolean = new BooleanBuilder();

			keywordBoolean
					.or(restaurant.name.containsIgnoreCase(keyword))
					.or(restaurant.menuList.any().name.containsIgnoreCase(keyword));

			query.where(keywordBoolean);
		}

		query.orderBy(restaurant.id.desc());

		//org.springframework.data.domain
		//페이징 처리를 자동으로 해준다  => 페이지와 사이즈를 넣으면
		PageRequest pageRequest = PageRequest.of(search.getPage(), search.getCpp());
		//sql 문에서 OFFSET을 사용하면, 원하는 행의 수 만큼을 건너뛰고 그 이후의 행부터 검색이 가능하다.
		// 예를들어 select * from student offset 2 rows; 를 사용하면 3번째 값부터 나오게 된다
		// 그래서 offset 과 limit를같이 사용하면 손쉽게 페이징 처리를 할 수 있다.
		query.offset(pageRequest.getOffset())
				.limit(pageRequest.getPageSize());

		QueryResults<Restaurant> result = query.fetchResults();
		return new PageImpl<>(result.getResults(), pageRequest, result.getTotal());
	}
}
