package com.pigey.toodoolist.accounts;

import com.pigey.toodoolist.accounts.dataObjects.UserModelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserModelService  implements UserDetailsService {

    private final UserModelDAO userModelDAO;

    @Autowired
    public UserModelService(UserModelDAO userModelDAO) {
        this.userModelDAO = userModelDAO;
    }

    @Override
    public UserModel loadUserByUsername(String username) throws UsernameNotFoundException{

        return userModelDAO.findUser(username);

    }
}
