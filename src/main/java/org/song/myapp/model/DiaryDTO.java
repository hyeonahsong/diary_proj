package org.song.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaryDTO {
private int no;
private String title;
private String writer;
private String content;
private String write_date;
}
