package repository.implementation;

import model.Product;
import repository.ProductRepository;

import java.math.BigDecimal;
import java.util.HashMap;

public class ProductRepositoryImpl implements ProductRepository {
    private HashMap<String, Product> productRepository = new HashMap<>();

    public ProductRepositoryImpl(){
        productRepository.put("1Dc4", new Product("Cola 0,3 ml", new BigDecimal(2.99),"1Dc4"));
        productRepository.put("9TY6", new Product("Pizza", new BigDecimal(6.99),"9TY6"));
        productRepository.put("OC18", new Product("Eggs", new BigDecimal(3.99),"OC18"));
        productRepository.put("36RE", new Product("Chocolate 100g", new BigDecimal(1.99),"36RE"));
        productRepository.put("N3F7", new Product("Bread", new BigDecimal(2.49),"N3F7"));
    }

    @Override
    public void addProductToRepository(Product product){
        productRepository.put(product.getBarCode(),product);
    }

    @Override
    public Product getProductByBarcode(String barcode){
        return productRepository.get(barcode);
    }

    @Override
    public Boolean containsBarcode(String barcode) {
        return productRepository.containsKey(barcode);
    }

}





















