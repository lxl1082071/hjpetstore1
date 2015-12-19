package org.springframework.samples.jpetstore.web.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * ���а�ȫ��صĲ����������޸��ʻ���Ϣ���鿴���ʻ�����Ϣ�ȣ�
 * ����֮ǰ�����ȵ�¼�������� Action ��Ҫ����������أ����û�е�¼�Ļ���
 * ���ȼ�ס��ǰҪ���еĶ�����Ȼ���ȳ��ֵ�¼���棬���ɹ���¼��
 * ����ת������Ҫȥ�Ľ���.
 */
public abstract class SecureBaseAction extends BaseAction {
  
  public ActionForward execute(ActionMapping mapping, ActionForm form,
          HttpServletRequest request, HttpServletResponse response)
          throws Exception {
    
    AccountActionForm acctForm = (AccountActionForm) request.getSession().
            getAttribute("accountForm");
    if (acctForm == null || acctForm.getAccount() == null) {
      String url = request.getServletPath();
      String query = request.getQueryString();
      
      if (query != null) {
        // �磺��http://localhost:8084/jpetstore/shop/viewOrder.do?id=1000
        request.setAttribute("signonForwardAction", url+"?"+query);
        
      } else {
        request.setAttribute("signonForwardAction", url);
      }
      
      return mapping.findForward("global-signon");
      
    } else {
      return doExecute(mapping, form, request, response);
    }
  }
  
  protected abstract ActionForward doExecute(ActionMapping mapping,
          ActionForm form, HttpServletRequest request,
          HttpServletResponse response) throws Exception;
  
}
