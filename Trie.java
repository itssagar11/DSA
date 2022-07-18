 
public class Trie{
    static final int ALPHABATE_SIZE=26;
   class Node {
         Node child[]=new Node[ALPHABATE_SIZE];
         boolean isEnd;
         Node(){
             for(int i=0;i<26;i++){
                 child[i]=null;
                 
             }
             isEnd=false;
         }
     };
Node root=new Node();
 // insertion
   void insert(String s){
     Node itr=root;
    
     for(int i=0;i<s.length();i++){
         int index= s.charAt(i)-'a';
     
          if(itr.child[index]==null){
//            	
              itr.child[index]=new Node();
               
          }else {
//            	 System.out.println("nh"+s.charAt(i));
          }
          itr=itr.child[index];   
                 
             
     }
     itr.isEnd=true;
 }
    
 // search
 boolean search(String s){
     Node itr= root;
     for(int i=0;i<s.length();i++){
         int index= s.charAt(i)-'a';
         
         if(itr.child[index]!=null){
             itr= itr.child[index];
            
         }else {
         
                 return false;
         }
         
     }
    
    return(itr!=null && itr.isEnd==true);
 }

 //---------------- delete------------------------------------------------------
//  Case 1: Key may not be present in the trie. In this case, the delete operation should not modify trie.
//  Case 2: Key present as a unique key (no part of key contains another key (prefix), nor the key itself is a prefix of another key in trie). In this case, delete all the nodes of that key.
//  Case 3: Key is a prefix key of another long key in the trie. In this case, simply unmark the leaf node.
//  Case 4: Key present in the trie, having at least one other key as a prefix key. In this case, delete nodes from the end of key until first leaf node of longest prefix key.
 public void delete(String s) {
     del(s,0,root);
 }

 public Node del(String s,int index,Node root) {
     if(root==null) return null;
     if(index==s.length()) {
         root.isEnd=false;
         if(isEmpty(root)) {
             root=null;
         }
         return root;
             
     }
     int i= s.charAt(index)-'a';
     root.child[i]=del(s,index+=1,root.child[i]);
     
     if(isEmpty(root) && root.isEnd==false) {
         System.out.print(s.charAt(index));
         root= null;
     }
     return root;
 }

 private boolean isEmpty(Node root2) {
     // TODO Auto-generated method stub
     for(int i=0;i<26;i++) {
         if(root2.child[i]!=null)
             return false;
     }
     return true;
 }

  void suggest(Node itr,String prefix){
   
   
    if(itr==null)
        return;
    if(itr.isEnd){
        System.out.println(prefix);
    }
    for(int i=0;i<ALPHABATE_SIZE;i++){

        if( itr.child[i]!=null){
            prefix=prefix+(char)(97+i);
            suggest(itr.child[i], prefix);
        }
        
    }
   
}

 // auto-complete using trie

 void autoComplete(Node root,String query){
    Node itr=root;
    for(int i=0;i<query.length();i++){
        int index= query.charAt(i)-'a';
        if(itr.child[index]!=null){
            itr=itr.child[index];
        }
    }
    if(itr.isEnd && isEmpty(itr)){
        System.out.println(query);
    }
    if(!isEmpty(itr)){
        suggest(itr, query);
    }
 }


 void autoComplete(String query){
    autoComplete(root, query);
 }

}
