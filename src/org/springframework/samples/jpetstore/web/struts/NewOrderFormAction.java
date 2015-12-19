package org.springframework.samples.jpetstore.web.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.springframework.samples.jpetstore.domain.Account;

public class NewOrderFormAction extends SecureBaseAction {
  
  protected ActionForward doExecute(ActionMapping mapping, ActionForm form,
          HttpServletRequest request,
          HttpServletResponse response) throws Exception {
    // ʹ�� session �еĶ��� accountForm ��ʼ�����ֵ
    AccountActionForm acctForm =
            (AccountActionForm) request.getSession().getAttribute("accountForm");
    
    // ��Ϊ CartActionForm ��Account��Actionӳ����(struts-config.xml)�����ó�
    // session scope, ����ʹ�� getSession()
    CartActionForm cartForm =
            (CartActionForm) request.getSession().getAttribute("cartForm");
    
    if (cartForm != null) {
      OrderActionForm orderForm = (OrderActionForm) form;
      
      // Re-read account from DB at team's request. pprun: why?
      
      // ֻ���ڴ� checkout �������ʱ�� initOrder
      // ��Ϊ�ں�����ҳ��У������ֽ�ʹ����� Action, ���Ա��������жϣ�
      // ���򣬽����ظ��ѹ��ﳵ�е���Ʒ���� order ��
      if (request.getParameter("step") == null) {
        Account account =
                getPetStore().getAccount(acctForm.getAccount().getUsername());
        orderForm.getOrder().initOrder(account, cartForm.getCart());
      }
      
      // �����ظ��ύ
      saveToken(request);
      return mapping.findForward("success");
    } else {
      // �� NewOrderAction�гɹ����к�
      // �Ƴ��˻Ự״̬(cartForm)����˴˼����Ƿ����û������˰�ť������
      
      // ���� �ظ��ύʱ�Ĵ���
      // request.getSession().removeAttribute("workingOrderForm");
      // request.getSession().removeAttribute("cartForm");
      
      request.setAttribute("message", "An order could not be created because" +
              " a cart could not be found.");
      return mapping.findForward("failure");
    }
  }
  
}