package com.yedam.app.book.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

//클래스를 만들떈 언노테이션이 필요한지 생각


//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode

@Data //getter, setter, ToString 등등

public class BookVO { // 데이터를 담는 대상
		private int bookNo;
		private String bookName;
		private String bookCoverImg;
		//기본포맷: yyyy/MM/dd
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date bookDate;
		private int bookPrice;
		private String bookPublisher;
		private String bookInfo;
		// rent_tbl_06
		private int rentCount; //rent_count
		private int rentTotalPrice;//rent_total_price
}
