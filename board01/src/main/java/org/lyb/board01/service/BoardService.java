package org.lyb.board01.service;

import org.lyb.board01.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> selectAll();
    int insertBoard(BoardDTO boardDTO);
    BoardDTO selectOne(int bno);
    int removeBoard(int bno);
    int modifyBoard(BoardDTO boardDTO);
}
