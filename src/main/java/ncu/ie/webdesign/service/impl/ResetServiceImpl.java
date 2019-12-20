package ncu.ie.webdesign.service.impl;

import ncu.ie.webdesign.dao.impl.*;
import ncu.ie.webdesign.service.ResetService;

public class ResetServiceImpl implements ResetService {

    @Override
    public Boolean resetUserNameCheck(String userName, String newUserName) {
        UserInfoDAOImpl uerDAO=new UserInfoDAOImpl();
        int result=uerDAO.resetUserName(userName,newUserName);
        return result==1;
    }

    @Override
    public Boolean resetPasswordCheck(String userName, String email,String newPassword) {
        UserInfoDAOImpl uerDAO=new UserInfoDAOImpl();
        AccountDAOImpl accountDAO=new AccountDAOImpl();
        boolean result=uerDAO.userCheck(userName,email);
        if(result)
        {
            int flag=accountDAO.resetPassword(email,newPassword);
            if(flag==1)
            {
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    @Override
    public Boolean resetJobCategoryCheck(String newJobCategory, String userName) {
        UserInfoDAOImpl uerDAO=new UserInfoDAOImpl();
        int result=uerDAO.resetJobCategory(userName,newJobCategory);
        return result == 1;
    }

    @Override
    public Boolean resetPhoneNumCheck(String newPhoneNum,String userName) {
        UserInfoDAOImpl uerDAO=new UserInfoDAOImpl();
        int result=uerDAO.resetPhoneNum(newPhoneNum,userName);
        if(result==1)
        {
            return true;
        }
        else
            return false;
    }
}
