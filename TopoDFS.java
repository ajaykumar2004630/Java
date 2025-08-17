package graphs;

import java.util.*;

public class TopoDFS {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
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
      //adj.get(y).add(x);
    }
    System.out.println(topoSort(v,adj));
    
  }

  static Stack<Integer> topoSort(int n,List<List<Integer>> adj)
  {
    boolean[] vis = new boolean[n];
    Stack<Integer> st = new Stack<>();
    for(int i=0;i<n;i++)
    {
      if(!vis[i])
        dfs(i,st,adj,vis);
    }
    return st;
  }
  
  static void dfs(int node,Stack<Integer> st,List<List<Integer>> adj,boolean[] vis)
  {
    vis[node] = true;
    for(int nod:adj.get(node))
    {
      if(!vis[nod])
        dfs(nod,st,adj,vis);
    }
    st.push(node);
  }
}
