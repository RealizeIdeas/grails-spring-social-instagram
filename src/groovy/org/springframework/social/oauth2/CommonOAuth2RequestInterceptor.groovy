package org.springframework.social.oauth2

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.support.HttpRequestDecorator
import org.springframework.social.oauth2.OAuth2Version;

/**
 * Created this class to handle situtation when lots of connections created and not closed because of HHTP Header does
 * not contain  "Connection":"close"
 *
 * @author Michael Astreiko
 */
class CommonOAuth2RequestInterceptor implements ClientHttpRequestInterceptor {
    private final String accessToken;

    private final OAuth2Version oauth2Version;

    public CommonOAuth2RequestInterceptor(String accessToken, OAuth2Version oauth2Version) {
        this.accessToken = accessToken;
        this.oauth2Version = oauth2Version;
    }

    public ClientHttpResponse intercept(final HttpRequest request, final byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        HttpRequest protectedResourceRequest = new HttpRequestDecorator(request);
        protectedResourceRequest.getHeaders().set("Authorization",
                oauth2Version.getAuthorizationHeaderValue(accessToken));
        protectedResourceRequest.getHeaders().set("Connection", "close");
        return execution.execute(protectedResourceRequest, body);
    }
}