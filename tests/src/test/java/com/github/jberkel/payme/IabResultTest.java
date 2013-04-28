package com.github.jberkel.payme;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
public class IabResultTest {

    @Test public void shouldSupportEquals() throws Exception {
        assertThat(new IabResult(0, "FOO")).isEqualTo(new IabResult(0, "FOO"));
        assertThat(new IabResult(0, "FOO")).isNotEqualTo(new IabResult(0, "BAR"));
        assertThat(new IabResult(20, "FOO")).isNotEqualTo(new IabResult(0, "FOO"));
    }

    @Test public void testIsSuccess() {
        assertThat(new IabResult(0, "OK").isSuccess()).isTrue();
        assertThat(new IabResult(0, "OK").isFailure()).isFalse();

        assertThat(new IabResult(1, "FAIL").isSuccess()).isFalse();
        assertThat(new IabResult(1, "FAIL").isFailure()).isTrue();
    }
}