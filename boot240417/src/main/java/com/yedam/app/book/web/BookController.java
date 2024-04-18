package com.yedam.app.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

@Controller
public class BookController {
	@Autowired
	BookService bookService; // 서비스 불러옴
	
	
	// 도서전체조회 - GET = 빈페이지나 무언가를 조회할때 씀
	
	@GetMapping("bookList")
	public String bookList(Model model) {
		List<BookVO> list = bookService.bookList();
		model.addAttribute("books",list);
		return"book/list";//출력할 페이지 
		//classpath:/templates/book/list.html
	}
	
	// 도서등록 -페이지(빈페이지) : GET 
	@GetMapping("bookInsert")
	public String bookInsertForm(Model model) {
		BookVO bookVO = bookService.getBookNo();
		model.addAttribute("book",bookVO);
		return "book/insert";
		// classpath:/templates/book/insert.html
	}
	
	// 도서등록 - 처리 : POST
	@PostMapping("bookInsert")
	public String bookInsertProcess(BookVO bookVO) {
		bookService.bookInfoInsert(bookVO);
		return "redirect:bookList";
	};
	
	@GetMapping("rentList")
	public String rentList(Model model) {
		List<BookVO> list = bookService.rentInfo();
		model.addAttribute("rent",list);
		return "rent/list";
	}
}
