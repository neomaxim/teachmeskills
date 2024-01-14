package lesson32;

import lombok.Data;

import java.util.Map;

public class IsAuthenticatorUser {
    private String userName;
    private String password;

    public IsAuthenticatorUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    DataBase dataBase = new DataBase();

    final boolean isAuthenticUser(String userName, String password) {
        for (Map.Entry<String, String> pair : dataBase.getUserMap().entrySet()) {
            if (pair.getKey().equals(userName) && pair.getValue().equals(password))
                return true;
        }
        return false;
    }
}
