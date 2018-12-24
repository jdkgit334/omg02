package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.User;
import utils.DBUtil;

public class UserValidator {

    public static List<String> validate(User u, Boolean code_duplicate_check_flag, Boolean password_check_flag) {
        List<String> errors = new ArrayList<String>();

        String code_error = _validateCode(u.getCode(), code_duplicate_check_flag); //ユーザーIDの入力チェックを行い、エラーがある場合はその内容を配列errorsに入れる
        if(!code_error.equals("")) {
            errors.add(code_error);
        }

        String name_error = _validateName(u.getName()); //ユーザー名が一致しない場合は「ユーザー名を入力してください」を配列errorsに入れる
        if(!name_error.equals("")) {
            errors.add(name_error);
        }

        String password_error = _validatePassword(u.getPassword(), password_check_flag); //パスワードが一致しない場合は「パスワードを入力してください」を配列errorsに入れる
        if(!password_error.equals("")) {
            errors.add(password_error);
        }

        return errors; //エラー内容をまとめて返す(エラーがないものは空欄が返される)
    }

    private static String _validateCode(String code, Boolean code_duplicate_check_flag) {
        if(code == null || code.equals("")) {
            return "ユーザーIDを入力してください。";
        }

        if(code_duplicate_check_flag) { //boolean型の初期値はfalse
            EntityManager em = DBUtil.createEntityManager();
            long users_count = (long)em.createNamedQuery("checkRegisteredCode", Long.class).setParameter("code", code).getSingleResult();
            em.close();
            if(users_count > 0) {
                return "入力されたユーザーIDは既に存在しています。";

            }
        }

        return "";

    }


    private static String _validateName(String name) {
        if(name == null || name.equals("")) {
            return "ユーザー名を入力してください。";
        }

        return "";

    }

    private static String _validatePassword(String password, Boolean password_check_flag) {
        if(password_check_flag && (password == null || password.equals(""))) {
            return "パスワードを入力してください。";
        }
        return "";
    }
}































