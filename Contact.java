package ContactList;

import java.util.Scanner;

// Contact class to represent a person's information
public class Contact {
 private String firstName;
 private String lastName;
 private int zip;

 // Constructor to initialize Contact object with first name, last name, and zip code
 public Contact(String firstName, String lastName, int zip) {
     this.firstName = firstName;
     this.lastName = lastName;
     this.zip = zip;
 }

 // Getter method to retrieve last name
 public String getLastName() {
     return lastName;
 }

 // Method to display contact information
 public void displayContactInfo() {
     System.out.println("First Name: " + firstName);
     System.out.println("Last Name: " + lastName);
     System.out.println("Zip Code: " + zip);
 }

// Main class
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     Contact[] contacts = new Contact[100]; // Let the user add as many contacts as they would like (Max 100)

     int contactCount = 0;
     String input;

     // Loop to allow the user to enter contacts until they decide to stop (first name, last name, and zip code)
     do {
         System.out.print("Enter First Name: ");
         String firstName = scanner.next();

         System.out.print("Enter Last Name: ");
         String lastName = scanner.next();

         System.out.print("Enter Zip Code: ");
         int zip = scanner.nextInt();

         // Create a new Contact object and add it to the array
         contacts[contactCount] = new Contact(firstName, lastName, zip);
         contactCount++;
         
         // Prompt user if they would like to add another contact
         System.out.print("Do you want to add another contact? (yes/no): ");
         input = scanner.next();
     } while (input.equalsIgnoreCase("yes")); // 'yes' repeats loop, 'no' stops loop

     // Search for a contact by last name
     System.out.print("Enter the last name to search contact: ");
     String searchLastName = scanner.next();

     boolean found = false;

     // Iterate through the array to find the contact with the specified last name
     for (int i = 0; i < contactCount; i++) {
         if (contacts[i].getLastName().equalsIgnoreCase(searchLastName)) {
             // Display the contact information if found
             contacts[i].displayContactInfo();
             found = true;
             break;
         }
     }

     // Print "Not found" if the contact is not in the list
     if (!found) {
         System.out.println("Not found");
     }
 }
}
