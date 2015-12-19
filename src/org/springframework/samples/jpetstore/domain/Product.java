/*
 * Product.java
 *
 * Created on 2006��10��1��, ����8:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.springframework.samples.jpetstore.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * domain �����巢���˸ı䣬productId ���� productNumber���� productId ����
 * �� hibernate �Զ�ά���� id ֵ�����ԭ�ȵ� productId ������ productNumber ͬ.
 * @author pprun
 */
public class Product implements java.io.Serializable, Comparable {
  private Long id;
  private int version;
  private String productNumber;
  private Category category;
  private String productName;
  private String productDesc;
  
  // @OneToMany(mappedBy = "product")
  private Set<Item> items = new HashSet<Item>();
  
  /** Creates a new instance of Product */
  public Product() {
  }
  
  public Long getId() {
    return id;
  }
  
  public int getVersion() {
    return version;
  }
  
  public String getProductNumber() {
    return productNumber;
  }
  
  public void setProductNumber(String productNumber) {
    this.productNumber = productNumber;
  }
  
  public Category getCategory() {
    return category;
  }
  
  public void setCategory(Category category) {
    this.category = category;
  }
  
  public String getProductName() {
    return productName;
  }
  
  public void setProductName(String productName) {
    this.productName = productName;
  }
  
  public String getProductDesc() {
    return productDesc;
  }
  
  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }
  
  public Set getItems() {
    return items;
  }
  
  public void setItems(Set<Item> items) {
    this.items = items;
  }
  
  // scaffold code for collection field
  public void addItem(Item item) {
    if (item == null)
      throw new IllegalArgumentException("Can't add a null Item.");
    this.getItems().add(item);
  }
  
  // -- common methods
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    
    if (!(o instanceof Product)) {
      return false;
    }
    
    final Product product = (Product) o;
    if(!getProductNumber().equals(product.getProductNumber())) return false;
    if (!getProductName().equals(product.getProductName())) return false;
    
    return true;
  }
  
  public int hashCode() {
    return getProductNumber().hashCode();
  }
  
  /**
   * Ϊ���⡡org.hibernate.LazyInitializationException
   * �� common methods �в�Ҫʹ�ù������õĶ���ĳ�Ա��
   */
  public String toString() {
    return  "Product (" + getProductNumber() + "), " +
            "Name: " + getProductName();
    
    // �������ù����������ⲻ��Ҫ��
    // org.hibernate.LazyInitializationException
    //        "Category: " + getCategory();
  }
  
  public int compareTo(Object o) {
    if (o instanceof Product) {
      return getProductNumber().compareTo(((Product)o).getProductNumber());
    }
    
    return 0;
  }
// --
}
