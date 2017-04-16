package model;

import java.math.BigDecimal;

public class Product {
    private final String barCodeNumber;
    private String nameOfProduct;
    private BigDecimal priceOfProduct;

    public Product(String nameOfProduct, BigDecimal priceOfProduct, String barCodeNumber){
        this.nameOfProduct = nameOfProduct;
        this.priceOfProduct = priceOfProduct;
        this.barCodeNumber = barCodeNumber;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public BigDecimal getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(BigDecimal priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public String getBarCode() {
        return barCodeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (barCodeNumber != null ? !barCodeNumber.equals(product.barCodeNumber) : product.barCodeNumber != null)
            return false;
        if (nameOfProduct != null ? !nameOfProduct.equals(product.nameOfProduct) : product.nameOfProduct != null)
            return false;
        return priceOfProduct != null ? priceOfProduct.equals(product.priceOfProduct) : product.priceOfProduct == null;
    }

    @Override
    public int hashCode() {
        int result = barCodeNumber != null ? barCodeNumber.hashCode() : 0;
        result = 31 * result + (nameOfProduct != null ? nameOfProduct.hashCode() : 0);
        result = 31 * result + (priceOfProduct != null ? priceOfProduct.hashCode() : 0);
        return result;
    }
}