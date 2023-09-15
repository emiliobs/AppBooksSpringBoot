package emisoft.appbooksstorespringboot.Controller;


import emisoft.appbooksstorespringboot.Entities.Book;
import emisoft.appbooksstorespringboot.Services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
public class BookController
{
    private final BookService bookService;

    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

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