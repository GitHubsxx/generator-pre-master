package test.dongtaiProxy;

public class DoubleLink<T> {
    private DNode<T> head;
    //节点的个数
    private int count;

    //双向链表的节点封装
    private class DNode<T> {
        private DNode prve;
        private DNode next;
        private T value;

        public DNode(DNode prve,DNode next,T value){
            this.prve=prve;
            this.next=next;
            this.value=value;
        }
    }
    //构造函数：表头没有存储数据
    public DoubleLink(){
        this.head=new DNode<T>(null,null,null);
        head.prve=head.next=head;
        this.count=0;
    }
    //1.返回链表是否为空
    public boolean isEmpty(){
        return count==0;
    }
    //2.返回index位置的节点
    public DNode<T> getNode(int index){
        if(index <0 || index>count){
            throw new IndexOutOfBoundsException();
        }
        //正向查找(二分法：要查找的元素在左边的节点)
        if(index <= count/2){
            DNode<T> node = head.next;
            for(int i=0;i<index;i++){
                node = node.next;
            }
            return node;
        }else{
            //反向查找
            DNode<T> node = head.prve;
            int pIndex = count-index-1;
            for(int j=0;j<pIndex;j++){
                node = node.prve;
            }
            return node;
        }

    }
    //获得index位置节点的值
    public T get(int index){
        return getNode(index).value;
    }
    //获得第一个节点的值
    public T getFirst(){
        return getNode(0).value;
    }
    //获得最后一个节点的值
    public T getLast(){
        return getNode(count-1).value;
    }
    //将节点插入到index位置之前
    public void insert(int index,T t){
        if(index == 0){
            //头节点
            DNode<T> node = new DNode<>(head, head.next, t);
            head.next.prve = node;//头节点的下一个节点的前置节点为头结点
            head.next = node;//头节点的下一个节点为自己
            count++;
            return;
        }else{
            DNode<T> node = getNode(index);
            DNode<T> tdNode = new DNode<>(node.prve, node, t);
            node.prve.next = tdNode;
            node.next = tdNode;
            count++;
            return;
        }
    }
    //删除index位置的节点
    public void delete(int index){
        DNode<T> inode = getNode(index);
        inode.prve.next = inode.next;
        inode.next.prve = inode.prve;
        inode = null;
        count--;
    }
}
