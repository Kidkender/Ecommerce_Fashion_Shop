package vn.sparkminds.be_ecommerce.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SizeTest {
    private Size size;

    @BeforeEach
    public void setup() {
        size = new Size("Small", 10);
    }

    @Test
    public void testGetname() {
        assertEquals("Small", size.getName());
    }

    @Test
    public void testSetName() {
        size.setName("Medium");
        assertEquals("Medium", size.getName());
    }

    @Test
    public void testGetQuantity() {
        assertEquals(10, size.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        size.setQuantity(20);
        assertEquals(20, size.getQuantity());
    }

}
