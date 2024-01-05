package com.nt.controller;

import com.nt.model.Book;
import com.nt.model.IssuedBook;
import com.nt.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



import com.nt.model.Librarian;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Slf4j
@Controller
public class AdminController {
    private static final Logger logger = LogManager.getLogger(AdminServiceImpl.class);


    @Autowired
    private AdminService adminService;
    private final LibrarianService librarianService;

    @Autowired
    public AdminController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }
    @Autowired
    private BookService bookService;
    @Autowired
    private IssuedBookService issuedBookService;


    @GetMapping("/")
    public String home()
    {
    	return "home";
    }
    @GetMapping("/admin")
    public String adminLogin()
    {
       return "admin";
    }
    @PostMapping("/admin")
    public String processLogin(String username, String password, RedirectAttributes attributes)
    {
        if (adminService.authenticateAdmin(username, password))
        {
            logger.info("Admin login successfully");
            return "/dashboard";
        }
        else
        {
            logger.error("please enter a valid userName and password");
            return "error1";
        }
    }

    @GetMapping("/librarians")
    public String viewLibrarians(Model model) {
        List<Librarian> librarians = adminService.getAllLibrarians();
        model.addAttribute("librarians", librarians);
        logger.info("Librarian viewed");
        return "viewlibrarians";
    }

    @GetMapping("/librarians/add")
    public String addLibrarianForm(Model model) {
        model.addAttribute("librarian", new Librarian());
        logger.info("Librarian added sucessfully");
        return "addlibrarian";
    }

    @PostMapping("/librarians/add")
    public String addLibrarian(@ModelAttribute("librarian") Librarian librarian) {
        adminService.addLibrarian(librarian);

        return "redirect:/librarians";
    }
    @GetMapping("/librarians/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model)
    {
        Optional<Librarian> librarian = adminService.findById(id);
        if (librarian.isPresent()) {
            model.addAttribute("librarian", librarian.get());
            logger.info("edit librarian successfully");
            return "editlibrarian";
        }
        else
        {
            logger.error("Please enter a valid librarian");
            return "/error";
        }
    }

    @PostMapping("/librarians/update")
    public String updateLibrarian(@ModelAttribute Librarian librarian) {
        adminService.updateLibrarian(librarian);
        logger.info("librarian added successfully");
        return "redirect:/librarians";
    }


    @GetMapping("/librarians/delete/{id}")
    public String deleteLibrarian(@PathVariable("id") String librarianId) {
        adminService.deleteLibrarian(librarianId);
        logger.info("librarian deleted successfully"+librarianId);
        return "deletelibrarians";
    }




    @GetMapping("/librarian")
    public String librarian()
    {
        return "librarian";
    }
    @PostMapping("/librarian")
    public String login(String username, String password, Model model) {
        if (librarianService.isValidLogin(username, password)) {
            logger.info("Librarian login successfully ");
            return "/librariandashboard";
        } else {
            model.addAttribute("error", "Invalid username or password.");
            logger.error("please enter a valid usename and password");
            return "/error1";
        }
    }
    @GetMapping("/books")
    public String viewBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        logger.info("Book viewed");
        return "viewbooks";
    }

   @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        logger.info("Book added successfully");
        return "redirect:/books";
    }
    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") String bookId)
    {
       bookService.deleteBook(bookId);
       logger.info("delete book successfully");
       return "deleteBook";
    }



    @GetMapping("/viewIssuedBook")
    public String viewIssuedBooks(Model model) {
        List<IssuedBook> issuedBooks = issuedBookService.getAllIssuedBook();
        model.addAttribute("issuedBooks", issuedBooks);
        return "viewissuedbook";
    }


    @GetMapping("/addIssuedBook")
    public String addIssuedBookForm(Model model)
    {
        model.addAttribute("issuedBook",new IssuedBook());
        return "addIssuedBook";
    }
    @PostMapping("/addIssuedBook")
    public String addIssuedBook(@ModelAttribute("issuedBook") IssuedBook issuedBook, Model model) {
        String bookId = issuedBook.getBookId();


        logger.info("Checking bookId: " + bookId);


        if (!bookService.bookExists(bookId)) {
            model.addAttribute("error", "Book with ID " + bookId + " does not exist.");
            return "error";
        }

        issuedBookService.addIssuedBook(issuedBook);
        logger.info("Book issued successfully");
        return "redirect:/viewIssuedBook";
    }
    @GetMapping("/deleteIssuedBook/{id}")
    public String deleteIssuedBook(@PathVariable String id) {
        issuedBookService.deleteIssuedBook(id);
        return "redirect:/viewIssuedBook";
    }

}

