package org.lyb.jpa.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long bno;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private String author;
    private int readcount;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
}
