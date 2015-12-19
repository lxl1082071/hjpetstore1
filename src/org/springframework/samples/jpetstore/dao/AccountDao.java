package org.springframework.samples.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.jpetstore.domain.Account;
/**
 * ���ں�ԭ��� domain ����Ĳ�ͬ���������¶�����һ���ӿ�.
 */
public interface AccountDao {

  Account getAccount(String username) throws DataAccessException;

  List getAccount(String username, String password) throws DataAccessException;

  // added by pprun
  String getBannerNameForUser(String username);
  
  void insertAccount(Account account) throws DataAccessException;

  void updateAccount(Account account) throws DataAccessException;

	List getUsernameList() throws DataAccessException;

}
