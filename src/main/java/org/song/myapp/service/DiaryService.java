package org.song.myapp.service;

import java.util.List;

import org.song.myapp.model.DiaryDTO;

public interface DiaryService {

	public List<DiaryDTO> selectAll();
	public DiaryDTO selectOne(int no);
	public void insert(DiaryDTO dto);
	public void delete(int no);
	public void update(DiaryDTO dto);
}
