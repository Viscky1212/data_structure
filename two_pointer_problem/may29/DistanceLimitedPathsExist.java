package two_pointer_problem.may29;

import java.util.Arrays;

public class DistanceLimitedPathsExist {
    public static void main(String[] args) {
        DistanceLimitedPathsExist sol = new DistanceLimitedPathsExist();
        int n1 = 3;
        int[][] edgeList1 = {{0, 1, 2}, {1, 2, 4}, {2, 0, 8}};
        int[][] queries1 = {{0, 1, 2}, {0, 2, 5}};

        int n2 = 5;
        int[][] edgeList2 = {{0, 1, 10}, {1, 2, 5}, {2, 3, 9}, {3, 4, 13}};
        int[][] queries2 = {{0, 4, 14}, {1, 4, 13}};

        for (boolean res : sol.distanceLimitedPathsExist(n1, edgeList1, queries1)) {
            System.out.println(res);
        }

        for (boolean res : sol.distanceLimitedPathsExist(n2, edgeList2, queries2)) {
            System.out.println(res);
        }
    }




    //DisJoint Set Union (DSU) or Union-Find data structure
    static class DSU {
        private int[] parent;
        private int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        //find with path compression
        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        //union by rank
        public void union(int u, int v) {
            int parentU = find(u);
            int parentV = find(v);

            if (parentU == parentV) {
                return; // already in the same set
            }

            if (rank[parentU] < rank[parentV]) {
                parent[parentU] = parentV;
            } else if (rank[parentU] > rank[parentV]) {
                parent[parentV] = parentU;
            } else {
                parent[parentV] = parentU;
                rank[parentU]++;
            }
        }
    }

    public static boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        //sort edge by distance
        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));

        int totalQueries = queries.length;

        //store original index of queries before sorting
        int[][] indexedQueries = new int[totalQueries][4];
        for (int i = 0; i < totalQueries; i++) {
            indexedQueries[i][0] = queries[i][0]; // u
            indexedQueries[i][1] = queries[i][1]; // v
            indexedQueries[i][2] = queries[i][2]; // limit
            indexedQueries[i][3] = i; // original index
        }
        Arrays.sort(indexedQueries, (a, b) -> Integer.compare(a[2], b[2]));

        boolean[] result = new boolean[totalQueries];
        DSU dsu = new DSU(n);
        int edgeIndex = 0;

        //process query in sorted order of limit
        for (int[] query : indexedQueries) {
            int source = query[0];
            int destination = query[1];
            int limit = query[2];
            int originalIndex = query[3];

            //union all edges with distance less than limit
            while (edgeIndex < edgeList.length && edgeList[edgeIndex][2] < limit) {
                dsu.union(edgeList[edgeIndex][0], edgeList[edgeIndex][1]);
                edgeIndex++;
            }
            result[originalIndex] = dsu.find(source) == dsu.find(destination);
        }
        return result;
    }
}