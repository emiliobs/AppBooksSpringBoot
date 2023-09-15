package emisoft.appbooksstorespringboot.Controller;


import emisoft.appbooksstorespringboot.Entities.Book;
import emisoft.appbooksstorespringboot.Entities.MyBookList;
import emisoft.appbooksstorespringboot.Services.BookService;
import emisoft.appbooksstorespringboot.Services.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
public class BookController
{
    @Autowired
    private final BookService bookService;

    @Autowired
    private final MyBookService myBookService;

    public BookController(BookService bookService, MyBookService myBookService)
    {
        this.bookService = bookService;
        this.myBookService = myBookService;
    }

    @GetMapping("/")
    public String home()
    {
        return "home";
    }

    @GetMapping("/bookRegister")
    public  String BookRegister()
    {

        return "/bookRegister";
    }

    @GetMapping("/mybooks")
    public  String GetMyBooksList(Model model)
    {
         model.addAttribute("myBooks", myBookService.GetAllMyBooks());

        return "/mybooks";
    }
    @RequestMapping("/mybooks/{id}")
    public  String GetMyBookList(@PathVariable("id") int id)
    {
        Book book = bookService.GetBookById(id);
        MyBookList myBookList = new MyBookList();
        myBookList.setId(book.getId());
        myBookList.setAuthor(book.getAuthor());
        myBookList.setName(book.getName());
        myBookList.setMimeType(book.getMimeType());
        myBookList.setPrice(book.getPrice());
        myBookList.setPhoto(book.getFoto());

        myBookService.SaveMyBook(myBookList);

        return "/mybooks";
    }

    @GetMapping("/availableBooks")
    public  String GetAllBooks(Model model)
    {
        model.addAttribute("books", bookService.GetAllBooks());


        return "/bookList";
    }

    @PostMapping("/save")
    public String AddBook(@RequestParam(name = "photo") MultipartFile file, @ModelAttribute Book book) throws IOException
    {
        byte[] bytes = file.getBytes();
        String ecodedString = Base64.getEncoder().encodeToString(bytes);
        book.setMimeType(file.getContentType());
        book.setFoto(ecodedString);
        bookService.Save(book);

        return "redirect:/availableBooks";
    }


}


//    // Get the file and save it somewhere
//    byte[] bytes = file.getBytes();
//    String encodedString = Base64.getEncoder().encodeToString(bytes);
//    //creando salvando el objeto.
//    Foto foto = new Foto(file.getOriginalFilename(), file.getContentType(), encodedString);
//        fotoRepository.save(foto);
//                return "redirect:/listar";