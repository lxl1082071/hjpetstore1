package org.springframework.samples.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.jpetstore.domain.Product;

/**
 * ���ں�ԭ��� domain ����Ĳ�ͬ���������¶�����һ���ӿ�.
 */
public interface ProductDao {
  
  List getProductListByCategory(String categoryName) throws DataAccessException;
  
  List searchProductList(String keywords) throws DataAccessException;
  
  // �ı� DAO �Ľӿڣ�����һ��List������ product  �� categoryName
  // Ϊ���������: org.hibernate.LazyInitializationException:
  //               could not initialize proxy - the owning Session was closed
  // (��ҳ�� Product.jsp �� ${product.category.categoryName} ����).
  //
  // ��Ȼ���� "Open Session in View pattern" ģʽ, ��Ӧ Spring �м���
  // @see org.springframework.orm.hibernate3.support.OpenSessionInViewFilter
  // @see org.springframework.orm.hibernate3.support.OpenSessionInViewInterceptor
  // ���䲢���Ǹ�������Ӧ�õ���ѡ����
  // �������Ҫ�� many-to-one ��ϵ��һ�˼��뵽 request attribute, �Ա�ҳ���
  // ����.
  List getProduct(String productNumber) throws DataAccessException;
  
}
