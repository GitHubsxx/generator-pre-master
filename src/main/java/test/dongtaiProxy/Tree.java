package test.dongtaiProxy;

public class Tree {
    private Tree leftTree;
    private Tree rightTree;
    private int data;

    public Tree(int data){
        this.data = data;
    }

    public Tree getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(Tree leftTree) {
        this.leftTree = leftTree;
    }

    public Tree getRightTree() {
        return rightTree;
    }

    public void setRightTree(Tree rightTree) {
        this.rightTree = rightTree;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
