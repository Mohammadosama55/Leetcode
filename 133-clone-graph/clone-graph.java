/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Map<Node,Node>map=new HashMap<>();
        Queue<Node>q=new LinkedList<>();
        Node clone=new Node(node.val);
        map.put(node,clone);
        q.add(node);
        while(!q.isEmpty()){
            Node cur=q.poll();
            for(Node n:cur.neighbors){
                if(!map.containsKey(n)){
                   
                Node CloneN=new Node(n.val);
                map.put(n,CloneN);
                q.add(n);
            }
            map.get(cur).neighbors.add(map.get(n));

            }
            
        }
        return clone;
    }
}