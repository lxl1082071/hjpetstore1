package org.springframework.samples.jpetstore.web.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.springframework.samples.jpetstore.domain.Order;

public class NewOrderAction extends SecureBaseAction {
  
  protected ActionForward doExecute(ActionMapping mapping, ActionForm form,
          HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (!isTokenValid(request, false)) {
      // ����ͬһ�����ƣ�Ϊ�����ύ
      //resetToken(request); // �ж��겻�Զ����٣�����������߼�����
      
      request.setAttribute("message", "�����ύ��");
      
      request.getSession().removeAttribute("workingOrderForm");
      request.getSession().removeAttribute("cartForm");
      
      // Fixed by pprun for duplicate-submit and bug in the next time submit:
      // ��Ȼ������Ҫȷ���ˣ�
      request.getSession().removeAttribute("orderForm");
      
      return mapping.findForward("failure");
    } else {
      // ��ҳ��
      OrderActionForm orderForm = (OrderActionForm) form;
      // �Ƿ�Ҫ�����ѡ�� shipingAddress ҳ��
      if (orderForm.isShippingAddressRequired() && 
              orderForm.getStep().equals("1")) {
        // ��Ҫ����Ʒ�ĸ����ˣ��������Լ�
        return mapping.findForward("shipping");
        
        // ���������
        // 1. ��ҳ��1ֱ�ӽ���ȷ��ҳ�棨����Ҫ�ĵ���ͬ�ĵ�ַʱ��
        // 2. �� shipingAddress ���뵽ȷ��ҳ��
      } else if ((orderForm.getStep().equals("1") && 
              orderForm.isShippingAddressRequired() == false) || 
                    orderForm.getStep().equals("2")) {
        // ����ȷ��ҳ��
        return mapping.findForward("confirm");
        
      } else if (orderForm.getOrder() != null) {
        // ���մ���
        
        // ����������(���ڴ˴����ʼ������Ҫ��
        // �Ա�֤�����ٿ�Ķ����ύ����õ���Ч���жϵ�)
        resetToken(request);
        
        Order order = orderForm.getOrder();
        // todo ����߼�Ӧ�÷��� DAO �㣿
        
        getPetStore().insertOrder(order);
        // �ɹ����к��Ƴ��Ự״̬��
        // �Ա� NewOrderFormAction �м����Ƿ��û����˲���
        request.getSession().removeAttribute("workingOrderForm");
        request.getSession().removeAttribute("cartForm");
        
        // Fixed by pprun for duplicate-submit and bug in the next time submit:
        // ��Ȼ������Ҫȷ���ˣ����Ա����Ƴ���
        request.getSession().removeAttribute("orderForm");
        
        request.setAttribute("order", order);
        request.setAttribute("message", "Thank you, your order has been submitted.");
        
        // ѡ�� ViewOrder.jsp �е���ʾ��ʽ
        request.setAttribute("newOrder", true);
        return mapping.findForward("success");
      } else {
        request.setAttribute("message", "An error occurred processing your order (order was null).");
        return mapping.findForward("failure");
      }
    }
  }
  
}
