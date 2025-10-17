package org.lyb.bootboard.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.lyb.bootboard.dto.BoardDTO;
import org.lyb.bootboard.dto.PageRequestDTO;
import org.lyb.bootboard.dto.PageResponseDTO;
import org.lyb.bootboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@Controller
@Log4j2
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            pageRequestDTO = PageRequestDTO.builder().build();
        }

        String searchColumn = null;
        if (pageRequestDTO.getKeyword() != null && !pageRequestDTO.getKeyword().isEmpty()) {
            if ("title".equals(pageRequestDTO.getSearchField())) {
                searchColumn = "title";
            } else if ("content".equals(pageRequestDTO.getSearchField())) {
                searchColumn = "content";
            }
        }
        pageRequestDTO.setSearchField(searchColumn);

        PageResponseDTO<BoardDTO> responseDTO = boardService.getPageBoardList(pageRequestDTO);
        model.addAttribute("pageRequestDTO", pageRequestDTO);
        model.addAttribute("responseDTO", responseDTO);
    }




    //@GetMapping("/list")
    public void list(Model model){
        log.info("list");
        model.addAttribute("boardList", boardService.selectAll());
    }
    @GetMapping("register")
    public void registerBoard(){
        log.info("registerBoard");
    }

    // 글 등록 처리
    @PostMapping("register")
    public String registerBoard(BoardDTO boardDTO) throws IOException {

        MultipartFile file = boardDTO.getFile();

        if (file != null && !file.isEmpty()) {

            String uploadDir = new File("src/main/resources/static/uploads").getAbsolutePath();
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String uuid = UUID.randomUUID().toString();
            String sfile = uuid + "_" + file.getOriginalFilename();

            File saveFile = new File(uploadDir, sfile);
            file.transferTo(saveFile);

            boardDTO.setOfile(file.getOriginalFilename());
            boardDTO.setSfile(sfile);
        }
        int result = boardService.insertBoard(boardDTO);

        if(result == 1){
            return "redirect:/board/list";
        }else{
            return "redirect:/board/register";
        }
    }

    @GetMapping("read")
    public String readBoard(@RequestParam("bno") int bno, Model model) {
        model.addAttribute("board", boardService.selectOne(bno));
        return "board/read";
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
    @GetMapping("modify")
    public String modifyBoard(@RequestParam("bno") int bno, Model model) {
        model.addAttribute("board", boardService.selectOne(bno));
        return "board/modify";
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

    @GetMapping("/download")
    public void downloadFile(@RequestParam("ofile") String ofile,
                             @RequestParam("sfile") String sfile,
                             HttpServletResponse response) throws IOException {

        String uploadDir = new File("src/main/resources/static/uploads").getAbsolutePath();
        File file = new File(uploadDir, sfile);

        if (file.exists()) {
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=\"" +
                    new String(ofile.getBytes("UTF-8"), "ISO-8859-1") + "\"");
            response.setHeader("Content-Length", String.valueOf(file.length()));

            try (FileInputStream fis = new FileInputStream(file);
                 OutputStream os = response.getOutputStream()) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }
        } else {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().write("<script>alert('파일이 존재하지 않습니다.'); history.back();</script>");
        }
    }

}
