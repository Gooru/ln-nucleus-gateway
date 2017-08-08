package org.gooru.nucleus.gateway.routes;

import java.util.*;
import java.util.Map.Entry;

import org.gooru.nucleus.gateway.constants.RouteConstants;

import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;

final class AnonymousACLVerifier {

    private AnonymousACLVerifier() {
        throw new AssertionError();
    }

    private final static List<String> ALLOWED_METHODS = Arrays.asList(HttpMethod.GET.name());
    private static final Map<String, List<String>> ROUTES;

    /**
     * This mapper constant have route suffix url and it's request methods which
     * are allowed by gateway using anonymous token.
     */
    static {
        Map<String, List<String>> routes = new HashMap<>();
        routes.put(RouteConstants.RT_CROSSWALK_CODES_GDFW, Arrays.asList(HttpMethod.POST.name()));
        routes.put(RouteConstants.RT_CROSSWALK_CODES_FW, Arrays.asList(HttpMethod.POST.name()));

        ROUTES = Collections.unmodifiableMap(routes);
    }

    static boolean hasPermit(HttpServerRequest httpServerRequest) {
        if (permittedBasedOnHttpMethod(httpServerRequest)) {
            return true;
        }
        return permittedBasedOnRouteAndHttpMethod(httpServerRequest);
    }

    private static boolean permittedBasedOnRouteAndHttpMethod(HttpServerRequest httpServerRequest) {
        final String path = httpServerRequest.path();
        for (Entry<String, List<String>> entry : ROUTES.entrySet()) {
            if (path.endsWith(entry.getKey()) && entry.getValue()
                .contains(httpServerRequest.method().name())) {
                return true;
            }
        }
        return false;
    }

    private static boolean permittedBasedOnHttpMethod(HttpServerRequest httpServerRequest) {
        return ALLOWED_METHODS.contains(httpServerRequest.method().name());
    }
}
