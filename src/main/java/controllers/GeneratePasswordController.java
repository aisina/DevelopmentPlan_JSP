package controllers;

import GenerateHashPassword.PasswordSalt;

/**
 * Created by innopolis on 28.12.2016.
 */
public class GeneratePasswordController {

    public String generatePass(String str){
        return PasswordSalt.md5Custom(str);
    }
}
