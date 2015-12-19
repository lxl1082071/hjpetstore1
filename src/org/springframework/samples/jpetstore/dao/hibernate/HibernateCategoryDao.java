package org.springframework.samples.jpetstore.dao.hibernate;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.samples.jpetstore.dao.CategoryDao;
import org.springframework.samples.jpetstore.domain.Category;

/**
 * domain �����巢���˸ı䣬categoryId ����Ϊ�� categoryName �ظ����У�����
 * �� hibernate �Զ�ά����ֵ�����ԭ�ȵ� categoryId ������ categoryName ͬ.
 */
public class HibernateCategoryDao extends HibernateDaoSupport implements CategoryDao {
  
  public List getCategoryList() throws DataAccessException {
    // todo: now not retrive id
    return getHibernateTemplate().find(
            "from Category");
  }
  
  /**
   * todo: pp, renamed categoryId to categoryName
   */
  public Category getCategory(String categoryName) throws DataAccessException {
    Category category = null;
    
    List ls = getHibernateTemplate().find(
            "from Category cat where cat.categoryName = ?", categoryName);
    
    if (ls != null && ls.size() > 0) {
      category =  (Category) ls.get(0);
    }
    
    return category;
  }
}
