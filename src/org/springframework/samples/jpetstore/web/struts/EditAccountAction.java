package org.springframework.samples.jpetstore.web.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.samples.jpetstore.domain.Account;
import org.springframework.samples.jpetstore.domain.Category;

public class EditAccountAction extends SecureBaseAction {
  
  protected ActionForward doExecute(ActionMapping mapping, ActionForm form,
          HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    AccountActionForm acctForm = (AccountActionForm) form;
    if (AccountActionForm.VALIDATE_EDIT_ACCOUNT.equals(acctForm.getValidate())) {
      // checkBox �� Struts TAG �������
//      acctForm.getAccount().setDisplayMylist(
//              request.getParameter("account.displayMylist") != null);
//      acctForm.getAccount().setDisplayBanner(
//              request.getParameter("account.displayBanner") != null);
      
      Account account = acctForm.getAccount();
      
      // ע��Ҫ������Ĺ�������
      String favCategory = acctForm.getFavCategoryName();
      Category category = getPetStore().getCategory(favCategory);
      account.setFavCategory(category);
      
      // ���������Ϣ��ģ�Ͳ�
      getPetStore().updateAccount(account);
      
      // ���������������Ʋ㣬�Թ���ʾ����
      acctForm.setAccount(getPetStore().getAccount(account.getUsername()));
      
      // and ��Ӧ�� username, password
      acctForm.setUsername(account.getUsername());
      acctForm.setPassword(account.getPassword());
      
      // -- ��Ϊ����ı��˸���Ȥ�ĳ���Ļ�����Ҫ���½����ݳ�ʼ����
      // set myList
      if (request.getParameter("account.displayMylist") != null) {
        PagedListHolder myList = new PagedListHolder(
                getPetStore().getProductListByCategory(
                acctForm.getFavCategoryName()));
        myList.setPageSize(4);
        acctForm.setMyList(myList);
      }
      
      // set banner name
      if (request.getParameter("account.displayBanner") != null) {
        String bannerName = getPetStore().getBannerNameForUser("username");
        acctForm.setBannerName(bannerName);
      }
      
      request.getSession().setAttribute("accountForm", acctForm);
      
      // �޸��ʻ���Ϣ���˽�������˽� workingAcctForm ������ص�
      // accountForm ������.
      request.getSession().removeAttribute("workingAccountForm");
      return mapping.findForward("success");
    } else {
      request.setAttribute("message",
              "Your account was not updated because the submitted information" +
              " was not validated.");
      return mapping.findForward("failure");
    }
  }
  
}
