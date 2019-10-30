package test.dongtaiProxy;

public class TreeTest {
    public static void main(String[] args){/*
      Tree t1 = new Tree(1);
      Tree t2 = new Tree(2);
      Tree t3 = new Tree(3);
      Tree t4= new Tree(4);
      t1.setLeftTree(t2);
      t1.setRightTree(t3);
      t2.setLeftTree(t4);
        System.out.print(treeMaxDepth(t1));*/
        int[] arr = {2,3,1,4,5};
        TreeRoot treeRoot = new TreeRoot();
        for(int a : arr){
            buildTree(treeRoot,a);
        }
    }
    /**计算二叉树的最大深度**/
    public static int treeMaxDepth(Tree root){
        if(root == null){
            return 0;
        }
        int left = treeMaxDepth(root.getLeftTree());
        int right = treeMaxDepth(root.getRightTree());
        int max = left;
        if(left < right){
            max = right;
        }
        return max+1;
    }

    /**动态的创建二叉树(二叉查找树)**/
    public static void buildTree(TreeRoot root,int data){
       if(root == null){
           Tree tree = new Tree(data);
           root.setTreeRoot(tree);
       }
        Tree treeRoot = root.getTreeRoot();
       while (treeRoot !=null){
           if(data>treeRoot.getData()){
               if(treeRoot.getRightTree() ==null){
                   treeRoot.setRightTree(new Tree(data));
               }else{
                   treeRoot = treeRoot.getRightTree();
               }
           }else{
               treeRoot = treeRoot.getLeftTree();
           }
       }
    }
}
