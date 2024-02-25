public class ValidatorException {

    public static boolean validatorException(String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {
        try {
            if (login == null || password == null || confirmPassword == null) {
                throw new WrongPasswordException("Поля не могут быть пустыми");
            }

            if (login.length() >= 20) {
                throw new WrongLoginException("Длина pлогина должна быть меньше 20 символов");
            }

            if (password.length() >= 20) {
                throw new WrongPasswordException("Длина пароля должна быть меньше 20 символов");
            }

            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают");
            }
            return true;
        }

        catch (WrongPasswordException e) {
            System.out.println("Ошибка валидации пароля: " + e.getMessage());
            return false;
        }
    }
}
