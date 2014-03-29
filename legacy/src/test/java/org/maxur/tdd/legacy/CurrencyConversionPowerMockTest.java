package org.maxur.tdd.legacy;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.reset;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 * @author Maxim Yunusov
 * @version 1.0 05.02.14
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({CurrencyConversion.class, DefaultHttpClient.class, HttpGet.class})
public class CurrencyConversionPowerMockTest {

    private final CurrencyConversion currencyConversion = PowerMockito.mock(CurrencyConversion.class);

    private DefaultHttpClient client = PowerMockito.mock(DefaultHttpClient.class);
    private HttpGet get = PowerMockito.mock(HttpGet.class);
    @Mock
    private HttpResponse response;
    @Mock
    private HttpEntity entity;

    final private InputStream bais = new ByteArrayInputStream(
            "<div id=\"converter_results\"><ul><li><b>1 USD = 0.98 EUR</b>"
                    .getBytes());

    @Before
    public void before() {
        reset(currencyConversion);
    }

    @Test
    public void returnExpectedConversion_v3() throws Exception {

        mockStatic(CurrencyConversion.class);

        when(CurrencyConversion.currencySymbols())
                .thenReturn(mapFrom("USD", "EUR"));
        when(CurrencyConversion.convertFromTo(any(String.class), any(String.class)))
                .thenCallRealMethod();
        whenNew(DefaultHttpClient.class).withNoArguments()
                .thenReturn(client);
        whenNew(HttpGet.class).withNoArguments()
                .thenReturn(get);
        when(client.execute(any(HttpUriRequest.class)))
                .thenReturn(response);
        when(response.getEntity())
                .thenReturn(entity);
        when(entity.getContent())
                .thenReturn(bais);

        BigDecimal result = CurrencyConversion.convertFromTo("USD", "EUR");
        assertThat(result.subtract(new BigDecimal(0.98)).abs(), is(lessThanOrEqualTo(new BigDecimal(0.001))));
        //noinspection AccessStaticViaInstance
        PowerMockito.verifyStatic();
        CurrencyConversion.currencySymbols();

    }


    private Map<String, String> mapFrom(String... keyValuePairs) {
        Map<String, String> result = new ConcurrentHashMap<>();
        for (String keyValuePair : keyValuePairs) {
            result.put(keyValuePair, keyValuePair);
        }
        return result;
    }

}
