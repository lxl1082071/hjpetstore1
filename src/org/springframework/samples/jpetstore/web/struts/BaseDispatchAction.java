/*
 * BaseDispatchAction.java
 *
 * Created on 2006��9��29��, ����1:09
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.springframework.samples.jpetstore.web.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author pprun
 */
public abstract class BaseDispatchAction extends BaseAction {
  public ActionForward execute(
          ActionMapping mapping,
          ActionForm form,
          HttpServletRequest request,
          HttpServletResponse response)
          throws Exception {
    
    ActionMessages am = getMessages(request);
    String parameter = mapping.getParameter();
    String name = request.getParameter(parameter);
    
    if (null == name) { //���û��ָ�� method ����Ĭ��Ϊ list
      name = "list";
    }
    
    if ("add".equals(name)) {
      if ("add".equals(name)) {
        saveToken(request);
      }
    } else if ("insert".equals(name)) {
      if (!isTokenValid(request, true)) {
        resetToken(request);
        
        // �����ύ
        am.add(ActionErrors.GLOBAL_MESSAGE, 
                new ActionMessage("error.transaction.token"));
        
        return mapping.findForward("error");
      }
    }
    
    return mapping.findForward("success");
  }
}
