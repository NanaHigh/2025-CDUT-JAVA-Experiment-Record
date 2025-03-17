package Ex7;

import java.lang.System;
import java.lang.String;
import java.util.Scanner;

public class ex7_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入一个数字：");
        String amount = input.nextLine();
        input.close();
        String[] parts = amount.split("\\.");
        char[] d = {'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
        String[] u = {"", "拾", "佰", "仟"}, s = {"", "万", "亿"};
        
        // 处理整数部分
        StringBuffer sb = new StringBuffer();
        String integer = parts[0];
        for (int i = 0, len = integer.length(); i < len; i++) {
            int num = integer.charAt(i) - '0';
            int pos = (len - i - 1) % 4;
            if (num != 0) {
                sb.append(d[num]).append(u[pos]);
            } else if (sb.length() > 0 && sb.charAt(sb.length()-1) != '零') {
                sb.append(d[0]);
            }
            // 每4位添加节单位
            if (pos == 0 && i != len-1) {
                sb.append(s[(len - i - 1)/4]);
                if (sb.charAt(sb.length()-2) == '零') sb.deleteCharAt(sb.length()-2);
            }
        }
        String res = sb.toString().replaceAll("零+$", "").replaceAll("零+", "零") + "元";

        // 处理小数部分
        String decimal = parts.length > 1 ? parts[1] : "00";
        if (decimal.length() < 2) decimal += "0";
        if (!decimal.equals("00")) {
            res += (decimal.charAt(0) > '0' ? d[decimal.charAt(0)-'0'] + "角" : "") +
                   (decimal.charAt(1) > '0' ? (decimal.charAt(0)=='0' ? "零" : "" + d[decimal.charAt(1)-'0'] + "分") : "");
        } else {
            res += "整";
        }
        System.out.println(res);
    }
}