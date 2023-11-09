package com.example.api_sample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

@Mapper
public interface BookMapper {
	@Select("SELECT id, name, page_count, author_id FROM book WHERE id=#{id}")
	Book getById(Integer id);

	@Results(id = "allbook", value = {
			@Result(property = "author", one = @One(select = "com.example.api_sample.AuthorMapper.getById", fetchType = FetchType.EAGER), column = "author_id") })
	@Select("SELECT id, name, page_count AS pageCount, author_id FROM book")
	List<Book> findAll();

	@Select("SELECT b.id, b.name, b.page_count,	b.author_id, a.id as \"author.id\",	a.first_name as \"author.first_name\",	a.last_name  as \"author.last_name\" "
			+ "FROM book b "
			+ "LEFT OUTER JOIN author a ON b.author_id = a.id")
	List<Book> findWithAuthors();
}
