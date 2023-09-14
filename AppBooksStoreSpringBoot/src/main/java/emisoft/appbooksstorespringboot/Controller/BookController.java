package emisoft.appbooksstorespringboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController
{
    @GetMapping("/")
    public String home()
    {
        return "home";
    }

    @GetMapping("/bookRegister")
    public  String BookRegister()
    {

        return "bookRegister";
    }

    @GetMapping("/availableBooks")
    public  String GetAllBooks()
    {
        return "/bookList";
    }
}
