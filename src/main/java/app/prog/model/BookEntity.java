package app.prog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String title;
  @ManyToOne
  @JoinColumn(name = "author_name", referencedColumnName = "name")
  private AuthorEntity author;
  private Integer pageNumber;
  private LocalDate releaseDate;
  @ManyToMany
  @JoinTable(name = "has_category",
      joinColumns = @JoinColumn(name = "id_book", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "id_category", referencedColumnName = "id"))
  @JsonIgnoreProperties("books")
  private List<CategoryEntity> categories;

  public boolean hasAuthor() {
    return author != null;
  }

}
