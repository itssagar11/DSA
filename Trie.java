 
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
 public void delete(String s) {
     del(s,0,root);
 }

 public Node del(String s,int index,Node root) {
     if(root==null) return null;
     if(index==s.length()) {
         root.isEnd=false;
         if(isEmpty(root)) {
             root=null;
//    			System.out.println(s.charAt(index));
         }
//    		System.out.println(s.charAt(index)+"end"+index+"    "+root.isEnd);
         return root;
             
     }
     int i= s.charAt(index)-'a';
     root.child[i]=del(s,index+=1,root.child[i]);
//    	System.out.println(root.child[i].isEnd+"child");
     
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
}
