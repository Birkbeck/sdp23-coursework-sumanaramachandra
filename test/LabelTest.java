import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sml.Labels;

public class LabelTest {

    private Labels l;

    @BeforeEach
    void setUp() {
        l = new Labels();
        l.addLabel("f1", 10);
        l.addLabel("f2", 20);
        l.addLabel("f3", 30);
        l.addLabel("f4", 40);
        //...
    }

    @AfterEach
    void tearDown() {
        l = null;
    }

    @Test
    void executePrint() {
        Assertions.assertEquals("[f1 -> 10, f2 -> 20, f3 -> 30, f4 -> 40]", l.toString());
    }

    @Test
    void executeNullPointerCheck() {
        String testLab = "f5";
        NullPointerException n = Assertions.assertThrows(NullPointerException.class, () -> l.getAddress(testLab));
        Assertions.assertEquals("Label cannot be null" , n.getMessage());
    }

    @Test
    void executeDuplicateLabelCheck() {
        String testLab = "f1";
        IllegalArgumentException i = Assertions.assertThrows(IllegalArgumentException.class, () -> l.addLabel(testLab, 90));
        Assertions.assertEquals(testLab + " already exists", i.getMessage());
    }

}
