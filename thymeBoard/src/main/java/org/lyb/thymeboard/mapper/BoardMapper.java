package org.lyb.thymeboard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lyb.thymeboard.dto.BoardDTO;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDTO> getBoardList();
    int insertBoard(BoardDTO boardDTO);
    BoardDTO selectOne(int bno);
    void updateReadCount(int bno);
    int updateBoard(BoardDTO boardDTO);
    int deleteBoard(int bno);
}
