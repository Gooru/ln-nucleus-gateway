package org.gooru.nucleus.gateway.routes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.gooru.nucleus.gateway.constants.RouteConstants;

import com.hazelcast.util.collection.ArrayUtils;

import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;

class AnonymousACLVerifier {

    private final static String[] allowedMethods = new String[] { HttpMethod.GET.name() };
    private static final Map<String, String[]> ROUTES;

    /**
     * This mapper constant have route suffix url and it's request methods which
     * are allowed by gateway using anonymous token.
     */
    static {
        Map<String, String[]> routes = new HashMap<>();
        routes.put(RouteConstants.RT_CROSSWALK_CODES_GDFW, new String[] { HttpMethod.POST.name() });
        routes.put(RouteConstants.RT_CROSSWALK_CODES_FW, new String[] { HttpMethod.POST.name() });
        ROUTES = Collections.unmodifiableMap(routes);
    }

    protected static boolean hasPermit(HttpServerRequest httpServerRequest) {
        if (ArrayUtils.contains(allowedMethods, httpServerRequest.method().name())) {
            return true;
        }
        for (Entry<String, String[]> entry : ROUTES.entrySet()) {
            if (httpServerRequest.path().endsWith(entry.getKey())
                && ArrayUtils.contains(entry.getValue(), httpServerRequest.method().name())) {
                return true;
            }
        }
        return false;
    }

}
