package com.yedam.app.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.mapper.RentMapper;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookMapper bookMapper; // mapper 불러옴
	@Autowired
	RentMapper rentMapper;
	
	@Override //해당 메소드가 부모 클래스에 있는 메서드를 Override 했다는 것을 명시적으로 선언합니다
	public List<BookVO> bookList() { // 서비스 이름
		return bookMapper.selectAllList(); // 메퍼이름
	}

	@Override
	public BookVO getBookNo() {
		return bookMapper.getBookNo();
	}

	@Override
	public int bookInfoInsert(BookVO bookVO) {
		return bookMapper.insertBook(bookVO);
	}

	@Override
	public List<BookVO> rentInfo() {
		return rentMapper.selectRentInfo();
	}
}
