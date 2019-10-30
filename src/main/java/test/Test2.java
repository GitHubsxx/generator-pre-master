package test;

public class Test2 {
    public static void main(String[] args){
        int flo = romanToInt("IV");
        System.out.print(flo);
    }

    /**
     * 1.把字符串变成字符
     * 2.循环遍历字符，匹配到哪一个就加上对应的数值
     * 3.六种特殊情况，特殊处理
     * @return
     */
    public static int romanToInt(String s) {
        int sum=0,i;
        char chs[]=s.toCharArray();
        for(i=0;i<chs.length;i++)
        {
            if(chs[i]=='I') sum+=1;
            if(chs[i]=='V')
            {
                if(i!=0 && chs[i-1]=='I') sum+=4-1;//还要把上次累加上的减去
                else sum+=5;
            }
            if(chs[i]=='X')
            {
                if(i!=0 && chs[i-1]=='I') sum+=9-1;
                else sum+=10;
            }
            if(chs[i]=='L')
            {
                if(i!=0 &&chs[i-1]=='X') sum+=40-10;
                else sum+=50;
            }
            if(chs[i]=='C')
            {
                if(i!=0 && chs[i-1]=='X') sum+=90-10;
                else sum+=100;
            }
            if(chs[i]=='D')
            {
                if(i!=0 && chs[i-1]=='C') sum+=400-100;
                else sum+=500;
            }
            if(chs[i]=='M')
            {
                if(i!=0 && chs[i-1]=='C') sum+=900-100;
                else sum+=1000;
            }
        }
        return sum;
    }
    public static String string(String[] strs){
        if(strs.length == 0){
            return "";
        }
        //1.先取出数组里面的第一个字符串
        String str = strs[0];
        //2. i=1 从第二个元素开始依次和第一个元素比较
        for(int i = 1; i < strs.length; i++){
            //因为至少是每个字符串的第一个元素相同，等于0 说明就有相同的部分
            while(strs[i].indexOf(str) != 0){
                //不相同的话，每次都剔除第一个字符串的最后一个字符，再返回去比较
                str=str.substring(0, str.length() - 1);
            }
        }
        return str;
    }
}
