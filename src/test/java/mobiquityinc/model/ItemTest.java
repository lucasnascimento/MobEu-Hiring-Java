package mobiquityinc.model;

import com.Item;
import com.mobiquityinc.exception.APIException;
import org.junit.Test;

public class ItemTest {

    @Test(expected = APIException.class)
    public void should_avoid_weigh_greater_than_100() throws APIException {
        new Item(1, 101.0f, 1.0f);
    }

    @Test(expected = APIException.class)
    public void should_avoid_cost_greater_than_100() throws APIException {
        new Item(1, 100.0f, 101.0f );
    }

}