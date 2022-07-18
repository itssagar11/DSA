class Main{
    public static void main(String[] args){
         Trie obj=new Trie();
          obj.insert("sagar");
         obj.insert("shree");
         obj.insert("shreeram");
          System.out.println(obj.search("shree") );
          obj.delete("shree");
         
          System.out.println(obj.search("shree") );
      }
}