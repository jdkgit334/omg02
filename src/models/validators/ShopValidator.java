package models.validators;


import java.util.ArrayList;
import java.util.List;

import models.Shop;

public class ShopValidator {
    public static List<String> validate(Shop s) {
        List<String> errors = new ArrayList<String>();

        String address_error = _validateAddress(s.getAddress());
        if(!address_error.equals("")) {
            errors.add(address_error);
        }

        String name_error = _validateName(s.getName());
        if(!name_error.equals("")) {
            errors.add(name_error);
        }

        String holiday_error = _validateHoliday(s.getHoliday());
        if(!holiday_error.equals("")) {
            errors.add(holiday_error);
        }

        String open_at1_error = _validateOpen_at1(s.getOpen_at1());
        if(!open_at1_error.equals("")) {
            errors.add(open_at1_error);
        }

        String close_at1_error = _validateClose_at1(s.getClose_at1());
        if(!close_at1_error.equals("")) {
            errors.add(close_at1_error);
        }

        String open_at2_error = _validateOpen_at2(s.getOpen_at2());
        if(!open_at2_error.equals("")) {
            errors.add(open_at2_error);
        }

        String close_at2_error = _validateClose_at2(s.getClose_at2());
        if(!close_at2_error.equals("")) {
            errors.add(close_at2_error);
        }


        return errors;
    }





    private static String _validateName(String name) {
        if(name == null || name.equals("")) {
            return "店名を入力してください。";
        }

        return "";
    }


    private static String _validateHoliday(String holiday) {
        if(holiday == null || holiday.equals("")) {
            return "定休日を入力してください。";
            }

        return "";
    }

    private static String _validateOpen_at1(String open_at1) {
        if(open_at1 == null || open_at1.equals("")) {
            return "開店時間(平日)を入力してください。";
            }

        return "";
    }

    private static String _validateClose_at1(String close_at1) {
        if(close_at1 == null || close_at1.equals("")) {
            return "閉店時間(平日)を入力してください。";
            }

        return "";
    }


    private static String _validateOpen_at2(String open_at2) {
        if(open_at2 == null || open_at2.equals("")) {
            return "開店時間(休日)を入力してください。";
            }

        return "";
    }


    private static String _validateClose_at2(String close_at2) {
        if(close_at2 == null || close_at2.equals("")) {
            return "閉店時間(休日)を入力してください。";
            }

        return "";
    }

    private static String _validateAddress(String address) {
        if(address == null || address.equals("")) {
            return "住所を入力してください。";
        }

        return "";
    }


}