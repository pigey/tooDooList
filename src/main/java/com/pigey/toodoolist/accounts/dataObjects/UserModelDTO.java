package com.pigey.toodoolist.accounts.dataObjects;

import com.pigey.toodoolist.accounts.UserModel;

public class UserModelDTO {


    private final String username;



    public UserModelDTO(UserModel userModel) {
        this.username = userModel.getUsername();
    }

    public String getUsername() {
        return username;
    }

}
