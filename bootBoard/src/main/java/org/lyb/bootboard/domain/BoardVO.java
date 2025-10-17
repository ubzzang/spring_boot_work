package org.lyb.bootboard.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardVO {
    private int bno;
    private String title;
    private String content;
    private String writer;
    private Date postdate;
    private int readcount;
    private String ofile;
    private String sfile;
    private MultipartFile file;
}
