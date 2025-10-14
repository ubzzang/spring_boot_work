package org.lyb.board01.controller;

import lombok.extern.log4j.Log4j2;
import org.lyb.board01.dto.BoardDTO;
import org.lyb.board01.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @GetMapping("/list")
    public void list(Model model){
        log.info("list");
        model.addAttribute("boardList", boardService.selectAll());
        //return "/board/list";
    }
    @GetMapping("register")
    public void registerBoard(){
        log.info("registerBoard");
    }
    @PostMapping("register")
    public String registerBoard(BoardDTO boardDTO){
        log.info("registerBoard");
        int result=boardService.insertBoard(boardDTO);
        if(result==1){
            return "redirect:/board/list";
        }else{
            return "redirect:/board/register";
        }
    }
    @GetMapping({"read", "modify"})
    public void read_modify(@RequestParam("bno") int bno, Model model){
        log.info("read_modify");
        model.addAttribute("board", boardService.selectOne(bno));
    }
    @GetMapping("remove")
    public String removeBoard(@RequestParam("bno") int bno){
        log.info("removeBoard");
        int result=boardService.removeBoard(bno);
        if(result==1){
            return "redirect:/board/list";
        }else{
            return "redirect:/board/read?bno="+bno;
        }
    }
    @PostMapping("modify")
    public String modifyBoard(BoardDTO boardDTO){
        log.info("modifyBoard");
        int result=boardService.modifyBoard(boardDTO);
        if(result==1){
            return "redirect:/board/read?bno="+boardDTO.getBno();
        }else{
            return  "redirect:/board/modify?bno="+boardDTO.getBno();
        }
    }
}
