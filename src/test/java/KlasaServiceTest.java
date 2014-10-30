import org.junit.AfterClass;
import org.junit.BeforeClass;

public class KlasaServiceTest {

    @BeforeClass
    public static void beforeClass() {
        TestUtilities.createTables();
    }

    @AfterClass
    public static void afterClass() {
        TestUtilities.deleteTables();
    }
}
