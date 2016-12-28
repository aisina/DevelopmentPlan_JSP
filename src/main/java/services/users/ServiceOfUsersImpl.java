package services.users;

import pojo.User;

/**
 * Created by innopolis on 27.12.2016.
 */
public class ServiceOfUsersImpl implements ServiceOfUsers {

    /**
     * Метод проверяет корректность данных валидации входа.
     *
     * @param name имя пользователя.
     * @param password пароль пользователя.
     * @param user     пользователь для сверки данных.
     * @return Если валидация пройдена успешно будет возвращено значения пользователя для сессии, иначе возвращается null.
     */
    @Override
    public User validateLogin(String name, String password, User user) {
        // All parameters must be valid
        if (name == null || password == null){
            return null;
        }

        if (user == null){
            return null;
        }

        // Check if the password is valid
        if (!user.getPassword().equals(password.trim())){
            return null;
        }
        return user;
    }

    /**
     * Метод проверяет совпадение паролей.
     *
     * @param password пароль пользователя.
     * @param confirm  подтверждение пароля.
     * @return Если пароль и его подтверждение совпадают возвращается true, иначе false.
     */
    @Override
    public boolean checkPasswords(String password, String confirm) {
        boolean result = false;
        if (password != null && confirm != null && password.equals(confirm)) {
            result = true;
        }
        return result;
    }
}
