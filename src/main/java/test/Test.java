package test;

import org.apache.commons.lang3.StringUtils;
import test.dongtaiProxy.CheckTicket;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Stack;

public class Test {
    public static void main(String[] args){
        /*TicketService service = new BuyTicket();
        TicketService proxy = new BuyTicketProxy(service);
        CheckTicket checkTicket = new CheckTicket(new BuyTicket());
        //proxy.buy();
        TicketService o = (TicketService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), checkTicket);
        o.buy();*/
        //1.交换
        /*int[] a  = {0, 0, 1, 0, 1, 0, 1, 0, 0, 1};
        sort(a);*/
        //2.复制
        /*char[] chars = new char[]{'a', 'b', 'c', 'd', 'a', 'f', 'a', 'b', 'c', 'd', 'b', 'b', 'a', 'b'};
        copyStr(chars);*/
        /*//3.*排列
        char[] chars = new char[]{'1', '*', '4', '3', '*', '5', '*'};
        star(chars);*/
       /* //4.数组去重
        int[] array = {1 ,2, 2, 2, 3, 4, 4, 5};
        solution(array);*/
       //5.单词翻转
        String input = "I am a student";
        /*char[] chars = input.toCharArray();
        swap(chars);*/
        reverseStringSequence(input);
    }
    /**
     *1.交换：把一个只包含01的串排序，可交换任意两个数的位置，最少需要多少次交换？
     **/
    public static void sort(int[] str){
        int result = 0;
        int left = 0;
        int right = str.length-1;
        while (true){
            while (str[left] == 0){
                left++;
            }
            while (str[right] == 1){
                right--;
            }
            if (left>=right){
                break;
            }else{
                int temp = str[left];
                str[left] = str[right];
                str[right]=temp;
                result++;
            }

        }
        System.out.print(result);
        System.out.print("\n");
        System.out.print(Arrays.toString(str));
    }
    /**
     *2.字符串替换和复制：删除一个字符串所有的a，并且复制所有的b（字符数组足够大）
     **/
    public static void copyStr(char[] chars){
        System.out.print("复制前：");
        System.out.print(Arrays.toString(chars)+"\n");
        char[] newChars = new char[50];
        int n = 0;
        for (int i=0;i<chars.length;i++){
            if(chars[i] !='a'){
                newChars[n++] = chars[i];
            }
        }
        /*// 1、删除a，用n当做新下标，循环遍历数组，凡是不是a的元素都放到新下标的位置，由于新n增长慢，老下标i增长快，所以元素不会被覆盖。
        // 并且在删除a时顺便记录b的数量，以便下一步复制b时可以提前确定数组最终的最大的下标。
        int n = 0;
        int countB = 0;
        for (int i = 0; newChars[i] != '\u0000' && i < newChars.length; i++) {//\u0000表示空格
            if (newChars[i] != 'a') {
                newChars[n++] = newChars[i];
            }
            if (newChars[i] == 'b') {
                    countB++;
            }

        }
        // 2、复制b，由于在第一步中就已经知道了字符串中b的个数，这里就能确定最终字符串的最大下标，从最打下表开始倒着复制原字符串，碰到b时复制即可。
        int newMaxIndex = n + countB - 1;
            for (int k = n - 1; k >= 0; k--) {
            newChars[newMaxIndex--] = newChars[k];
            if (newChars[k] == 'b') {
                newChars[newMaxIndex--] = newChars[k];
            }
        }*/
        System.out.print("复制后：");
        System.out.print(Arrays.toString(newChars));
    }
    public static void star(char[] chars){
        //3.一个字符串只包含 * 和数字，请把它的 * 都放在开头。
        //方案一：数的位置会变
        //两指针
       /* int a = 0;
        int b = chars.length-1;
        while (true){
            if(chars[a] == '*'){
                a++;
            }
            if(chars[b] != '*'){
                b--;
            }
            if(a>=b){
                break;
            }else{
                char temp ;
                temp = chars[a];
                chars[a] = chars[b];
                chars[b] = temp;

            }
        }
        System.out.print(chars+"\n");//***3451*/
        //方案二：位置不变.
        // 倒着操作：从最大下标开始向前遍历，遇到非*号的元素则加入"新"下标中，遍历完毕后，j即代表*号的个数，然后将0-j赋值为*即可。
        int j = chars.length-1;
        for (int i = j; i >= 0; i--) {
             if (chars[i] != '*') {
                 chars[j] = chars[i];
                 j--;
             }
        }
        while (j >= 0) {
             chars[j] = '*';
             j--;
        }
        System.out.print(chars);//***1435

    }
    //数组去重
    public static void solution(int[] array){
        //先排序
        Arrays.sort(array);
        //然后用两个标志位进行标定去重
        int p=0,q=0;
        for(int i = 0; i < array.length-1; ++i){
            if(array[i] != array[i + 1]){
                if(p < q){
                    array[p+1] = array[q+1];
                    p++;q++;
                }else{
                    p = i + 1;
                }
            }else{
                q = i + 1;
            }
        }
        //将去重之后的数组输出
        for(int i = 0; i <= p; ++i){
            System.out.print(array[i] + " ");
        }
        System.out.println("length = " + (p+1));
    }
    //单词翻转 例如：I am a student =》 student a am I
    public static void swap(char[] chars){
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char temp = chars[i++];
            chars[i++] = chars[j--];
            chars[j--] = temp;
        }
        int front = 1;
        int tail = 0;
        while (front < chars.length) {
        if (chars[front] == ' ') {
        int frontTemp = front - 1;
        while (tail < frontTemp) {
            char temp = chars[tail++];
            chars[tail++] = chars[frontTemp--];
            chars[frontTemp--] = temp;
         }
         tail = front + 1;
         }
         front++;
         }
         System.out.print(chars);
    }

    public static void reverseStringSequence(String str) {
        if(StringUtils.isBlank(str)){
            return;
        }
        char[] seq = str.toCharArray();
        int length = seq.length;
        // 定义两个指针记录要反转单词的起始位置
        int start = 0;
        int end = 0;
        // 这里一定要含有等于，因为要判断是否是最后一个单词，从而可以处理最后一个单词
        while (end <= length) {
            // 当已经遍历到字符串的最后一个字符，或者当前字符是空格时
            // 则对空格前的单词进行反转，即"am"反转为"ma"
            // 一定要把判断是否是结尾放在前面，否则seq[end]会报错，因为数组的有效索引是从0开始的
            // 反转后修改单词的起始指针为空格的下一个字符
            // 如果不符合条件，则移动指针继续判断下一个字符
            if (end == length || seq[end] == ' ') {
                reverse(seq, start, end - 1);
                start = end + 1;
            }
            end++;
        }
        // 反转这个数组
        reverse(seq, 0, length - 1);
        System.out.print(new String(seq));
    }

    private static void reverse(char[] seq, int start, int end) {
        while (start < end) {
            char temp = seq[start];
            seq[start] = seq[end];
            seq[end] = temp;
            start++;
            end--;
        }
    }
}
