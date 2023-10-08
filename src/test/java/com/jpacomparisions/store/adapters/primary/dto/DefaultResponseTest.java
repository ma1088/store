package com.jpacomparisions.store.adapters.primary.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DefaultResponseTest {
    @Test
    void test(){
        String data = "oi, tudo bem?";
        DefaultResponse defaultResponse = new DefaultResponse(data);
        assertNotNull(defaultResponse);
        assertEquals(data, defaultResponse.data());
    }
}
