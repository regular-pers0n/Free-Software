/*
 * Integrated Library Management System v0.01
 * ilms.java
 * Copyleft - 2014  Javier Dominguez Gomez
 * Written by Javier Dominguez Gomez <jdg@member.fsf.org>
 * GnuPG Key: 6ECD1616
 * Madrid, Spain
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
 
import java.util.ArrayList;

public class Library
{
  private String name;
  private String address;
  private int numEmployees;
  private boolean open;
  private ArrayList<User> users;
  private ArrayList<Item> items;

  public Library(String name, String address, int numEmployees)
  {
   this.name = name;
   this.address = address;
   this.numEmployees = numEmployees;
   this.open = open;
   users = new ArrayList<User>();
   items = new ArrayList<Item>();
  }
  
  public String getName(){return name;}
  public String getAddress(){return address;}
  public int getNumEmployees(){return numEmployees;}
  public int getNumUsers(){return users.size();}
  public int getNumItems(){return items.size();}
  public boolean getOpen(){return open;}
  
  // Users code
  
  public void addUser(User user)
  {
   users.add(user);
  }
  
  public void listAllUsers()
  {
   for(User user : users) {
    System.out.println(user.getDetails());
   }
  }
  
  public void listBySurname(String surname)
  {
   for(User user : users) {
    if(user.getSurname().contains(surname)) {
     System.out.println(user.getDetails());
    }
   }
  }
  
  public void removeUser(int index)
  {
   if(indexUsersValid(index)) {
    users.remove(index);
   }
  }
  
  private boolean indexUsersValid(int index)
  {
   boolean valid;
   
   if(index < 0) {
    System.out.println("Index cannot be negative: " + index);
    valid = false;
   } else if(index >= users.size()) {
    System.out.println("Index is too large: " + index);
    valid = false;
   } else {
    valid = true;
   }
   return valid;
  }
  
  // Items code
  
  public void listItem(int index)
  {
   if(index >= 0 && index < items.size()) {
    String item = items.get(index);
    System.out.println(item);
   }
  }
  
  public void listAllItems()
  {
   for(String item : items) {
    System.out.println(item);
   }
  }
  
  public void listItemMatching(String searchString)
  {
   for(String item : items) {
    if(item.contains(searchString)) {
     System.out.println(item);
    }
   }
  }
  
  public void removeItem(int index)
  {
   if(index >= 0 && index < items.size()) {
    items.remove(index);
   }
  }
}