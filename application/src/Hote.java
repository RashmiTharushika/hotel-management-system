import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


    class Hotel
    {
        static holder ob=new holder();
        static Scanner sc = new Scanner(System.in);
        static void CustDetails(int i,int rn)
        {
            String name, contact, gender;
            String name2 = null, contact2 = null;
            String gender2="";
            System.out.print("\n--Please fill in customer details--\n");
            System.out.print("\nEnter customer name: ");
            name = sc.next();
            System.out.print("Enter contact number: ");
            contact=sc.next();
            System.out.print("Enter gender: ");
            gender = sc.next();
            if(i<3)
            {
                System.out.print("\nEnter second customer name: ");
                name2 = sc.next();
                System.out.print("Enter contact number: ");
                contact2=sc.next();
                System.out.print("Enter gender: ");
                gender2 = sc.next();
            }

            switch (i) {
                case 1:ob.arr1[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                    break;
                case 2:ob.arr2[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                    break;
                case 3:ob.arr3[rn]=new Singleroom(name,contact,gender);
                    break;
                case 4:ob.arr4[rn]=new Singleroom(name,contact,gender);
                    break;
                default:System.out.println("Wrong option");
                    break;
            }
        }

        static void bookroom(int i)
        {
            int j;
            int rn;
            System.out.println("\nThe valid room number is: ");
            switch (i) {
                case 1:
                    for(j=0;j<ob.arr1.length;j++)
                    {
                        if(ob.arr1[j]==null)
                        {
                            System.out.print(j+1+",");
                        }
                    }
                    System.out.print("\n\nEnter room number: ");
                    try{
                        rn=sc.nextInt();
                        rn--;
                        if(ob.arr1[rn]!=null)
                            throw new NotAvailable();
                        CustDetails(i,rn);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Invalid Option");
                        return;
                    }
                    break;
                case 2:
                    for(j=0;j<ob.arr2.length;j++)
                    {
                        if(ob.arr2[j]==null)
                        {
                            System.out.print(j+11+",");
                        }
                    }
                    System.out.print("\n\nEnter room number: ");
                    try{
                        rn=sc.nextInt();
                        rn=rn-11;
                        if(ob.arr2[rn]!=null)
                            throw new NotAvailable();
                        CustDetails(i,rn);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Invalid Option");
                        return;
                    }
                    break;
                case 3:
                    for(j=0;j<ob.arr3.length;j++)
                    {
                        if(ob.arr3[j]==null)
                        {
                            System.out.print(j+31+",");
                        }
                    }
                    System.out.print("\n\nEnter room number: ");
                    try{
                        rn=sc.nextInt();
                        rn=rn-31;
                        if(ob.arr3[rn]!=null)
                            throw new NotAvailable();
                        CustDetails(i,rn);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Invalid Option");
                        return;
                    }
                    break;
                case 4:
                    for(j=0;j<ob.arr4.length;j++)
                    {
                        if(ob.arr4[j]==null)
                        {
                            System.out.print(j+41+",");
                        }
                    }
                    System.out.print("\n\nEnter room number: ");
                    try{
                        rn=sc.nextInt();
                        rn=rn-41;
                        if(ob.arr4[rn]!=null)
                            throw new NotAvailable();
                        CustDetails(i,rn);
                    }
                    catch(Exception e)
                    {
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

        static void features(int i)
        {
            switch (i) {
                case 1:System.out.println("\nNumber of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day: RM300 ");
                    break;
                case 2:System.out.println("\nNumber of double beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day: RM200  ");
                    break;
                case 3:System.out.println("\nNumber of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day: RM150  ");
                    break;
                case 4:System.out.println("\nNumber of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day: RM90 ");
                    break;
                default:
                    System.out.println("Enter valid option");
                    break;
            }
        }

        static void availability(int i)
        {
            int j,count=0;
            switch (i) {
                case 1:
                    for(j=0;j<10;j++)
                    {
                        if(ob.arr1[j]==null)
                            count++;
                    }
                    break;
                case 2:
                    for(j=0;j<ob.arr2.length;j++)
                    {
                        if(ob.arr2[j]==null)
                            count++;
                    }
                    break;
                case 3:
                    for(j=0;j<ob.arr3.length;j++)
                    {
                        if(ob.arr3[j]==null)
                            count++;
                    }
                    break;
                case 4:
                    for(j=0;j<ob.arr4.length;j++)
                    {
                        if(ob.arr4[j]==null)
                            count++;
                    }
                    break;
                default:
                    System.out.println("Enter valid option");
                    break;
            }
            System.out.println("Number of rooms available : "+count);
        }

        static void bill(int rn,int rtype)
        {
            double amount=0;
            String list[]={"Sandwich","Pasta","Noodles","Coke"};
            System.out.println("\n*******");
            System.out.println(" Bill:-");
            System.out.println("*******");

            switch(rtype)
            {
                case 1:
                    amount+=300;
                    System.out.println("\nRoom Charge - RM"+300);
                    System.out.println("\nFood Charges:- ");
                    System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:ob.arr1[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }

                    break;
                case 2:amount+=200;
                    System.out.println("Room Charge - RM"+200);
                    System.out.println("\nFood Charges:- ");
                    System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:ob.arr2[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                    break;
                case 3:amount+=150;
                    System.out.println("Room Charge - RM"+150);
                    System.out.println("\nFood Charges:- ");
                    System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:ob.arr3[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                    break;
                case 4:amount+=90;
                    System.out.println("Room Charge - RM"+90);
                    System.out.println("\nFood Charges:- ");
                    System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:ob.arr4[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                    break;
                default:
                    System.out.println("Not valid");
            }
            System.out.println("\nTotal Amount- RM"+amount);
        }



        static void display(int rn,int rtype)
        {
            double amount=0;
            String list[]={"Sandwich","Pasta","Noodles","Coke"};


            switch(rtype)
            {
                case 1:
                    amount+=300;
                    System.out.println("Customer name: "+ob.arr1[rn].name);
                    System.out.println("\nRoom Charge - RM"+300);
                    System.out.println("\nFood Charges - ");
                    System.out.println("Item     Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:ob.arr1[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }

                    break;
                case 2:amount+=200;
                    System.out.println("Customer name: "+ob.arr2[rn].name);
                    System.out.println("\nRoom Charge - RM"+200);
                    System.out.println("\nFood Charges - ");
                    System.out.println("Item     Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:ob.arr2[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                    break;
                case 3:amount+=150;
                    System.out.println("Customer name: "+ob.arr3[rn].name);
                    System.out.println("\nRoom Charge - RM"+150);
                    System.out.println("\nFood Charges - ");
                    System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:ob.arr3[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                    break;
                case 4:amount+=90;
                    System.out.println("Customer name: "+ob.arr4[rn].name);
                    System.out.println("\nRoom Charge - RM"+90);
                    System.out.println("\nFood Charges - ");
                    System.out.println("Item     Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:ob.arr4[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                    break;
                default:
                    System.out.println("Not valid");
            }
            System.out.println("\nTotal Amount- RM"+amount);
        }




        static void deallocate(int rn,int rtype)
        {
            int j;
            char w;
            switch (rtype) {
                case 1:
                    if(ob.arr1[rn]!=null)
                        System.out.println("Room used by "+ob.arr1[rn].name);
                    else
                    {
                        System.out.println("Empty Already");
                        return;
                    }
                    System.out.println("\nDo you want to checkout ?(y/n)");
                    w=sc.next().charAt(0);
                    if(w=='y'||w=='Y')
                    {
                        bill(rn,rtype);
                        ob.arr1[rn]=null;
                        System.out.println("\n--Deallocated succesfully--");
                    }

                    break;
                case 2:
                    if(ob.arr2[rn]!=null)
                        System.out.println("Room used by "+ob.arr2[rn].name);
                    else
                    {
                        System.out.println("Empty Already");
                        return;
                    }
                    System.out.println(" Do you want to checkout ?(y/n)");
                    w=sc.next().charAt(0);
                    if(w=='y'||w=='Y')
                    {
                        bill(rn,rtype);
                        ob.arr2[rn]=null;
                        System.out.println("\n--Deallocated succesfully--");
                    }

                    break;
                case 3:
                    if(ob.arr3[rn]!=null)
                        System.out.println("Room used by "+ob.arr3[rn].name);
                    else
                    {
                        System.out.println("Empty Already");
                        return;
                    }
                    System.out.println("\nDo you want to checkout ? (y/n)");
                    w=sc.next().charAt(0);
                    if(w=='y'||w=='Y')
                    {
                        bill(rn,rtype);
                        ob.arr3[rn]=null;
                        System.out.println("\n--Deallocated succesfully--");
                    }

                    break;
                case 4:
                    if(ob.arr4[rn]!=null)
                        System.out.println("Room used by "+ob.arr4[rn].name);
                    else
                    {
                        System.out.println("Empty Already");
                        return;
                    }
                    System.out.println("\nDo you want to checkout ? (y/n)");
                    w=sc.next().charAt(0);
                    if(w=='y'||w=='Y')
                    {
                        bill(rn,rtype);
                        ob.arr4[rn]=null;
                        System.out.println("\n--Deallocated succesfully--");
                    }
                    break;
                default:
                    System.out.println("\nEnter valid option : ");
                    break;
            }
        }

        static void order(int rn,int rtype)
        {
            int i,q;
            char wish;
            try{
                System.out.println("\n==========\n   Menu:  \n==========\n\n1.Sandwich\tRM3.00\n2.Pasta\t\tRM10.00\n3.Noodles\tRM6.00\n4.Coke\t\tRM2.00\n");
                do
                {
                    System.out.print("\nEnter your choice- ");
                    i = sc.nextInt();
                    System.out.print("\nQuantity- ");
                    q=sc.nextInt();

                    switch(rtype){
                        case 1: ob.arr1[rn].food.add(new Food(i,q));
                            break;
                        case 2: ob.arr2[rn].food.add(new Food(i,q));
                            break;
                        case 3: ob.arr3[rn].food.add(new Food(i,q));
                            break;
                        case 4: ob.arr4[rn].food.add(new Food(i,q));
                            break;
                    }
                    System.out.println("\nDo you want to order anything else ? (y/n)");
                    wish=sc.next().charAt(0);
                }while(wish=='y'||wish=='Y');
            }
            catch(NullPointerException e)
            {
                System.out.println("\nRoom not booked");
            }
            catch(Exception e)
            {
                System.out.println("Cannot be done");
            }
        }
    }
