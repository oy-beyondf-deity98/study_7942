package ga.rugal;

import org.junit.Before;
import org.junit.Ignore;
import org.springframework.test.context.ContextConfiguration;

import ga.JUnitSpringTestBase;

/**
 *
 * @author rugal
 */
@ContextConfiguration(classes = config.ApplicationContext.class)
@Ignore
public abstract class DBTestBase extends JUnitSpringTestBase
{

	@Before
    public void setup()
    {
    	
    }
    
}
