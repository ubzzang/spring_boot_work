package org.lyb.board01.service;

import lombok.extern.log4j.Log4j2;
import org.lyb.board01.dto.BoardDTO;
import org.lyb.board01.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Log4j2
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;
    @Override
    public List<BoardDTO> selectAll() {
        return boardMapper.selectAllBoards();
    }

    @Override
    public int insertBoard(BoardDTO boardDTO) {
        return boardMapper.insertBoard(boardDTO);
    }

    @Override
    public BoardDTO selectOne(int bno) {
        boardMapper.updateReadCount(bno);
        return boardMapper.selectOne(bno);
    }

    @Override
    public int removeBoard(int bno) {
        return boardMapper.deleteBoard(bno);
    }

    @Override
    public int modifyBoard(BoardDTO boardDTO) {
        return boardMapper.updateBoard(boardDTO);
    }
}
