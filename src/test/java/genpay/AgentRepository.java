package genpay;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

/*@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AgentRepositoryTest {

    @Autowired
    AgentRepository agentRepository;

    @Test
    @Tag("fast") // Categorizes this test as "fast"
    @DisplayName("Test if the injection is working")
    void shouldBeanSetted() {
        assert (agentRepository != null);
    }

    //@Test
    void shouldDataBaseBeenPopulated() {
        assert (agentRepository.findAllBy().getFirst().name() == "John");
    }

    @Test
    @Tag("fast") // Categorizes this test as "fast"
    @DisplayName("Test if the database is populated")
    void shouldDataBaseBeenEmpty() {
        assert (agentRepository.findAllBy().isEmpty() == true);
    }
}
*/
