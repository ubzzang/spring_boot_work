package org.lyb.bootboard.service;

import lombok.extern.log4j.Log4j2;
import org.lyb.bootboard.domain.BoardVO;
import org.lyb.bootboard.dto.BoardDTO;
import org.lyb.bootboard.dto.PageRequestDTO;
import org.lyb.bootboard.dto.PageResponseDTO;
import org.lyb.bootboard.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

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
    public PageResponseDTO<BoardDTO> getPageBoardList(PageRequestDTO pageRequestDTO) {
        List<BoardDTO> dtoList = boardMapper.selectPageBoards(pageRequestDTO);
        int total = boardMapper.getCount(pageRequestDTO);

        return PageResponseDTO.<BoardDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
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
