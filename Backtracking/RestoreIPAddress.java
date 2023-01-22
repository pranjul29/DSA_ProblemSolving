/* 
Source: https://leetcode.com/problems/restore-ip-addresses/description/
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 
Constraints:

1 <= s.length <= 20
s consists of digits only.
*/
import java.util.*;
public class RestoreIPAddress {
    static List<String> results;
    static void generateIpAddress(int index,String s,int number,StringBuffer str)
    {
        if(index == s.length() && number == 4)
        {
            results.add(new String(str.toString()));
            return;
        }
        if((index == s.length() && number < 4) || (number == 4 && index < s.length()))
            return;
        for(int i = 1;i<=3 && (index+i) <= s.length();i++)
        {
            String temp_str = s.substring(index,index+i);
            int temp = Integer.parseInt(temp_str);
            if((temp != 0 && temp_str.charAt(0) == '0') || (temp_str.equals("00") || temp_str.equals("000")))
                continue;
            if(temp <= 255)
            {
                str.append(temp_str);
                if(number < 3)
                    str.append(".");
                generateIpAddress(index+i,s,number+1,str);
                for(int j = 0;j<i;j++)
                    str.deleteCharAt(str.length()-1);
                if(number < 3)
                    str.deleteCharAt(str.length()-1);
            }
        }
    }
    public static List<String> restoreIpAddresses(String s) {
        results = new ArrayList<String>();
        StringBuffer temp = new StringBuffer("");
        generateIpAddress(0,s,0,temp);
        return results;
    }
    public static void main(String[] args) {
        String s = new String("101023");
        System.out.println(restoreIpAddresses(s));
    }
}
