import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class CamelHotelSystem {
    public static void main(String[] args){

        System.out.println("\n---------------------------------------------");
        System.out.println("Welcome to Camel Hotel Reservation System");
        System.out.println("---------------------------------------------");
        System.out.println("\n--Please log in to the system--");

        try
        {
            String Username= "admin";
            String Password= "123";

            Scanner input1 = new Scanner(System.in);
            System.out.println("\nEnter Username : ");
            String username = input1.next();

            Scanner input2 = new Scanner(System.in);
            System.out.println("\nEnter Password : ");
            String password = input2.next();

            if (username.equals(Username) && password.equals(Password)) {

                System.out.println("\n--Access Granted! Welcome!--");
            }

            else if (username.equals(Username)) {
                System.out.println("\nInInvalid Password! You cannot log in to the system. Please try again.");
                System.exit(0);
            } else if (password.equals(Password)) {
                System.out.println("\nInvalid Username! You cannot log in to the system. Please try again.");
                System.exit(0);
            } else {
                System.out.println("\nInvalid Username & Password! You cannot log in to the system. Please try again.");
                System.exit(0);
            }

            File f = new File("backup");
            if(f.exists())
            {
                FileInputStream fin=new FileInputStream(f);
                ObjectInputStream ois=new ObjectInputStream(fin);
                Hotel.ob=(holder)ois.readObject();
            }
            Scanner sc = new Scanner(System.in);
            int ch,ch2;
            char wish;
            x:
            do{

                System.out.println("\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.Order food\n5.Checkout\n6.Display reservation details\n7.Exit\n");
                ch = sc.nextInt();
                switch(ch){
                    case 1: System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.features(ch2);
                        break;
                    case 2:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.availability(ch2);
                        break;
                    case 3:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.bookroom(ch2);
                        break;
                    case 4:
                        System.out.print("\nRoom Number- ");
                        ch2 = sc.nextInt();
                        if(ch2>60)
                            System.out.println("Room doesn't exist");
                        else if(ch2>40)
                            Hotel.order(ch2-41,4);
                        else if(ch2>30)
                            Hotel.order(ch2-31,3);
                        else if(ch2>10)
                            Hotel.order(ch2-11,2);
                        else if(ch2>0)
                            Hotel.order(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 5:
                        System.out.print("\nRoom Number- ");
                        ch2 = sc.nextInt();
                        if(ch2>60)
                            System.out.println("Room doesn't exist");
                        else if(ch2>40)
                            Hotel.deallocate(ch2-41,4);
                        else if(ch2>30)
                            Hotel.deallocate(ch2-31,3);
                        else if(ch2>10)
                            Hotel.deallocate(ch2-11,2);
                        else if(ch2>0)
                            Hotel.deallocate(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 6:
                        System.out.print("\n=====================\nReservation details- \n======================\n\nEnter room number: ");
                        ch2 = sc.nextInt();
                        if(ch2>60)
                            System.out.println("Reservation doesn't exist");
                        else if(ch2>40)
                            Hotel.display(ch2-41,4);
                        else if(ch2>30)
                            Hotel.display(ch2-31,3);
                        else if(ch2>10)
                            Hotel.display(ch2-11,2);
                        else if(ch2>0)
                            Hotel.display(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 7:break x;

                }

                System.out.println("\nContinue : (y/n)");
                wish=sc.next().charAt(0);
                if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
                {
                    System.out.println("Invalid Option");
                    System.out.println("\nContinue : (y/n)");
                    wish=sc.next().charAt(0);
                }

            }while(wish=='y'||wish=='Y');

            Thread t=new Thread(String.valueOf(new write(Hotel.ob)));
            t.start();
        }
        catch(Exception e)
        {
            System.out.println("Not a valid input");
        }
    }
}