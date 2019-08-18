package lsieun.ss;

import java.util.Map;

import lsieun.utils.SSUtils;

public class A_SS_Single {
    public static void main(String[] args) {
        String ss = "ss://YWVzLTI1Ni1jZmI6UW96enV6THMyVzMyQDIxMS43NS43OS4yMzM6MTY1MDU=";
        Map<String, String> map = SSUtils.parse(ss);
        System.out.println(map);
    }
}
