package test.dongtaiProxy;

public class LinkTest {
    public static void main(String[] args){
        int[] iarr = {10, 20, 30, 40};
        DoubleLink<Integer> link = new DoubleLink<>();
        link.insert(0,20);
        link.insert(1,200);
        link.insert(2,300);
        Integer value = link.get(2);
        System.out.print(value);
    }
}
