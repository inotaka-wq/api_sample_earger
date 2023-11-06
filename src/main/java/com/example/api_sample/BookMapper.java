package com.example.api_sample;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

@Mapper
public interface BookMapper {
	@Select("SELECT id, name, page_count, author_id FROM book WHERE id=#{id}")
	Book getById(Integer id);

	@Results(id = "allbook", value = {
			@Result(
				property = "author", 
				many = @Many(select = "com.example.api_sample.AuthorMapper.getById", 
				fetchType = FetchType.EAGER), column = "authorId") })
	@Select("SELECT id, name, page_count AS pageCount, author_id AS authorId FROM book")
	List<Book> findAll();
}
