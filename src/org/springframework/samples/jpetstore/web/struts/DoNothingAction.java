package org.springframework.samples.jpetstore.web.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.util.WebUtils;

public class DoNothingAction extends BaseAction {
  
  /* Public Methods */
  
  public ActionForward execute(ActionMapping mapping, ActionForm form,
          HttpServletRequest request, HttpServletResponse response) throws Exception {
    // �Ƿ��Ǵ� Spring web ��������
    if (request.getParameter("invalidate") != null
            && request.getParameter("invalidate").toString().equals("true")) {
      // ����ǣ���Ч session
      request.getSession().invalidate();
    }
    
    return mapping.findForward("success");
  }
}
