package org.springframework.samples.jpetstore.dao.hibernate;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.samples.jpetstore.dao.OrderDao;
import org.springframework.samples.jpetstore.domain.Order;

public class HibernateOrderDao extends HibernateDaoSupport implements OrderDao {
  
  public List getOrdersByUsername(String username) throws DataAccessException {
    return getHibernateTemplate().find(
            "select order from Order order, Account user where " +
            "order.user.id = user.id and user.username = ?", username);
  }
  
  /**
   * �ı� DAO �ӿڣ�
   * Ϊ���ViewOrderAction �� order.getUser().getUsername() ����Ҫ����
   * �ֱ���ʹ�� open session in view ģʽ
   */
  public List getOrderAndUserName(long id) throws DataAccessException {
    Long orderId = new Long(id);
    
    List list =  getHibernateTemplate().find(
            "select o, o.user.username " +
            "from Order o " +
            "where o.id = ?", orderId);
    
    //Order order = (Order) getHibernateTemplate().load(Order.class, parameterObject);
    
    
    // todo: pp ��ӳ���ļ��������ˣ�fetch="join" lazy="false"������Ҫ������������
    // ���ǵĲ���Ҫ��
//        if (order != null) {
//            order.setLineItems(getHibernateTemplate().find(
//                    "from LineItem lineItem where lineItem.order = ?",
//                    new Long(order.getId())));
//        }
    return list;
  }
  
  public Order getOrder(int id) throws DataAccessException {
    Long parameterObject = new Long(id);
    Order order = (Order) getHibernateTemplate().load(Order.class, parameterObject);
    
    System.out.println(">>>>>>>>>>" + order);
    return order;
  }
  
  public void insertOrder(Order order) throws DataAccessException {
    // Hibernate do it for us
    // order.setId(this.sequenceDao.getNextId("ordernum"));
    
    getHibernateTemplate().persist(order);
    
    // ��Ϊԭ���ж���״̬��ֵ������һ������
    // getHibernateTemplate().insert("insertOrderStatus", order);
    
    // todo: PP ��ӳ���ļ��������ˣ�cascade="all-delete-orphan"������Ҫ������������
    // ���ǵģ�����Ҫ����Ϊ����֤�� LineItem �� Order �� update, insert, save
    // ��ͬʱ���г־û�����.
//    for (int i = 0; i < order.getLineItems().size(); i++) {
//      LineItem lineItem = (LineItem) order.getLineItems().get(i);
//      // todo: pp ��Ҫ�� Order �а�����ȫ��ʼ��
//      // lineItem.setOrder(order);
//      getHibernateTemplate().persist(lineItem);
//    }
  }
  
}
