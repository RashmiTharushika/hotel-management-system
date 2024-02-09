import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


class Food
{
    int itemno;
    int quantity;
    float price;

    Food(int itemno,int quantity)
    {
        this.itemno=itemno;
        this.quantity=quantity;
        switch(itemno)
        {
            case 1:price=quantity*3;
                break;
            case 2:price=quantity*10;
                break;
            case 3:price=quantity*6;
                break;
            case 4:price=quantity*2;
                break;
        }
    }
}
