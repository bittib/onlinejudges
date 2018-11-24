package leetcode.datastructures.graph.medium.LC_323_Number_of_Connected_Components_In_An_Undirected_Graph;

public class DisjointSetSolution {
    public int countComponents(int n, int[][] edges) {
        DS ds = new DS(n);

        for (int[] e : edges) {
            ds.union(e[0], e[1]);
        }

        return ds.count;
    }


}

class DS {
    int[] parent;
    int[] sz;
    int count;

    public DS(int n) {
        parent = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
        count = n;
    }

    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int xp = find(x), yp = find(y);

        if (xp != yp) {
            if (sz[xp] >= sz[yp]) {
                parent[yp] = xp;
                sz[xp] += sz[yp];
            } else {
                parent[xp] = yp;
                sz[yp] += xp;
            }
            count--;
        }
    }
}
