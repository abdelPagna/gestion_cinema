package org.apfk.CineBackEnd.dto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class CategorieDto {
	private Long id;
	private String name;

}
