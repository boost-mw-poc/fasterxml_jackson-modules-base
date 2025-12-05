package tools.jackson.module.afterburner.tofix;

import org.junit.jupiter.api.Test;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.module.afterburner.AfterburnerTestBase;
import tools.jackson.module.afterburner.testutil.failure.JacksonTestFailureExpected;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Reported as: https://github.com/FasterXML/jackson-modules-base/issues/314
// but does not seem to fail as expected
public class AfterburnerGenericInterface314Test extends AfterburnerTestBase
{
    public interface A314<T> {
        T getBody();
    }

    public static class MD314 implements A314<String> {
        private String body;

        public MD314(String b) {
            body = b;
        }

        @Override
        public String getBody() {
            return body;
        }
    }

    //@JacksonTestFailureExpected
    @Test
    public void testMapperAfterUse() throws Exception
    {
        final ObjectMapper mapper = newAfterburnerMapper();
        String json = mapper.writeValueAsString(new MD314("test"));
        assertEquals("{\"body\":\"test\"}", json);
    }
}
