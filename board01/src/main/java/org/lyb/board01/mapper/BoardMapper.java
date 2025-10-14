package org.lyb.board01.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lyb.board01.dto.BoardDTO;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDTO> selectAllBoards();
    int insertBoard(BoardDTO boardDTO);
    BoardDTO selectOne(int bno);
    void updateReadCount(int bno);
    int deleteBoard(int bno);
    int updateBoard(BoardDTO boardDTO);
}
