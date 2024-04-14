package org.example;


import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {

        String str1 = "aabcccbbad";
//        String str1 = "aabccbcbbad";
        String str2 = "abcccbad";
//        String str2 = "abcccbadddd";
        if (StringUtils.isEmpty(str1)) return;
        stage1(str1,3);

        if (StringUtils.isEmpty(str2)) return;
        stage2(str2,3);
    }

    private static void stage2(String str, int num) {
        if(num <= 1){
            num = 2;
        }
        int i = 0;//后一个指针
        int j = 0;//前一个指针
        int index = 0;//记载相同的字符数
        StringBuilder sb = new StringBuilder(str);
        while (i < sb.length() && j < sb.length() && sb.length() >= 3) {
            while (i < sb.length() && j < sb.length() && sb.charAt(i) == sb.charAt(j)) {
                index++;//相同字符相加
                j++;
            }
            //如果三个字符相同右指针覆盖左指针
            if (index > 1) {
                if(index >= num){
                    char c = sb.charAt(i);
                    String substring = sb.toString().substring(i, j);
                    char previousChar = getPreviousChar(c);
                    if(previousChar == 'z'){
                        sb.delete(i, j);
                        System.out.println(sb);
                    }else {
                        sb.replace(i, j,String.valueOf(previousChar));
                        System.out.println(sb + " , " + substring + " is replaced by " + previousChar);
                    }

                    i = 0;
                    j = 0;
                    index = 0;//相同字符归零
                }else {
                    i = j;
                    index = 0;//相同字符归零
                }
            } else {//不相同
                i++;
            }
        }
    }

    public static char getPreviousChar(char ch) {
        if (ch <= 'a') {
            return 'z'; // 如果是首字符，返回集合的最后一个字符
        }
        return (char) (ch - 1); // 否则返回前一个字符
    }

    private static void stage1(String str, int num) {
        if(num <= 1){
            num = 2;
        }
        int i = 0;//后一个指针
        int j = 0;//前一个指针
        int index = 0;//记载相同的字符数
        StringBuilder sb = new StringBuilder(str);
        while (i < sb.length() && j < sb.length()) {
            while (i < sb.length() && j < sb.length() && sb.charAt(i) == sb.charAt(j)) {
                index++;//相同字符相加
                j++;
            }
            //如果三个字符相同右指针覆盖左指针，右指针比左指针+1
            if (index > 1) {
                if(index >= num){
                    sb.delete(i, j);
                    System.out.println(sb);
                    i = 0;
                    j = 0;
                    index = 0;//相同字符归零
                }else {
                    i = j;
                    index = 0;//相同字符归零
                }
            } else {//不相同
                i++;
            }
        }
    }
}