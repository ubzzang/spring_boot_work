package org.lyb.thymeboard.service;

import org.lyb.thymeboard.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> findAllBoard();
    int insertBoard(BoardDTO boardDTO);
    BoardDTO selectOne(int bno);
    int removeBoard(int bno);
    int modifyBoard(BoardDTO boardDTO);
}
