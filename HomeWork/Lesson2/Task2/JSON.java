package Lesson2.Task2;

import java.util.Arrays;

public class JSON {
   public String name;
   public String surname;
   public String [] phones;
   public String [] sites;
   public Address address;

   @Override
   public String toString() {
      return "JSON{" +
              "Name='" + name + '\'' +
              ", surname='" + surname + '\'' +
              ", phones=" + Arrays.toString(phones) +
              ", sites=" + Arrays.toString(sites) +
              ", " + address +
              '}';
   }
}
