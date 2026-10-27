package scr;

import java.util.*;

public class B1 {
    public static String normalizecode(String s){
        if(s==null){
            throw new IllegalArgumentException("code không được để rỗng");
        }
        String code=s.trim().toUpperCase();
        if(!code.matches("[A-Z0-9-]{3,20}"))
            throw new IllegalArgumentException(("code" + s + " không đáp ứng định dạng"));
        return code;
    }
    public static void test(String s){
        try {
            System.out.println("code: "+ s +" -> "+ normalizecode(s));
        }
        catch (IllegalArgumentException e){
            System.out.println("code: "+s+" bị lỗi :" + e.getMessage());
        }
    }

    static void main(String[] args) {
        test(" p-01 ");
        test("ab1");
        test("P1");
        test("P 01");
        //case bien
        test(null);
        test("     ");
        test("ddddddaaaaaaddadadadadadadaa");
        test("#!@");
    }
}
