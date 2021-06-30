package com.example.how_to_use_java_mapper.domain.mapperTest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuCreateRequest {

	@NotBlank(message = "첨부파일 이름이 없어서는 안됩니다.")
	@Length(min = 1, max = 30, message = "첨부파일 이름은 1~30글자 이내로 적어주세요")
	private String name;

	@NotNull(message = "가격을 입력해 주세요")
	@Min(value = 0)
	@Max(value = 9999999)
	private Long price;

	private List<IdRequest> attachIdList;

}
