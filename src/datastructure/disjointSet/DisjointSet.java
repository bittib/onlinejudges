package datastructure.disjointSet;

public class DisjointSet {
    private int[] s;
    private int count; // //记录并查集中子集合的个数(子树的个数)

    public DisjointSet(int numElements) {
        //初始时每个元素代表一个集合，该元素本身就是树根。树根的父结点用 -1 来表示
        s = new int[numElements];
        count = numElements;
        //初始化并查集,相当于新建了s.length 个互不相交的集合
        for (int i = 0; i < numElements; i++) {
            s[i] = -1; //s[i]存储的是高度(秩)信息
        }
    }
    //union操作
    public void unionByHeight(int x, int y) {
        int xroot = find(x), yroot = find(y);
        if (xroot != yroot) {

            if (s[xroot] < s[yroot]) // root2 is deeper
                s[xroot] = yroot;
            else {
                s[yroot] = xroot;
            }
            count--;
        }
    }
    //find 操作
    public int find(int x) {
        if (s[x] < 0) {
            return x;
        } else {
            return find(s[x]);
        }
    }
}
