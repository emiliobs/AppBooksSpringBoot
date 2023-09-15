package emisoft.appbooksstorespringboot.Repositories;

import emisoft.appbooksstorespringboot.Entities.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MyBookRepository extends JpaRepository<MyBookList, Integer>
{
}
