package guru.springfamework.spring5webapp.repositories;

import guru.springfamework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
