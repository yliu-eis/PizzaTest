import static org.junit.Assert.assertEquals;

import com.ebsco.designingtests.Side;
import com.ebsco.designingtests.Topping;
import com.ebsco.designingtests.ToppingImpl;
import com.ebsco.designingtests.ToppingType;
import org.junit.Test;

public class ToppingTest {

    @Test
    public void testTopping(){
        for(Side side : Side.values()) {
            for(ToppingType type : ToppingType.values()) {
                Topping topping = new ToppingImpl(side, type);
                assertEquals(side, topping.getSide());
                assertEquals(type, topping.getType());
            }
        }
    }

}
