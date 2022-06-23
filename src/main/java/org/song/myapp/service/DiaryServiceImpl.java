package org.song.myapp.service;

import java.util.ArrayList;
import java.util.List;

import org.song.myapp.mapper.DiaryMapper;
import org.song.myapp.model.DiaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Service
@Log4j
public class DiaryServiceImpl implements DiaryService {

	@Setter(onMethod_=@Autowired)
	private DiaryMapper mapper;
	
	@Override
	public List<DiaryDTO> selectAll() {
		List<DiaryDTO> list = mapper.selectAll();
		return list;
	}

	@Override
	public DiaryDTO selectOne(int no) {
		return mapper.selectOne(no);
	}

	@Override
	public void insert(DiaryDTO dto) {
		mapper.insert(dto);
	}

	@Override
	public void delete(int no) {
		mapper.delete(no);
	}

	@Override
	public void update(DiaryDTO dto) {
		mapper.update(dto);
	}

}
