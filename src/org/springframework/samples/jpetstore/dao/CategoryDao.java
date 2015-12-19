package org.springframework.samples.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.jpetstore.domain.Category;


/**
 * ���ں�ԭ��� domain ����Ĳ�ͬ���������¶�����һ���ӿ�.
 */
public interface CategoryDao {
  
  List getCategoryList() throws DataAccessException;
  
  Category getCategory(String categoryName) throws DataAccessException;
  
}
