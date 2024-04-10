package lesson;

import java.util.HashMap;
import java.util.Map;

class Vycheslav {
    public static void main(String[] args) {
        Vycheslav vycheslav = new Vycheslav();
        //I - 1
        //V - 5
        //X - 10
        System.out.println(vycheslav.vycheslavToInt("V"));
        System.out.println(vycheslav.vycheslavToInt2("VI"));
        System.out.println(vycheslav.vycheslavToInt2("VII"));
        System.out.println(vycheslav.vycheslavToInt2("IX"));
        System.out.println(vycheslav.vycheslavToInt2("XIV"));
        System.out.println(vycheslav.vycheslavToInt2("XXXIV"));
    }

    public int getArabian(char vycheslav){
        if('I' == vycheslav) return 1;
        else if('V' == vycheslav) return 5;
        else if('X' == vycheslav) return 10;
        else if('L' == vycheslav) return 50;
        else if('C' == vycheslav) return 100;
        else if('D' == vycheslav) return 500;
        else if('M' == vycheslav) return 1000;
        return 0;

    }
    public int vycheslavToInt(String s) {



        int end = s.length()-1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = getArabian(arr[end]);
        for (int i = end-1; i >=0; i--) {
            arabian = getArabian(arr[i]);

            if (arabian < getArabian(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }


        }
        return result;

    }

    public int vycheslavToInt2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);



        int end = s.length()-1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = map.get(arr[end]);
        for (int i = end-1; i >=0; i--) {
            arabian = map.get(arr[i]);

            if (arabian < map.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }


        }
        return result;

    }


}