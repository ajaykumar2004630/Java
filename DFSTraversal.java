package graphs;

import java.util.*;

public class DFSTraversal {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int v = sc.nextInt();
    int e = sc.nextInt();
    List<List<Integer>> adj = new ArrayList<>();
    for(int i=0;i<=v;i++)
      adj.add(new ArrayList<Integer>());
    for(int i=0;i<e;i++)
    {
      int x = sc.nextInt();
      int y = sc.nextInt();
      adj.get(x).add(y);
      adj.get(y).add(x);
    }
    List<Integer> list = dfsGraph(v, adj);
    System.out.println(list);
    
  }
  
  static List<Integer> dfsGraph(int n,List<List<Integer>> adj)
  {
    List<Integer> dfsls = new ArrayList<>();
    boolean[] vis = new boolean[n+1];
    for(int i=1;i<=n;i++)
    {
      if(!vis[i])
        dfs(i,vis,adj,dfsls);
    }
    return dfsls;
  }
  
  static void dfs(int src,boolean[] vis,List<List<Integer>> adj,List<Integer> dfsls)
  {
    dfsls.add(src);
    vis[src] = true;
    
    for(int node:adj.get(src)) {
      if(!vis[node]) {
        dfs(node,vis,adj,dfsls);
      }
    }
  }

}
