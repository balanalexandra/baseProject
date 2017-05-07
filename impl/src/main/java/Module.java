import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.sun.tracing.dtrace.ModuleName;

/**
 * Created by alex on 5/7/2017.
 */
public class Module extends AbstractModule {
        @Override
        protected void configure() {
            bind(IRateService.class).to(RateService.class).in(Singleton.class);
        }
}
