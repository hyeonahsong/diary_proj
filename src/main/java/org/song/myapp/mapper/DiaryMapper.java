package org.song.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.song.myapp.model.DiaryDTO;

public interface DiaryMapper {

	@Select("select * from diary")
	public List<DiaryDTO> selectAll();
	
	@Select("select * from diary where no=#{no}")
	public DiaryDTO selectOne(int no);
	
	@Insert("insert into diary(no, title, writer, content) "
			+ "values (seq_diary.nextval, #{title}, #{writer}, #{content}")
	public void insert(DiaryDTO dto);
	
	@Delete("delete from diary where no=#{no}")
	public void delete(int no);
	
	@Update("update diary set title=#{title}, content=#{content} where no=#{no}")
	public void update(DiaryDTO dto);
}
