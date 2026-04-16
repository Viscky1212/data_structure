package graph;

import java.util.Arrays;

class  DSU{
    int[] parent, rank;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    //find with compression
    int find(int x){
        if (parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    //Union by rank
    boolean union (int u, int v){
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return  false;

        if (rank[pu] < rank[pv]){
            parent[pu] = pv;
        }
        else if (rank[pv] < rank[pu]){
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
        return true;
    }
}


public class SpanningTree {
    public static int spanningTree(int edge[][], int V, int E){
        //Step 1 : sort edge by weight
        Arrays.sort(edge,(a,b) -> a[2] -b[2]);

        DSU dsu = new DSU(V);

        int mstWeight = 0;
        int count = 0;

        //Step 2: process edge
        for (int i = 0; i < E; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            int w = edge[i][2];

            //Step 3: Add if no cycle
            if (dsu.union(u,v)){
                mstWeight += w;
                count++;

                //MST complete
                if (count == V - 1) break;
            }
        }
        return mstWeight;
    }

    public static void main(String[] args) {
        int V = 3;
        int E = 3;

        int[][] edges = {
                {0, 1, 5},
                {1, 2, 3},
                {0, 2, 1}
        };

        System.out.println("MST Weight: " + spanningTree(edges, V, E)); // 4
    }

}
