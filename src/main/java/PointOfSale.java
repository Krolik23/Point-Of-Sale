import InputOutputDevices.BarcodeScanner;
import InputOutputDevices.LCDDisplay;
import InputOutputDevices.ReceiptPrinter;
import model.Product;
import repository.ProductRepository;
import repository.implementation.ProductRepositoryImpl;

import java.text.NumberFormat;
import java.util.NoSuchElementException;

public class PointOfSale {
    private ProductRepository productRepository = new ProductRepositoryImpl();
    private BarcodeScanner barcodeScanner = new BarcodeScanner();
    private LCDDisplay lcdDisplay = new LCDDisplay();
    private ReceiptPrinter receiptPrinter = new ReceiptPrinter();

    public void scanAndShowOnLCD(String barcode){
        try {
            Product product = barcodeScanner.scan(barcode, productRepository);
            lcdDisplay.printProductOnLCD(product);
        }
        catch(IllegalArgumentException | NoSuchElementException ex){
            lcdDisplay.printTextOnLCD(ex.getMessage());
        }
    }

    public void printReceipt(){
        double totalOfScannedProducts = getTotalOfScannedProducts(barcodeScanner.getScannedProducts());
        receiptPrinter.printReceipt(barcodeScanner.getScannedProducts(), totalOfScannedProducts);
    }

    public void printTotalOnLCD(){
        Double total = getTotalOfScannedProducts(barcodeScanner.getScannedProducts());
        lcdDisplay.printTextOnLCD("Total to pay:\t\t" + NumberFormat.getCurrencyInstance().format(total));
    }

    public double getTotalOfScannedProducts(Product[] products){
        double total = 0d;
        for(Product product : products){
            total += product.getPriceOfProduct().doubleValue();
        }
        return total;
    }
}