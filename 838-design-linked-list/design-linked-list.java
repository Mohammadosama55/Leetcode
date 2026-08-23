class MyLinkedList {
    private class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    private Node dump;
    private int size;
    public MyLinkedList() {
        dump=new Node(-1);
        size=0;
        
    }
    
    public int get(int index) {
        if(index<0 || index>=size){return -1;}
        Node curr=dump;
        for(int i=0;i<=index;i++){
            curr=curr.next;
        }
       return curr.data; 
    }
    
    public void addAtHead(int val) {
         addAtIndex(0,val);
        
    }
    
    public void addAtTail(int val) {
         addAtIndex(size,val);
        
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0)return;
        if(index>size)index= 0;
        Node curr=dump;
        for(int i=0;i<index;i++){
            curr=curr.next;
        }
        Node n=new Node(val);
        n.next=curr.next;
        curr.next=n;
        size++;

    }
    
    public void deleteAtIndex(int index) {
        if(index<0|| index>=size){return;}
        Node curr=dump;
        for(int i=0;i<index;i++){
            curr=curr.next;
        }
        curr.next=curr.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */