package org.lyb.bootboard.service;

import org.lyb.bootboard.dto.BoardDTO;
import org.lyb.bootboard.dto.PageRequestDTO;
import org.lyb.bootboard.dto.PageResponseDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> selectAll();
    int insertBoard(BoardDTO boardDTO);
    BoardDTO selectOne(int bno);
    int removeBoard(int bno);
    int modifyBoard(BoardDTO boardDTO);
    PageResponseDTO<BoardDTO> getPageBoardList(PageRequestDTO pageRequestDTO);
}
