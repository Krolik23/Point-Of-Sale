package InputOutputDevices;

import model.Product;
import repository.ProductRepository;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BarcodeScanner {
    private ArrayList<Product> scannedProducts= new ArrayList<>();

    public Product scan(String barcode, ProductRepository productRepository){

        if(barcode != null && !barcode.isEmpty()){
            if(productRepository.containsBarcode(barcode)){
                Product product = productRepository.getProductByBarcode(barcode);
                scannedProducts.add(product);
                return product;
            }
            else{
                throw new NoSuchElementException("Product not found");
            }
        }
        else{
            throw new IllegalArgumentException("Invalid barcode");
        }
    }
    public Product[] getScannedProducts(){
        return scannedProducts.toArray(new Product[scannedProducts.size()]);
    }
}