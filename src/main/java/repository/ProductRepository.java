package repository;

import model.Product;

public interface ProductRepository {
    void addProductToRepository(Product product);
    Product getProductByBarcode(String barcode);
    Boolean containsBarcode(String barcode);







}
