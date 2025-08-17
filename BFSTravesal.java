package graphs;

import java.util.*;

public class BFSTravesal {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int v = sc.nextInt();
    int e = sc.nextInt();
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i <= v; i++)
      adj.add(new ArrayList<Integer>());
    for (int i = 0; i < e; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      adj.get(x).add(y);
      adj.get(y).add(x);
    }
    List<Integer> list = bfsGraph(v, adj);
    System.out.println(list);
  }

  static List<Integer> bfsGraph(int n, List<List<Integer>> adj) {
    boolean[] vis = new boolean[n + 1];
    List<Integer> bfs = new ArrayList<>();
    Queue<Integer> que = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      if (!vis[i]) {
        que.add(i);
        vis[i] = true;
        while (!que.isEmpty()) {
          int node = que.poll();
          bfs.add(node);
          for (int nod : adj.get(node)) {
            if (!vis[nod]) {
              que.add(nod);
              vis[nod] = true;
            }
          }
        }
      }
    }
    return bfs;
  }

}
