package org.springframework.samples.jpetstore.web.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.springframework.samples.jpetstore.domain.Account;
import org.springframework.samples.jpetstore.domain.Address;

public class NewAccountFormAction extends BaseAction {
  
  public ActionForward execute(ActionMapping mapping, ActionForm form,
          HttpServletRequest request, HttpServletResponse response) throws Exception {
    // ���ڵ�¼��ע�������� AccountActionForm �Ľ����������Ҫ�ֹ����г�ʼ����
    // ������ͨ�� (AccountActionForm)form �õ�.
    // ��Ϊ��Ҫʹ��ע����û���Ϊ��ǰ�û���������֮ǰ�����ʻ���
    AccountActionForm workingAcctForm = new AccountActionForm();
    
    request.getSession().removeAttribute("workingAccountForm");
    request.getSession().setAttribute("workingAccountForm", workingAcctForm);
    
    if (workingAcctForm.getAccount() == null) {
      // PP: �����ʼ�� account �� address ���
      Account account = new Account();
      account.setUserAddr(new Address());
      workingAcctForm.setAccount(account);
    }
    
    // ���ĸ��ط��õ��������Ա? ��ѡ�����Ȥ�������б����õ��ˣ�
    if (workingAcctForm.getCategories() == null) {
      workingAcctForm.setCategories(getPetStore().getCategoryList());
    }
    return mapping.findForward("success");
  }
  
}
