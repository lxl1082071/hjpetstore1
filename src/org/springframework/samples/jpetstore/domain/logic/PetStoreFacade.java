package org.springframework.samples.jpetstore.domain.logic;

import java.util.List;

import org.springframework.samples.jpetstore.domain.Account;
import org.springframework.samples.jpetstore.domain.Category;
import org.springframework.samples.jpetstore.domain.Item;
import org.springframework.samples.jpetstore.domain.Order;

/**
 * JPetStore primary business interface.
 *
 * @author Juergen Hoeller
 * @since 30.11.2003
 */
public interface PetStoreFacade {
  
    /**
     * 
     * @param username 
     * @return 
     */
  Account getAccount(String username);
  
  List getAccount(String username, String password);
  
  // added by pprun
  String getBannerNameForUser(String username);
  void insertAccount(Account account);
  
  void updateAccount(Account account);
  
  List getUsernameList();
  
  
  List getCategoryList();
  
  Category getCategory(String categoryName);
  
  
  List getProductListByCategory(String categoryName);
  
  List searchProductList(String keywords);
  
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
  List getProduct(String productNumber);
  
  
  List getItemListByProduct(String productNumber);
  
  List getItem(String itemName);
  
  // added by pprun
  int getItemQuantity(String itemName);
  List getItem(Item item);
  boolean isItemInStock(String itemName);
  
  
  void insertOrder(Order order);
  
  Order getOrder(int id);
  List getOrderAndUserName(long id);
  List getOrdersByUsername(String username);
  
}
