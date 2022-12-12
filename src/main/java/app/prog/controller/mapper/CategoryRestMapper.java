package app.prog.controller.mapper;

import app.prog.controller.response.CategoryResponse;
import app.prog.model.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryRestMapper {
  public CategoryResponse toRest(CategoryEntity entity) {
    return CategoryResponse.builder()
        .id(entity.getId())
        .name(entity.getName())
        .build();
  }
}
