import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
       PointOfSale pointOfSale = new PointOfSale();

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       try {
            System.out.println("========================================================================================");
            System.out.println("1. In order to scan product, type a barcode and hit enter. \n2. Type \"exit\" to print a receipt");
            System.out.println("   \nExample barcodes: \t 9TY6\t 36RE\t 1Dc4");
            System.out.println("========================================================================================");
            System.out.println("\n***************LCD*********************");
            System.out.println("* " + "-------\t\t" + "-- zł");
            System.out.println("***************************************");
            for (;;) {
                System.out.print("Scanner: ");
                String barcodeScanner = br.readLine();

                if(barcodeScanner.equals("exit")){
                    System.out.print("\n\n");
                    pointOfSale.printTotalOnLCD();
                    pointOfSale.printReceipt();
                    break;
                }
                else{
                    System.out.print("\n\n");
                    pointOfSale.scanAndShowOnLCD(barcodeScanner);
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}