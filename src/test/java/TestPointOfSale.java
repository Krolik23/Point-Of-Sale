import model.Product;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

import static org.hamcrest.Matchers.instanceOf;

public class TestPointOfSale {

    @Test
    public void shouldReturnTotalPriceOfProductsInDouble(){
        PointOfSale pointOfSale = new PointOfSale();
        Product[] testArray =
                {
                        new Product("Cola 0,3 ml", new BigDecimal(2.99), "1Dc4"),
                        new Product("Pizza", new BigDecimal(6.99), "9TY6"),
                        new Product("Eggs", new BigDecimal(3.99), "OC18")
                };
        double expectedTotal = 2.99d + 6.99d + 3.99d;

        //Is returned value of type double?
        Assert.assertThat(pointOfSale.getTotalOfScannedProducts(testArray), instanceOf(double.class));

        //Is total price of products counted correctly?
        Assert.assertEquals(expectedTotal, pointOfSale.getTotalOfScannedProducts(testArray), 1e-15);
    }
}