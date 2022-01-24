public class Person implements Comparable<Person> {

  String first_name; 
  String last_name;
  
  public Person(String first, String last ) {
  
    first_name = first; 
    last_name = last;

  }


  public int compareTo(Person other) {
    if (last_name.equals(other.last_name)) {
      return first_name.compareTo(other.first_name);
    } 
    return last_name.compareTo(other.last_name); 
  }

}
