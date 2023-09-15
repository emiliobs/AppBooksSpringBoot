package emisoft.appbooksstorespringboot.Services;

import emisoft.appbooksstorespringboot.Entities.MyBookList;
import emisoft.appbooksstorespringboot.Repositories.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService
{
    @Autowired
    private final MyBookRepository myBookRepository;

    public MyBookService(MyBookRepository myBookRepository)
    {
        this.myBookRepository = myBookRepository;
    }

    public void SaveMyBook(MyBookList myBookList)
    {
        myBookRepository.save(myBookList);
    }

    public List<MyBookList> GetAllMyBooks()
    {
        return myBookRepository.findAll();
    }
}
