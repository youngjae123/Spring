package com.yedam.app.book.mapper;

import java.util.List;

import com.yedam.app.book.service.BookVO;

// 인터페이스는 어노테이션이 필요없다 = 빈으로 등록해야할 대상이 아님으로
public interface BookMapper {
	
	// 도서전체조회
	public List<BookVO> selectAllList();
	
	// 도서번호조회
	public BookVO getBookNo();
	
	// 도서등록
	public int insertBook(BookVO bookVO);
}
