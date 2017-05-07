import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.hamcrest.Matchers.closeTo;
import static org.mockito.Mockito.when;


/**
 * Created by alex on 5/7/2017.
 */
public class IRateServiceTest {
    @Mock
    IRateService service;


    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
        when(service.getRateForCcy("EUR")).thenReturn(2.0);

    }

    @Test
    public void testRate(){
        Double eurRate = service.getRateForCcy("EUR");
        Assert.assertThat(eurRate, closeTo(2.0, 0.01));
    }
}
