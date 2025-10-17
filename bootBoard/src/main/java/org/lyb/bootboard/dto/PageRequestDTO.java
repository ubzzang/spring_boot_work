package org.lyb.bootboard.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    @Builder.Default
    @Min(value = 1)
    @Max(value = 100)
    @Positive
    private int page=1;
    private int size=3;
    private String link;
    private String[] types;
    private String keyword;
    private boolean finished;
    private LocalDate from;
    private LocalDate to;
    private String searchField;

    public int getSkip() {
        return (page - 1) * size;
    }

    public String getLink() {
        if (link == null) {
            StringBuilder builder = new StringBuilder();
            builder.append("page="+this.page);
            builder.append("&size="+this.size);
            if(finished){
                builder.append("&finished=on");
            }
            if(types!=null && types.length>0){
                for(int i=0;i<types.length;i++){
                    builder.append("&type="+types[i]);
                }
            }
            if(keyword!=null && keyword.length()>0){
                try {
                    builder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if(from!=null){
                builder.append("&from="+from);
            }
            if(to!=null){
                builder.append("&to="+to);
            }
            link = builder.toString(); // page=1&size=10;
        }
        return link;
    }
    public boolean checkType(String type){
        if(types==null || types.length==0){
            return false;
        }
        return Arrays.stream(types).anyMatch(type::equals);
    }
}
