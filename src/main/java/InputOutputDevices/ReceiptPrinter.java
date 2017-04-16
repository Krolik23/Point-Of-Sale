package InputOutputDevices;

import model.Product;

import java.text.NumberFormat;

public class ReceiptPrinter {

    public void printReceipt(Product[] listOfScannedProducts, double totalOfScannedProducts){
        System.out.println();
        System.out.println("---------------------------");
        System.out.println("RECEIPT:");
        System.out.println("---------------------------");

        for (Product scannedProduct : listOfScannedProducts) {
            System.out.format("%s %10s \n", scannedProduct.getNameOfProduct(),
                    NumberFormat.getCurrencyInstance().format(scannedProduct.getPriceOfProduct()));
        }
        System.out.println("\nTOTAL:\t\t" + NumberFormat.getCurrencyInstance().format(totalOfScannedProducts));
        System.out.println("---------------------------");
    }
}