import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


class Booking {
    static holder ob = new holder();
    static Scanner sc = new Scanner(System.in);

    static void CustDetails(int i, int rn) {
        String name, contact, gender;
        String name2 = null, contact2 = null;
        String gender2 = "";
        System.out.print("\n--Please fill in customer details--\n");
        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact = sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();
        if (i < 3) {
            System.out.print("\nEnter second customer name: ");
            name2 = sc.next();
            System.out.print("Enter contact number: ");
            contact2 = sc.next();
            System.out.print("Enter gender: ");
            gender2 = sc.next();
        }

        switch (i) {
            case 1:
                ob.arr1[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                break;
            case 2:
                ob.arr2[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                break;
            case 3:
                ob.arr3[rn] = new Singleroom(name, contact, gender);
                break;
            case 4:
                ob.arr4[rn] = new Singleroom(name, contact, gender);
                break;
            default:
                System.out.println("Wrong option");
                break;
        }
    }

    static void bookroom(int i) {
        int j;
        int rn;
        System.out.println("\nThe valid room number is: ");
        switch (i) {
            case 1:
                for (j = 0; j < ob.arr1.length; j++) {
                    if (ob.arr1[j] == null) {
                        System.out.print(j + 1 + ",");
                    }
                }
                System.out.print("\n\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn--;
                    if (ob.arr1[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 2:
                for (j = 0; j < ob.arr2.length; j++) {
                    if (ob.arr2[j] == null) {
                        System.out.print(j + 11 + ",");
                    }
                }
                System.out.print("\n\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn = rn - 11;
                    if (ob.arr2[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 3:
                for (j = 0; j < ob.arr3.length; j++) {
                    if (ob.arr3[j] == null) {
                        System.out.print(j + 31 + ",");
                    }
                }
                System.out.print("\n\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn = rn - 31;
                    if (ob.arr3[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 4:
                for (j = 0; j < ob.arr4.length; j++) {
                    if (ob.arr4[j] == null) {
                        System.out.print(j + 41 + ",");
                    }
                }
                System.out.print("\n\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn = rn - 41;
                    if (ob.arr4[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("\n--Room Booked--");
    }

    static void features(int i) {
        switch (i) {
            case 1:
                System.out.println("\nNumber of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day: Rs.10000 ");
                break;
            case 2:
                System.out.println("\nNumber of double beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day: Rs.8000  ");
                break;
            case 3:
                System.out.println("\nNumber of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day: Rs.7500  ");
                break;
            case 4:
                System.out.println("\nNumber of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day: Rs.5500 ");
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
    }

    static void availability(int i) {
        int j, count = 0;
        switch (i) {
            case 1:
                for (j = 0; j < 10; j++) {
                    if (ob.arr1[j] == null)
                        count++;
                }
                break;
            case 2:
                for (j = 0; j < ob.arr2.length; j++) {
                    if (ob.arr2[j] == null)
                        count++;
                }
                break;
            case 3:
                for (j = 0; j < ob.arr3.length; j++) {
                    if (ob.arr3[j] == null)
                        count++;
                }
                break;
            case 4:
                for (j = 0; j < ob.arr4.length; j++) {
                    if (ob.arr4[j] == null)
                        count++;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Number of rooms available : " + count);
    }
}

