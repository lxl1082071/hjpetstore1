package org.springframework.samples.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.jpetstore.domain.Order;

/**
 * ���ں�ԭ��� domain ����Ĳ�ͬ���������¶�����һ���ӿ�.
 */
public interface OrderDao {

  List getOrdersByUsername(String username) throws DataAccessException;

  List getOrderAndUserName(long id) throws DataAccessException;
  Order getOrder(int id) throws DataAccessException;
  void insertOrder(Order order) throws DataAccessException;

}
