package graphs;

import java.util.*;

public class TopoBFS {

  public static void main(String[] args) 
  {
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
    System.out.println(Arrays.toString(topoSort(v,adj)));
  }
  
  static int[] topoSort(int v,List<List<Integer>> adj)
  {
    int[] inDeg = new int[v];
    for(int i=0;i<v;i++)
    {
      for(int temp:adj.get(i))
        inDeg[temp]++;
    }
    
    Queue<Integer> q = new LinkedList<>();
    int[] topo = new int[v];
    
    for(int i=0;i<v;i++)
    {
      if(inDeg[i]==0)
        q.add(i);
    }
    int i=0;
    while(!q.isEmpty())
    {
      int node = q.peek();
      q.remove();
      topo[i++] = node;
      for(int temp:adj.get(node)) {
        inDeg[temp]--;
        if(inDeg[temp]==0)
          q.add(temp);
      }
    }
    return topo;
  }

}
