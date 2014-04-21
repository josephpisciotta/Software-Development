/**
 * This is the test class that runs all our test cases
 * 
 * @author josephpisciotta
 */
package charlie.tests.advisor;

import charlie.tests.advisor.section1.*;
import charlie.tests.advisor.section2.*;
import charlie.tests.advisor.section3.*;
import charlie.tests.advisor.section4.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    // Section 1
    TestAdvice00_12_2.class,
    TestAdvice00_12_7.class,
    TestAdvice01_12_2.class,
    TestAdvice01_12_7.class,
    
    // Section 2
    TestAdvice00_5_2.class,
    TestAdvice00_5_7.class,
    TestAdvice01_5_2.class,
    TestAdvice01_5_7.class,
    
    // Section 3
    TestAdvice00_A2_6.class,
    TestAdvice00_A2_7.class,
    TestAdvice01_A2_6.class,
    TestAdvice01_A2_7.class,
    
    // Section 4
    TestAdvice00_22_2.class,
    TestAdvice00_22_7.class,
    TestAdvice01_22_2.class,
    TestAdvice01_22_7.class
})
/**
 *
 * @author josephpisciotta
 */
public class AdvisorTest {

    public AdvisorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
