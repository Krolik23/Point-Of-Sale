package InputOutputDevices;

import model.Product;

import java.text.NumberFormat;

public class LCDDisplay {

    public void printProductOnLCD(Product product){
        System.out.println("\n***************LCD*********************");
        System.out.println("* " + product.getNameOfProduct() + "\t\t\t"
                +
                NumberFormat.getCurrencyInstance().format(product.getPriceOfProduct()));
        System.out.println("***************************************");
    }

    public void printTextOnLCD(String text){
        System.out.println("\n***************LCD*********************");
        System.out.println("* " + text);
        System.out.println("***************************************");
    }
}