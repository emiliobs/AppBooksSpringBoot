package emisoft.appbooksstorespringboot.Controller;

import emisoft.appbooksstorespringboot.Services.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyBooksController
{
    @Autowired
    private final MyBookService myBookService;

    public MyBooksController(MyBookService myBookService)
    {
        this.myBookService = myBookService;
    }

    @GetMapping("/deleteMyBook/{id}")
    public String DeleteMyBooks(@PathVariable("id") int id)
    {
        myBookService.DeleteMyBook(id);

        return "redirect:/mybookLis";
    }
}
