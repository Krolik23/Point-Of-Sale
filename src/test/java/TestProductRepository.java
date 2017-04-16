import model.Product;
import org.junit.Assert;
import org.junit.Test;
import repository.ProductRepository;
import repository.implementation.ProductRepositoryImpl;
import java.math.BigDecimal;

public class TestProductRepository {

    @Test
    public void testAddProductToRepositoryMethod(){
        ProductRepository productRepository = new ProductRepositoryImpl();
        productRepository.addProductToRepository(new Product("Test Product",new BigDecimal(9.99),
                "111"));

        Product expectedProduct = new Product("Test Product",new BigDecimal(9.99),
                "111");



        //Has product been added?
        Assert.assertTrue(productRepository.containsBarcode("111"));
        //Are values of product correct?
        Assert.assertEquals(expectedProduct, productRepository.getProductByBarcode("111"));
    }

    @Test
    public void shouldReturnProductWithGivenBarcode(){
        ProductRepository productRepository = new ProductRepositoryImpl();

        Product expectedProduct =
                new Product("Cola 0,3 ml", new BigDecimal(2.99),"1Dc4");

        //Is returned product as expected?
        Assert.assertEquals(expectedProduct, productRepository.getProductByBarcode("1Dc4"));
    }

    @Test
    public void shouldReturnTrueIfBarcodeInDB(){
        ProductRepository productRepository = new ProductRepositoryImpl();
        productRepository.addProductToRepository(new Product("Test Product",new BigDecimal(9.99),
                "111"));

        //If presence of barcode, checked correctly?
        Assert.assertTrue(productRepository.containsBarcode("111"));
    }






}
