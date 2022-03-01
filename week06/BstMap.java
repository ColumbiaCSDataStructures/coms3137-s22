import java.util.TreeMap; 

public class BstMap<K extends Comparable<K>,V> { // implements Map<K,V> {
  
  BinarySearchTree<KVPair<K,V>> theBST; 
  
  public BstMap(){
    theBST = new BinarySearchTree<KVPair<K,V>>(); 
  }
  
  public void put(K key, V value) {
    KVPair<K,V> thePair = new KVPair<>(key, value);
    theBST.insert(thePair);
  }
  
  public V get(K key) {
    KVPair<K,V> keyDummy = new KVPair<>(key, null);
    
    KVPair<K,V> result = theBST.find(keyDummy);
    return result.value;
  }
  
  
  public static void main(String[] args) {
   
    // Red-Black Tree 
    TreeMap<Integer, String> map = new TreeMap<>();
    
    map.put(2,"b");
    map.put(1,"a");
    map.put(3,"c");
    
    System.out.println(map.get(2));
    
  }
  
}
