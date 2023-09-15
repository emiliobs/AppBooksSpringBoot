package emisoft.appbooksstorespringboot.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
public class Book
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private  String author;
  private  String price;


  String mimeType;
  @Lob
  private String  foto;

    public Book()
    {
    }

    public Book(String mimeType, String foto)
    {
        this.mimeType = mimeType;
        this.foto = foto;
    }

    public Book(int id, String name, String author, String price, String mimeType, String foto)
    {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.mimeType = mimeType;
        this.foto = foto;
    }

    public Book(String name, String author, String price, String mimeType, String foto)
    {
        this.name = name;
        this.author = author;
        this.price = price;
        this.mimeType = mimeType;
        this.foto = foto;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getMimeType()
    {
        return mimeType;
    }

    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    public String getFoto()
    {
        return foto;
    }

    public void setFoto(String foto)
    {
        this.foto = foto;
    }
}
