package com.example.how_to_use_java_mapper.domain.mapperTest.repository.impl;

import com.example.how_to_use_java_mapper.domain.mapperTest.entity.Menu;
import com.example.how_to_use_java_mapper.domain.mapperTest.entity.QMenu;
import com.example.how_to_use_java_mapper.domain.mapperTest.repository.MenuRepositoryCustom;
import com.example.how_to_use_java_mapper.vo.RestaurantSearch;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;

import static com.example.how_to_use_java_mapper.domain.mapperTest.entity.QMenu.menu;


@RequiredArgsConstructor
public class MenuRepositoryCustomImpl implements MenuRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public Page<Menu> getPage(Long id, RestaurantSearch search) {
		JPAQuery<Menu> query = queryFactory
				.selectFrom(menu)
				.where(menu.delFlag.isFalse(), menu.useFlag.isTrue());

		String keyword = search.getKeyword();

		if (StringUtils.hasLength(keyword)) {
			BooleanBuilder keywordBoolean = new BooleanBuilder();

			keywordBoolean
					.or(menu.name.containsIgnoreCase(keyword));
			query.where(keywordBoolean);
		}

		if ("name".equals(search.getOtype())) {
			OrderSpecifier<?> orderSpecifier = search.isDesc() ? menu.name.desc() : menu.name.asc();

			query.orderBy(orderSpecifier);
		} else if ("price".equals(search.getOtype())) {
			OrderSpecifier<?> orderSpecifier = search.isDesc() ? menu.price.desc() : menu.price.asc();

			query.orderBy(orderSpecifier);
		}

		query.orderBy(menu.id.desc());

		//org.springframework.data.domain
		//페이징 처리를 자동으로 해준다  => 페이지와 사이즈를 넣으면
		PageRequest pageRequest = PageRequest.of(search.getPage(), search.getCpp());
		//sql 문에서 OFFSET을 사용하면, 원하는 행의 수 만큼을 건너뛰고 그 이후의 행부터 검색이 가능하다.
		// 예를들어 select * from student offset 2 rows; 를 사용하면 3번째 값부터 나오게 된다
		// 그래서 offset 과 limit를같이 사용하면 손쉽게 페이징 처리를 할 수 있다.
		query.offset(pageRequest.getOffset())
				.limit(pageRequest.getPageSize());

		QueryResults<Menu> result = query.fetchResults();
		return new PageImpl<>(result.getResults(), pageRequest, result.getTotal());
	}

}
