package com.dev118.jexample.spring.bean.api;

import java.util.List;

import com.dev118.jexample.spring.bean.BookEntity;

/**
 * 图书服务
 * 
 * @author Wen
 *
 */
public interface BookService {

	/**
	 * 数据初始化
	 */
	public void init();

	/**
	 * 添加一本图书
	 * 
	 * @param bookEntity
	 */
	public void add(BookEntity bookEntity);

	/**
	 * 删除一本图书信息
	 * 
	 * @param id
	 */
	public void remove(Integer id);

	/**
	 * 修改一本图书信息
	 * 
	 * @param bookEntity
	 */
	public void update(BookEntity bookEntity);

	/**
	 * 查询一本图书信息
	 * 
	 * @param id
	 * @return
	 */
	public BookEntity findOne(Integer id);

	/**
	 * 查询所有图书信息
	 * 
	 * @return
	 */
	public List<BookEntity> findAll();

}
