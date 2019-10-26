package com.codve.read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author admin
 * @date 2019/10/26 12:03
 */
@Controller
@RequestMapping("/readingList")
public class ReadController {
    private BookRepository bookRepository;

    @Autowired
    public ReadController(BookRepository readRepository) {
        this.bookRepository = readRepository;
    }

    /**
     * 将数据塞入模型中, 键为 "books", 值为 List<Book>
     * 返回到名称为 "readingList" 的视图中
     * 视图在resources/templates/readingList.html
     * 访问地址为 /readingList/{reader}
     */
    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readerBooks(@PathVariable("reader") String reader, Model model) {
        List<Book> books = bookRepository.findByReader(reader);
        if (books != null) {
            model.addAttribute("books", books);
        }
        return "readingList";
    }

    /**
     * 存储数据, 最后重定向到/readingList/{reader}
     */
    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToBooks(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        bookRepository.save(book);
        return "redirect:/readingList/{reader}";
    }
}
