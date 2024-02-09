import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


class holder implements Serializable
{
    Doubleroom arr1[]=new Doubleroom[10]; //Luxury
    Doubleroom arr2[]=new Doubleroom[20]; //Deluxe
    Singleroom arr3[]=new Singleroom[10]; //Luxury
    Singleroom arr4[]=new Singleroom[20]; //Deluxe
}