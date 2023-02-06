package com.pigey.toodoolist.accounts.dataObjects;

import com.pigey.toodoolist.accounts.UserModel;
import com.pigey.toodoolist.accounts.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserModelDAO implements IUserModelDAO <UserModel> {

    private final UserModelRepository userModelRepository;

    @Autowired
    public UserModelDAO(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }

    @Override
    public UserModel findUser(String username){
        return userModelRepository.findByUsername(username);
    }

}
