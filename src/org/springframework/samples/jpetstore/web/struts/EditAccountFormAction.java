package org.springframework.samples.jpetstore.web.struts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.springframework.samples.jpetstore.domain.Account;

public class EditAccountFormAction extends SecureBaseAction {
  
  protected ActionForward doExecute(ActionMapping mapping, ActionForm form,
          HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    // ��������ҳ�� EditAccountForm.jsp ʹ�õ� form ����Ϊ workingAcctForm
    AccountActionForm workingAcctForm = (AccountActionForm) form;
    
    // ʹ�ô��ڻỰ�еĶ�������ʼ��һЩֵ
    AccountActionForm acctForm = (AccountActionForm) request.getSession().
            getAttribute("accountForm");
    
    String username = acctForm.getAccount().getUsername();
    
    if (workingAcctForm.getAccount() == null) {
      Account account = getPetStore().getAccount(username);
//      acctForm.getAccount().setDisplayMylist(
//              request.getParameter("account.displayMylist") != null);
//      acctForm.getAccount().setDisplayBanner(
//              request.getParameter("account.displayBanner") != null);
      
      workingAcctForm.setAccount(account);
    }
    
    if (workingAcctForm.getCategories() == null) {
      List categories = getPetStore().getCategoryList();
      workingAcctForm.setCategories(categories);
    }
    
    // added by pprun
    String bannerName = getPetStore().getBannerNameForUser(username);
    if (bannerName != null) {
      workingAcctForm.setBannerName(bannerName);
    }
    
    String categoryName = acctForm.getFavCategoryName();
    if (categoryName != null) {
      workingAcctForm.setFavCategoryName(categoryName);
    }
    
    return mapping.findForward("success");
  }
  
}
