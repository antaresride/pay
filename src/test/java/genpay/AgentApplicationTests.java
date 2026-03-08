package genpay;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class AgentApplicationTests {

    @Test
    @Tag("fast") // Categorizes this test as "fast"
    @DisplayName("Test if 1+1 = 2")
    void shouldBeanSetted() {
        assert (1 + 1 == 2);
    }
}
