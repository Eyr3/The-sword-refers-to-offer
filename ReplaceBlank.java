/**
 * Created by Eyr3 on 2018/4/10.
 * 题目：将字符串中空格替换成%20
 * 测试用例：字符串为NULL指针，字符串由一个（连续多个）空格字符
 * 思路：设两个指针P1,P2，分别指向原始字符串末、替换后字符串末，向前移动，P1对P2赋值，除非遇到空格
 * O(N)+O(1)
 * tips：Java字符串末尾无结束符'\0';
 *      合并两个数组，从后往前复制，可减少移动次数
 *      注意内存覆盖
 */
public class ReplaceBlank {
    public static String replaceSpace(StringBuffer str){
        int len  = str.length();
        for(int i = 0; i < len; i++){
            if(str.charAt(i) == ' ') {
                //charAt(i)可以让字符串像数组一样使用，" "为java.lang.String
                str.append("  ");
            }
        }
        int pofold = len - 1;
        int pofnew = str.length() - 1;
        while (pofold >= 0 && pofold != pofnew){
            char c = str.charAt(pofold);
            if(c != ' '){
                str.setCharAt(pofnew--, c);
            }
            else {
                str.setCharAt(pofnew--, '0');
                str.setCharAt(pofnew--, '2');
                str.setCharAt(pofnew--, '%');
                //注意""与''的区别
            }
            pofold--;
        }
        return str.toString();
    }

    public static void main(String[] args){
        String str = "I love Eyr3!";
        //String -> StringBuffer 方法一 构造new; 方法二 append()方法
        StringBuffer strb = new StringBuffer(str);
        //StringBuffer strb2 = new StringBuffer(str); strb2.append(str);
        //StringBuffer->String 方法一 构造new; 方法二 toString()方法
        System.out.println(replaceSpace(strb));
        //目前理解：String->StringBuffer == 字符数组
    }
}
