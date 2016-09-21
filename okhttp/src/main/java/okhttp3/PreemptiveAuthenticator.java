/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package okhttp3;

import java.io.IOException;

/**
 *
 * Sends preemptive authentication to either a remote web server or a proxy server. Extends
 * the Authenticator interface in order to keep the same OKHttpClient members
 * (proxyAuthenticator and authenticator).
 *
 * <p>When authentication is sent to a web server, the implementation should alter the
 * request and set the "Authorization" header.
 * <pre>   {@code
 *
 *    String credential = Credentials.basic(...)
 *    return request.newBuilder()
 *        .header("Authorization", credential)
 *        .build();
 * }</pre>
 *
 * <p>When authentication is sent to a proxy server, the implementation should alter the
 * request and set the "Proxy-Authorization" header.
 * <pre>   {@code
 *
 *    String credential = Credentials.basic(...)
 *    return response.request().newBuilder()
 *        .header("Proxy-Authorization", credential)
 *        .build();
 * }</pre>
 *
 * <p>Applications may configure OkHttp with an authenticator for origin servers, or proxy servers,
 * or both.
 */
public interface PreemptiveAuthenticator extends Authenticator {

  /**
   * Returns a request that includes a credential to satisfy an authentication.
   */
  Request authenticate(Route route, Request request) throws IOException;
}
