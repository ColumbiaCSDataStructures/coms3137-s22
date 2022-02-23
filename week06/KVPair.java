public class KVPair<K extends Comparable<K>,V> implements Comparable<KVPair<K,V>> {
  
  public K key; 
  public V value; 
  
  public KVPair(K theKey, V theValue) {
    key = theKey; 
    value = theValue; 
  }
  
  public int compareTo(KVPair<K,V> other) {    
    return key.compareTo(other.key);    
  }
  
  
}