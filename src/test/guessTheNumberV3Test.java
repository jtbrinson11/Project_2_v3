import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class guessTheNumberV3Test {

    guessTheNumberV3 gtn3;

    @BeforeEach
    void setUp() {
        gtn3 = new guessTheNumberV3();
    }

    @Test
    void setName() {
        gtn3.setName("test");
        assertEquals("test", gtn3.name, "setName() failed");
    }

    @Test
    void getName() {
        gtn3.setName("test1");
        String nameTest = gtn3.getName();
        assertEquals("test1", nameTest, "getName() failed");
    }

    @Test
    void setNum() {
        gtn3.setNum(10);
        assertEquals(10, gtn3.num, "setNum() failed");
    }

    @Test
    void getNum() {
        gtn3.setNum(11);
        int numTest = gtn3.getNum();
        assertEquals(11, numTest, "getNum() failed");
    }

    @AfterEach
    void tearDown() {
    }
}