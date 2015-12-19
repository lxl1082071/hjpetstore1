package org.springframework.samples.jpetstore.web.struts;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.springframework.samples.jpetstore.domain.CartItem;

public class UpdateCartQuantitiesAction extends BaseAction {
  
  public ActionForward execute(ActionMapping mapping, ActionForm form, 
          HttpServletRequest request, HttpServletResponse response) throws Exception {
    CartActionForm cartForm = (CartActionForm) form;
    Iterator cartItems = cartForm.getCart().getAllCartItems();
    
    while (cartItems.hasNext()) {
      CartItem cartItem = (CartItem) cartItems.next();
      String itemName = cartItem.getItem().getItemName();
      
      try {
        // ���� request.getParameter(itemName) �õ��ӱ��ύ�Ķ�Ӧ�� itemName ������
        int quantity = Integer.parseInt(request.getParameter(itemName));
        cartForm.getCart().setQuantityByItemName(itemName, quantity);
        if (quantity < 1) {
          cartItems.remove();
        }
      } catch (NumberFormatException e) {
        //ignore on purpose
        // �������Ĳ���һ����Ч�ĺϷ����֣�����
      }
    }
    return mapping.findForward("success");
  }
  
}
