package com.gyojincompany.profile.dao;

import java.util.ArrayList;

import com.gyojincompany.profile.dto.BoardDto;

public interface BoardDao {
	
	public void writeDao(String bid, String bname, String btitle, String bcontent);//게시판 글쓰기
	public ArrayList<BoardDto> listDao();//게시판 리스트 가져오기
	public BoardDto contentViewDao(String bnum);//글 내용 보기
}
