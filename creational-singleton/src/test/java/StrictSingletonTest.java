import com.zhy.EagerSingleton;
import org.junit.jupiter.api.Test;

public class StrictSingletonTest {
    @Test
    public void eagerSingletonTest() {
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();
        System.out.println(instance1 == instance2);

    }
}
