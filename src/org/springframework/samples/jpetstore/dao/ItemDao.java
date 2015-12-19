package org.springframework.samples.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.jpetstore.domain.Item;
import org.springframework.samples.jpetstore.domain.Order;

/**
 * ���ں�ԭ��� domain ����Ĳ�ͬ���������¶�����һ���ӿ�.
 */
public interface ItemDao {
  
  public void updateQuantity(Order order) throws DataAccessException;
  
  boolean isItemInStock(String itemName) throws DataAccessException;
  
  List getItemListByProduct(String productNumber) throws DataAccessException;
  
  List getItem(String itemName) throws DataAccessException;
  
  // added by pprun
  List getItem(Item item) throws DataAccessException;
  int getItemQuantity(String itemName) throws DataAccessException;
}
