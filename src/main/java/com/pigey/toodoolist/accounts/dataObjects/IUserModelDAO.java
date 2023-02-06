package com.pigey.toodoolist.accounts.dataObjects;

import java.util.List;

public interface IUserModelDAO <T>{
    T findUser(String username);

}
