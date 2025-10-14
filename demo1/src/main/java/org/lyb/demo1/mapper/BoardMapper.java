package org.lyb.demo1.mapper;

import org.lyb.demo1.dto.BoardDTO;

import java.util.List;

public interface BoardMapper {
    List<BoardDTO> selectAllBoards();
}
