package pass.Company.Cisco;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class decodeString {
    public static void main(String[] args) throws IOException{
        decodeString();
    }
    private static void decodeString(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<String> letterStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        String temp = "";
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = s.charAt(i) - '0';
                while(i + 1 < s.length() && Character.isDigit(i + 1)){
                    num = num * 10 + num;
                    i++;
                }
                numStack.push(num);
            }else if(Character.isLetter(s.charAt(i))){
                temp += s.charAt(i);
            }else if(s.charAt(i) == '{'){
                letterStack.push(temp);
                temp = "";
            }else if(s.charAt(i) == '}'){
                StringBuilder sb = new StringBuilder(letterStack.pop());
                int n = numStack.pop();
                for(int j = 0; j < n; j++){
                    sb.append(temp);
                }
                temp = sb.toString();
            }
        }
        System.out.print(temp);
    }
}
