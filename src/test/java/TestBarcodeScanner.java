import InputOutputDevices.BarcodeScanner;
import model.Product;
import org.junit.Assert;
import org.junit.Test;
import repository.ProductRepository;
import repository.implementation.ProductRepositoryImpl;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;

public class TestBarcodeScanner {

    @Test
    public void testScanMethodWithRightBarcode(){
        ProductRepository productRepository = new ProductRepositoryImpl();
        productRepository.addProductToRepository(
                new Product("Test Product",new BigDecimal(9.99), "111"));

        BarcodeScanner testBarcodeScanner = new BarcodeScanner();
        Product expectedProduct = new Product("Test Product",new BigDecimal(9.99),
                "111");

        Assert.assertEquals("Method should return object equal to expectedProduct",expectedProduct,
                testBarcodeScanner.scan("111",productRepository));

    }

    @Test(expected = NoSuchElementException.class)
    public void testScanMethodWithUnknownBarcode(){
       ProductRepository productRepository = new ProductRepositoryImpl();

        BarcodeScanner testBarcodeScanner = new BarcodeScanner();
        testBarcodeScanner.scan("000",productRepository);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testScanMethodWithEmptyOrNullBarcode(){
        ProductRepository productRepository = new ProductRepositoryImpl();

        BarcodeScanner testBarcodeScanner = new BarcodeScanner();
        testBarcodeScanner.scan("",productRepository);
    }

    @Test
    public void shouldReturnArrayOfScannedProducts(){
        ProductRepository productRepository = new ProductRepositoryImpl();
        BarcodeScanner testBarcodeScanner = new BarcodeScanner();

        Product[] expectedArray =
                {
                        new Product("Cola 0,3 ml", new BigDecimal(2.99),"1Dc4"),
                        new Product("Pizza", new BigDecimal(6.99),"9TY6"),
                        new Product("Eggs", new BigDecimal(3.99),"OC18")
                };

        testBarcodeScanner.scan("1Dc4",productRepository);
        testBarcodeScanner.scan("9TY6",productRepository);
        testBarcodeScanner.scan("OC18",productRepository);

        Assert.assertArrayEquals("Should return array equal to expectedArray",
                expectedArray, testBarcodeScanner.getScannedProducts());

        //If array has this object?
        Assert.assertTrue(Arrays.asList(testBarcodeScanner.getScannedProducts())
                .contains(new Product("Cola 0,3 ml", new BigDecimal(2.99),"1Dc4")));

        //Check array size
        Assert.assertThat(testBarcodeScanner.getScannedProducts().length, is(3));
    }
}
