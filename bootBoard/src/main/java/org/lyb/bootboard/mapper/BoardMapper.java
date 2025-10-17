package org.lyb.bootboard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lyb.bootboard.domain.BoardVO;
import org.lyb.bootboard.dto.BoardDTO;
import org.lyb.bootboard.dto.PageRequestDTO;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDTO> selectAllBoards();
    int insertBoard(BoardDTO boardDTO);
    BoardDTO selectOne(int bno);
    void updateReadCount(int bno);
    int deleteBoard(int bno);
    int updateBoard(BoardDTO boardDTO);
    List<BoardDTO> selectPageBoards(PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);
}
