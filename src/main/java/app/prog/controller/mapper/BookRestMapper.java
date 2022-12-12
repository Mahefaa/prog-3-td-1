package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CategoryResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.BookEntity;
import app.prog.service.AuthorService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookRestMapper {
  private final AuthorService authorService;
  private final CategoryRestMapper categoryMapper;

  public BookResponse toRest(BookEntity domain) {
    String authorName = domain.getAuthor() == null ? null : domain.getAuthor().getName();
    List<CategoryResponse> categories =
        domain.getCategories().stream().map(categoryMapper::toRest)
            .collect(Collectors.toUnmodifiableList());
    return BookResponse.builder()
        .id(domain.getId())
        .title(domain.getTitle())
        .author(authorName)
        .hasAuthor(domain.hasAuthor())
        .categories(categories)
        .build();
  }

  public BookEntity toDomain(CreateBookResponse rest) {
    return BookEntity.builder()
        .author(authorService.getByName(rest.getAuthor()))
        .title(rest.getTitle())
        .pageNumber(0) //Constraint not null in database, default value is 0
        .build();
  }

  public BookEntity toDomain(UpdateBookResponse rest) {
    return BookEntity.builder()
        .id(rest.getId())
        .author(authorService.getByName(rest.getAuthor()))
        .title(rest.getTitle())
        .pageNumber(0) //Constraint not null in database, default value is 0
        .build();
  }
}
