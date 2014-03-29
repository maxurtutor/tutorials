package org.maxur.tdd.legacy;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.integration.junit4.JMockit;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Maxim Yunusov
 * @version 1.0 05.02.14
 */
@RunWith(JMockit.class)
public class CurrencyConversionJMockitTest {

    @Mocked
    private DefaultHttpClient httpclient;
    @Mocked
    private HttpResponse response;
    @Mocked
    private HttpEntity entity;

    final private InputStream bais = new ByteArrayInputStream(
            "<div id=\"converter_results\"><ul><li><b>1 USD = 0.98 EUR</b>"
                    .getBytes());

    @Test
    public void returnExpectedConversion_v2() throws Exception {
        new NonStrictExpectations(CurrencyConversion.class) {
            {
                CurrencyConversion.currencySymbols();
                result = mapFrom("USD", "EUR");
            }
        };
        new NonStrictExpectations() {
            {
                httpclient.execute((HttpUriRequest) any);
                result = response;
                response.getEntity();
                result = entity;
                entity.getContent();
                result = bais;
            }
        };

        BigDecimal result = CurrencyConversion.convertFromTo("USD", "EUR");
        assertThat(result.subtract(new BigDecimal(0.98)).abs(), is(lessThanOrEqualTo(new BigDecimal(0.001))));

    }

    private Map<String, String> mapFrom(String... keyValuePairs) {
        Map<String, String> result = new ConcurrentHashMap<>();
        for (String keyValuePair : keyValuePairs) {
            result.put(keyValuePair, keyValuePair);
        }
        return result;
    }

}
