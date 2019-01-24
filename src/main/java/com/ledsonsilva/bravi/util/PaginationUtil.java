package com.ledsonsilva.bravi.util;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;

/**
 * Utility class for handling pagination.
 */
public class PaginationUtil {
    public static HttpHeaders generatePaginationHttpHeaders(Page<?> page) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", "" + page.getTotalElements());
        return headers;
    }
}
