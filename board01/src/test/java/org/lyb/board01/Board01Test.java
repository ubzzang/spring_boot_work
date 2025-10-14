package org.lyb.board01;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.lyb.board01.dto.BoardDTO;
import org.lyb.board01.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@Log4j2
public class Board01Test {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void test2(){
        List<BoardDTO> dtoList=boardMapper.selectAllBoards();
        for(BoardDTO boardDTO:dtoList){
            log.info(boardDTO);
        }
    }

    @Test
    public void test01() {
        try{
            Connection conn=dataSource.getConnection();
            log.info(conn+"DB연결 성공");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
