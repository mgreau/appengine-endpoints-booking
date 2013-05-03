/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This file was generated.
 *  with google-apis-code-generator 1.2.0 (build: 2012-10-03 02:48:15 UTC)
 *  on 2012-10-16 at 21:43:19 UTC 
 */

package com.appspot.api.services.bookingendpoint;

import com.google.api.client.googleapis.services.GoogleClient;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpMethod;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.json.JsonHttpRequest;
import com.google.api.client.http.json.JsonHttpRequestInitializer;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.common.base.Preconditions;

import java.io.IOException;

/**
 * Service definition for Bookingendpoint (v1).
 *
 * <p>
 * 
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link JsonHttpRequestInitializer} to initialize global parameters via its
 * {@link Builder}. Sample usage:
 * </p>
 *
 * <pre>
  public class BookingendpointRequestInitializer implements JsonHttpRequestInitializer {
      public void initialize(JsonHttpRequest request) {
        BookingendpointRequest bookingendpointRequest = (BookingendpointRequest)request;
        bookingendpointRequest.setPrettyPrint(true);
        bookingendpointRequest.setKey(ClientCredentials.KEY);
    }
  }
 * </pre>
 *
 * @since 1.3.0
 * @author Google, Inc.
 */
public class Bookingendpoint extends GoogleClient {

  /**
   * The default encoded base path of the service. This is determined when the library is generated
   * and normally should not be changed.
   * @deprecated (scheduled to be removed in 1.8) Use "/" + {@link #DEFAULT_SERVICE_PATH}.
   */
  @Deprecated
  public static final String DEFAULT_BASE_PATH = "/_ah/api/bookingendpoint/v1/";

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://cloud-booking.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "bookingendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Construct a Bookingendpoint instance to connect to the Bookingendpoint service.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport The transport to use for requests
   * @param jsonFactory A factory for creating JSON parsers and serializers
   * @deprecated (scheduled to be removed in 1.8) Use
   *             {@link #Bookingendpoint(HttpTransport, JsonFactory, HttpRequestInitializer)}.
   */
  @Deprecated
  public Bookingendpoint(HttpTransport transport, JsonFactory jsonFactory) {
    super(transport, jsonFactory, DEFAULT_BASE_URL);
  }

  /**
   * Construct a Bookingendpoint instance to connect to the Bookingendpoint service.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport The transport to use for requests
   * @param jsonFactory A factory for creating JSON parsers and serializers
   * @param httpRequestInitializer The HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Bookingendpoint(HttpTransport transport, JsonFactory jsonFactory,
      HttpRequestInitializer httpRequestInitializer) {
    super(transport, jsonFactory, DEFAULT_ROOT_URL, DEFAULT_SERVICE_PATH, httpRequestInitializer);
  }

  /**
   * Construct a Bookingendpoint instance to connect to the Bookingendpoint service.
   *
   * @param transport The transport to use for requests
   * @param jsonHttpRequestInitializer The initializer to use when creating an JSON HTTP request
   * @param httpRequestInitializer The initializer to use when creating an {@link HttpRequest}
   * @param jsonFactory A factory for creating JSON parsers and serializers
   * @param jsonObjectParser JSON parser to use or {@code null} if unused
   * @param baseUrl The base URL of the service on the server
   * @param applicationName The application name to be sent in the User-Agent header of requests
   */
  @Deprecated
  Bookingendpoint(
      HttpTransport transport,
      JsonHttpRequestInitializer jsonHttpRequestInitializer,
      HttpRequestInitializer httpRequestInitializer,
      JsonFactory jsonFactory,
      JsonObjectParser jsonObjectParser,
      String baseUrl,
      String applicationName) {
      super(transport,
          jsonHttpRequestInitializer,
          httpRequestInitializer,
          jsonFactory,
          jsonObjectParser,
          baseUrl,
          applicationName);
  }

  /**
   * Construct a Bookingendpoint instance to connect to the Bookingendpoint service.
   *
   * @param transport The transport to use for requests
   * @param jsonHttpRequestInitializer The initializer to use when creating an JSON HTTP request
   * @param httpRequestInitializer The initializer to use when creating an {@link HttpRequest}
   * @param jsonFactory A factory for creating JSON parsers and serializers
   * @param jsonObjectParser JSON parser to use or {@code null} if unused
   * @param rootUrl The root URL of the service on the server
   * @param servicePath The service path of the service on the server
   * @param applicationName The application name to be sent in the User-Agent header of requests
   * @param suppressPatternChecks whether discovery pattern checks should be suppressed on required
   *        parameters
   */
  Bookingendpoint(
      HttpTransport transport,
      JsonHttpRequestInitializer jsonHttpRequestInitializer,
      HttpRequestInitializer httpRequestInitializer,
      JsonFactory jsonFactory,
      JsonObjectParser jsonObjectParser,
      String rootUrl,
      String servicePath,
      String applicationName,
      boolean suppressPatternChecks) {
      super(transport,
          jsonHttpRequestInitializer,
          httpRequestInitializer,
          jsonFactory,
          jsonObjectParser,
          rootUrl,
          servicePath,
          applicationName,
          suppressPatternChecks);
  }

  @Override
  protected void initialize(JsonHttpRequest jsonHttpRequest) throws IOException {
    super.initialize(jsonHttpRequest);
  }

  /**
   * Returns an instance of a new builder.
   *
   * @param transport The transport to use for requests
   * @param jsonFactory A factory for creating JSON parsers and serializers
   * @deprecated (scheduled to removed in 1.8) Use
   *             {@link Builder#Builder(HttpTransport, JsonFactory, HttpRequestInitializer)}.
   */
   @Deprecated
   public static Builder builder(HttpTransport transport, JsonFactory jsonFactory) {
     return new Builder(transport, jsonFactory, new GenericUrl(DEFAULT_BASE_URL));
   }

  /**
   * An accessor for creating requests from the Hotels collection.
   *
   * The typical use is:<pre>
   *   {@code Bookingendpoint bookingendpoint = new Bookingendpoint(...);}
   *   {@code Bookingendpoint.Hotels.List request = bookingendpoint.hotels().list(parameters ...)}</pre>
   *
   * @return the resource collection
   */
  public Hotels hotels() {
    return new Hotels();
  }

  /**
   * The "hotels" collection of methods.
   */
  public class Hotels {

    /**
     * Create a request for the method "hotels.insert".
     *
     * This request holds the parameters needed by the the bookingendpoint server.  After setting any
     * optional parameters, call the {@link Insert#execute()} method to invoke the remote operation.
     *
     * @param content the {@link com.appspot.api.services.bookingendpoint.model.Hotel}
     * @return the request
     * @throws IOException if the initialization of the request fails
     */
    public Insert insert(com.appspot.api.services.bookingendpoint.model.Hotel content) throws IOException {
      Insert result = new Insert(content);
      initialize(result);
      return result;
    }

    public class Insert extends BookingendpointRequest {

      private static final String REST_PATH = "hotel";

      /**
       * Internal constructor.  Use the convenience method instead.
       */
      Insert(com.appspot.api.services.bookingendpoint.model.Hotel content) {
        super(Bookingendpoint.this, HttpMethod.POST, REST_PATH, content);
        Preconditions.checkNotNull(content);
      }

      /**
       * Sends the "insert" request to the Bookingendpoint server.
       *
       * @return the {@link com.appspot.api.services.bookingendpoint.model.Hotel} response
       * @throws IOException if the request fails
       */
      public com.appspot.api.services.bookingendpoint.model.Hotel execute() throws IOException {
        HttpResponse response = executeUnparsed();
        com.appspot.api.services.bookingendpoint.model.Hotel result = response.parseAs(
            com.appspot.api.services.bookingendpoint.model.Hotel.class);
        result.setResponseHeaders(response.getHeaders());
        return result;
      }

      /**
       * Queues the "insert" request to the Bookingendpoint server into the given batch request.
       *
       * <p>
       * Example usage:
       * </p>
       *
       * <pre>
         request.queue(batchRequest, new JsonBatchCallback&lt;Hotel&gt;() {

           public void onSuccess(Hotel content, GoogleHeaders responseHeaders) {
             log("Success");
           }

           public void onFailure(GoogleJsonError e, GoogleHeaders responseHeaders) {
             log(e.getMessage());
           }
         });
       * </pre>
       *
       * @param batch a single batch of requests
       * @param callback batch callback
       * @since 1.6
       */
      public void queue(com.google.api.client.googleapis.batch.BatchRequest batch,
          com.google.api.client.googleapis.batch.json.JsonBatchCallback<com.appspot.api.services.bookingendpoint.model.Hotel> callback)
          throws IOException {
        batch.queue(buildHttpRequest(), com.appspot.api.services.bookingendpoint.model.Hotel.class,
            com.google.api.client.googleapis.json.GoogleJsonErrorContainer.class, callback);
      }

      /**
       * @since 1.7
       */
      @Override
      public Insert setFields(String fields) {
        super.setFields(fields);
        return this;
      }

    }
    /**
     * Create a request for the method "hotels.search".
     *
     * This request holds the parameters needed by the the bookingendpoint server.  After setting any
     * optional parameters, call the {@link Search#execute()} method to invoke the remote operation.
     *
     * @param term
     * @return the request
     * @throws IOException if the initialization of the request fails
     */
    public Search search(String term) throws IOException {
      Search result = new Search(term);
      initialize(result);
      return result;
    }

    public class Search extends BookingendpointRequest {

      private static final String REST_PATH = "searchHotel/{term}";

      /**
       * Internal constructor.  Use the convenience method instead.
       */
      Search(String term) {
        super(Bookingendpoint.this, HttpMethod.GET, REST_PATH, null);
        this.term = Preconditions.checkNotNull(term, "Required parameter term must be specified.");
      }

      /**
       * Sends the "search" request to the Bookingendpoint server.
       *
       * @return the {@link com.appspot.api.services.bookingendpoint.model.Hotels} response
       * @throws IOException if the request fails
       */
      public com.appspot.api.services.bookingendpoint.model.Hotels execute() throws IOException {
        HttpResponse response = executeUnparsed();
        com.appspot.api.services.bookingendpoint.model.Hotels result = response.parseAs(
            com.appspot.api.services.bookingendpoint.model.Hotels.class);
        result.setResponseHeaders(response.getHeaders());
        return result;
      }

      /**
       * Queues the "search" request to the Bookingendpoint server into the given batch request.
       *
       * <p>
       * Example usage:
       * </p>
       *
       * <pre>
         request.queue(batchRequest, new JsonBatchCallback&lt;Hotels&gt;() {

           public void onSuccess(Hotels content, GoogleHeaders responseHeaders) {
             log("Success");
           }

           public void onFailure(GoogleJsonError e, GoogleHeaders responseHeaders) {
             log(e.getMessage());
           }
         });
       * </pre>
       *
       * @param batch a single batch of requests
       * @param callback batch callback
       * @since 1.6
       */
      public void queue(com.google.api.client.googleapis.batch.BatchRequest batch,
          com.google.api.client.googleapis.batch.json.JsonBatchCallback<com.appspot.api.services.bookingendpoint.model.Hotels> callback)
          throws IOException {
        batch.queue(buildHttpRequest(), com.appspot.api.services.bookingendpoint.model.Hotels.class,
            com.google.api.client.googleapis.json.GoogleJsonErrorContainer.class, callback);
      }

      /**
       * @since 1.7
       */
      @Override
      public Search setFields(String fields) {
        super.setFields(fields);
        return this;
      }

      @com.google.api.client.util.Key
      private String term;

      /**

       */
      public String getTerm() {
        return term;
      }

      public Search setTerm(String term) {
        this.term = term;
        return this;
      }

    }
    /**
     * Create a request for the method "hotels.get".
     *
     * This request holds the parameters needed by the the bookingendpoint server.  After setting any
     * optional parameters, call the {@link Get#execute()} method to invoke the remote operation.
     *
     * @param id
     * @return the request
     * @throws IOException if the initialization of the request fails
     */
    public Get get(String id) throws IOException {
      Get result = new Get(id);
      initialize(result);
      return result;
    }

    public class Get extends BookingendpointRequest {

      private static final String REST_PATH = "hotel/{id}";

      /**
       * Internal constructor.  Use the convenience method instead.
       */
      Get(String id) {
        super(Bookingendpoint.this, HttpMethod.GET, REST_PATH, null);
        this.id = Preconditions.checkNotNull(id, "Required parameter id must be specified.");
      }

      /**
       * Sends the "get" request to the Bookingendpoint server.
       *
       * @return the {@link com.appspot.api.services.bookingendpoint.model.Hotel} response
       * @throws IOException if the request fails
       */
      public com.appspot.api.services.bookingendpoint.model.Hotel execute() throws IOException {
        HttpResponse response = executeUnparsed();
        com.appspot.api.services.bookingendpoint.model.Hotel result = response.parseAs(
            com.appspot.api.services.bookingendpoint.model.Hotel.class);
        result.setResponseHeaders(response.getHeaders());
        return result;
      }

      /**
       * Queues the "get" request to the Bookingendpoint server into the given batch request.
       *
       * <p>
       * Example usage:
       * </p>
       *
       * <pre>
         request.queue(batchRequest, new JsonBatchCallback&lt;Hotel&gt;() {

           public void onSuccess(Hotel content, GoogleHeaders responseHeaders) {
             log("Success");
           }

           public void onFailure(GoogleJsonError e, GoogleHeaders responseHeaders) {
             log(e.getMessage());
           }
         });
       * </pre>
       *
       * @param batch a single batch of requests
       * @param callback batch callback
       * @since 1.6
       */
      public void queue(com.google.api.client.googleapis.batch.BatchRequest batch,
          com.google.api.client.googleapis.batch.json.JsonBatchCallback<com.appspot.api.services.bookingendpoint.model.Hotel> callback)
          throws IOException {
        batch.queue(buildHttpRequest(), com.appspot.api.services.bookingendpoint.model.Hotel.class,
            com.google.api.client.googleapis.json.GoogleJsonErrorContainer.class, callback);
      }

      /**
       * @since 1.7
       */
      @Override
      public Get setFields(String fields) {
        super.setFields(fields);
        return this;
      }

      @com.google.api.client.util.Key
      private String id;

      /**

       */
      public String getId() {
        return id;
      }

      public Get setId(String id) {
        this.id = id;
        return this;
      }

    }
    /**
     * Create a request for the method "hotels.list".
     *
     * This request holds the parameters needed by the the bookingendpoint server.  After setting any
     * optional parameters, call the {@link List#execute()} method to invoke the remote operation.
     *
     * @return the request
     * @throws IOException if the initialization of the request fails
     */
    public List list() throws IOException {
      List result = new List();
      initialize(result);
      return result;
    }

    public class List extends BookingendpointRequest {

      private static final String REST_PATH = "hotel";

      /**
       * Internal constructor.  Use the convenience method instead.
       */
      List() {
        super(Bookingendpoint.this, HttpMethod.GET, REST_PATH, null);
      }

      /**
       * Sends the "list" request to the Bookingendpoint server.
       *
       * @return the {@link com.appspot.api.services.bookingendpoint.model.CollectionResponseHotel} response
       * @throws IOException if the request fails
       */
      public com.appspot.api.services.bookingendpoint.model.CollectionResponseHotel execute() throws IOException {
        HttpResponse response = executeUnparsed();
        com.appspot.api.services.bookingendpoint.model.CollectionResponseHotel result = response.parseAs(
            com.appspot.api.services.bookingendpoint.model.CollectionResponseHotel.class);
        result.setResponseHeaders(response.getHeaders());
        return result;
      }

      /**
       * Queues the "list" request to the Bookingendpoint server into the given batch request.
       *
       * <p>
       * Example usage:
       * </p>
       *
       * <pre>
         request.queue(batchRequest, new JsonBatchCallback&lt;CollectionResponseHotel&gt;() {

           public void onSuccess(CollectionResponseHotel content, GoogleHeaders responseHeaders) {
             log("Success");
           }

           public void onFailure(GoogleJsonError e, GoogleHeaders responseHeaders) {
             log(e.getMessage());
           }
         });
       * </pre>
       *
       * @param batch a single batch of requests
       * @param callback batch callback
       * @since 1.6
       */
      public void queue(com.google.api.client.googleapis.batch.BatchRequest batch,
          com.google.api.client.googleapis.batch.json.JsonBatchCallback<com.appspot.api.services.bookingendpoint.model.CollectionResponseHotel> callback)
          throws IOException {
        batch.queue(buildHttpRequest(), com.appspot.api.services.bookingendpoint.model.CollectionResponseHotel.class,
            com.google.api.client.googleapis.json.GoogleJsonErrorContainer.class, callback);
      }

      /**
       * @since 1.7
       */
      @Override
      public List setFields(String fields) {
        super.setFields(fields);
        return this;
      }

      @com.google.api.client.util.Key
      private String cursor;

      /**

       */
      public String getCursor() {
        return cursor;
      }

      public List setCursor(String cursor) {
        this.cursor = cursor;
        return this;
      }

      @com.google.api.client.util.Key
      private Integer limit;

      /**

       */
      public Integer getLimit() {
        return limit;
      }

      public List setLimit(Integer limit) {
        this.limit = limit;
        return this;
      }

    }
    /**
     * Create a request for the method "hotels.update".
     *
     * This request holds the parameters needed by the the bookingendpoint server.  After setting any
     * optional parameters, call the {@link Update#execute()} method to invoke the remote operation.
     *
     * @param content the {@link com.appspot.api.services.bookingendpoint.model.Hotel}
     * @return the request
     * @throws IOException if the initialization of the request fails
     */
    public Update update(com.appspot.api.services.bookingendpoint.model.Hotel content) throws IOException {
      Update result = new Update(content);
      initialize(result);
      return result;
    }

    public class Update extends BookingendpointRequest {

      private static final String REST_PATH = "hotel";

      /**
       * Internal constructor.  Use the convenience method instead.
       */
      Update(com.appspot.api.services.bookingendpoint.model.Hotel content) {
        super(Bookingendpoint.this, HttpMethod.PUT, REST_PATH, content);
        Preconditions.checkNotNull(content);
      }

      /**
       * Sends the "update" request to the Bookingendpoint server.
       *
       * @return the {@link com.appspot.api.services.bookingendpoint.model.Hotel} response
       * @throws IOException if the request fails
       */
      public com.appspot.api.services.bookingendpoint.model.Hotel execute() throws IOException {
        HttpResponse response = executeUnparsed();
        com.appspot.api.services.bookingendpoint.model.Hotel result = response.parseAs(
            com.appspot.api.services.bookingendpoint.model.Hotel.class);
        result.setResponseHeaders(response.getHeaders());
        return result;
      }

      /**
       * Queues the "update" request to the Bookingendpoint server into the given batch request.
       *
       * <p>
       * Example usage:
       * </p>
       *
       * <pre>
         request.queue(batchRequest, new JsonBatchCallback&lt;Hotel&gt;() {

           public void onSuccess(Hotel content, GoogleHeaders responseHeaders) {
             log("Success");
           }

           public void onFailure(GoogleJsonError e, GoogleHeaders responseHeaders) {
             log(e.getMessage());
           }
         });
       * </pre>
       *
       * @param batch a single batch of requests
       * @param callback batch callback
       * @since 1.6
       */
      public void queue(com.google.api.client.googleapis.batch.BatchRequest batch,
          com.google.api.client.googleapis.batch.json.JsonBatchCallback<com.appspot.api.services.bookingendpoint.model.Hotel> callback)
          throws IOException {
        batch.queue(buildHttpRequest(), com.appspot.api.services.bookingendpoint.model.Hotel.class,
            com.google.api.client.googleapis.json.GoogleJsonErrorContainer.class, callback);
      }

      /**
       * @since 1.7
       */
      @Override
      public Update setFields(String fields) {
        super.setFields(fields);
        return this;
      }

    }
    /**
     * Create a request for the method "hotels.patch".
     *
     * This request holds the parameters needed by the the bookingendpoint server.  After setting any
     * optional parameters, call the {@link Patch#execute()} method to invoke the remote operation.
     *
     * @param id
     * @return the request
     * @throws IOException if the initialization of the request fails
     */
    public Patch patch(String id) throws IOException {
      Patch result = new Patch(id);
      initialize(result);
      return result;
    }

    public class Patch extends BookingendpointRequest {

      private static final String REST_PATH = "hotel";

      /**
       * Internal constructor.  Use the convenience method instead.
       */
      Patch(String id) {
        super(Bookingendpoint.this, HttpMethod.PATCH, REST_PATH, null);
        this.id = Preconditions.checkNotNull(id, "Required parameter id must be specified.");
      }

      /**
       * Sends the "patch" request to the Bookingendpoint server.
       *
       * @throws IOException if the request fails
       */
      public void execute() throws IOException {
        HttpResponse response = executeUnparsed();
        response.ignore();
      }

      /**
       * Queues the "patch" request to the Bookingendpoint server into the given batch request.
       *
       * <p>
       * Example usage:
       * </p>
       *
       * <pre>
         request.queue(batchRequest, new JsonBatchCallback&lt;Void&gt;() {

           public void onSuccess(Void content, GoogleHeaders responseHeaders) {
             log("Success");
           }

           public void onFailure(GoogleJsonError e, GoogleHeaders responseHeaders) {
             log(e.getMessage());
           }
         });
       * </pre>
       *
       * @param batch a single batch of requests
       * @param callback batch callback
       * @since 1.6
       */
      public void queue(com.google.api.client.googleapis.batch.BatchRequest batch,
          com.google.api.client.googleapis.batch.json.JsonBatchCallback<Void> callback)
          throws IOException {
        batch.queue(buildHttpRequest(), Void.class,
            com.google.api.client.googleapis.json.GoogleJsonErrorContainer.class, callback);
      }

      /**
       * @since 1.7
       */
      @Override
      public Patch setFields(String fields) {
        super.setFields(fields);
        return this;
      }

      @com.google.api.client.util.Key
      private String id;

      /**

       */
      public String getId() {
        return id;
      }

      public Patch setId(String id) {
        this.id = id;
        return this;
      }

    }
    /**
     * Create a request for the method "hotels.delete".
     *
     * This request holds the parameters needed by the the bookingendpoint server.  After setting any
     * optional parameters, call the {@link Delete#execute()} method to invoke the remote operation.
     *
     * @param id
     * @return the request
     * @throws IOException if the initialization of the request fails
     */
    public Delete delete(String id) throws IOException {
      Delete result = new Delete(id);
      initialize(result);
      return result;
    }

    public class Delete extends BookingendpointRequest {

      private static final String REST_PATH = "hotel/{id}";

      /**
       * Internal constructor.  Use the convenience method instead.
       */
      Delete(String id) {
        super(Bookingendpoint.this, HttpMethod.DELETE, REST_PATH, null);
        this.id = Preconditions.checkNotNull(id, "Required parameter id must be specified.");
      }

      /**
       * Sends the "delete" request to the Bookingendpoint server.
       *
       * @return the {@link com.appspot.api.services.bookingendpoint.model.Hotel} response
       * @throws IOException if the request fails
       */
      public com.appspot.api.services.bookingendpoint.model.Hotel execute() throws IOException {
        HttpResponse response = executeUnparsed();
        com.appspot.api.services.bookingendpoint.model.Hotel result = response.parseAs(
            com.appspot.api.services.bookingendpoint.model.Hotel.class);
        result.setResponseHeaders(response.getHeaders());
        return result;
      }

      /**
       * Queues the "delete" request to the Bookingendpoint server into the given batch request.
       *
       * <p>
       * Example usage:
       * </p>
       *
       * <pre>
         request.queue(batchRequest, new JsonBatchCallback&lt;Hotel&gt;() {

           public void onSuccess(Hotel content, GoogleHeaders responseHeaders) {
             log("Success");
           }

           public void onFailure(GoogleJsonError e, GoogleHeaders responseHeaders) {
             log(e.getMessage());
           }
         });
       * </pre>
       *
       * @param batch a single batch of requests
       * @param callback batch callback
       * @since 1.6
       */
      public void queue(com.google.api.client.googleapis.batch.BatchRequest batch,
          com.google.api.client.googleapis.batch.json.JsonBatchCallback<com.appspot.api.services.bookingendpoint.model.Hotel> callback)
          throws IOException {
        batch.queue(buildHttpRequest(), com.appspot.api.services.bookingendpoint.model.Hotel.class,
            com.google.api.client.googleapis.json.GoogleJsonErrorContainer.class, callback);
      }

      /**
       * @since 1.7
       */
      @Override
      public Delete setFields(String fields) {
        super.setFields(fields);
        return this;
      }

      @com.google.api.client.util.Key
      private String id;

      /**

       */
      public String getId() {
        return id;
      }

      public Delete setId(String id) {
        this.id = id;
        return this;
      }

    }

    /**
     * An accessor for creating requests from the Bookings collection.
     *
     * The typical use is:<pre>
     *   {@code Bookingendpoint bookingendpoint = new Bookingendpoint(...);}
     *   {@code Bookingendpoint.Bookings.List request = bookingendpoint.bookings().list(parameters ...)}</pre>
     *
     * @return the resource collection
     */
    public Bookings bookings() {
      return new Bookings();
    }

    /**
     * The "bookings" collection of methods.
     */
    public class Bookings {

      /**
       * Create a request for the method "bookings.insert".
       *
       * This request holds the parameters needed by the the bookingendpoint server.  After setting any
       * optional parameters, call the {@link Insert#execute()} method to invoke the remote operation.
       *
       * @param hotelId
       * @param content the {@link com.appspot.api.services.bookingendpoint.model.Booking}
       * @return the request
       * @throws IOException if the initialization of the request fails
       */
      public Insert insert(String hotelId, com.appspot.api.services.bookingendpoint.model.Booking content) throws IOException {
        Insert result = new Insert(hotelId, content);
        initialize(result);
        return result;
      }

      public class Insert extends BookingendpointRequest {

        private static final String REST_PATH = "hotels/{hotelId}/bookings";

        /**
         * Internal constructor.  Use the convenience method instead.
         */
        Insert(String hotelId, com.appspot.api.services.bookingendpoint.model.Booking content) {
          super(Bookingendpoint.this, HttpMethod.POST, REST_PATH, content);
          this.hotelId = Preconditions.checkNotNull(hotelId, "Required parameter hotelId must be specified.");
          Preconditions.checkNotNull(content);
        }

        /**
         * Sends the "insert" request to the Bookingendpoint server.
         *
         * @return the {@link com.appspot.api.services.bookingendpoint.model.Booking} response
         * @throws IOException if the request fails
         */
        public com.appspot.api.services.bookingendpoint.model.Booking execute() throws IOException {
          HttpResponse response = executeUnparsed();
          com.appspot.api.services.bookingendpoint.model.Booking result = response.parseAs(
              com.appspot.api.services.bookingendpoint.model.Booking.class);
          result.setResponseHeaders(response.getHeaders());
          return result;
        }

        /**
         * Queues the "insert" request to the Bookingendpoint server into the given batch request.
         *
         * <p>
         * Example usage:
         * </p>
         *
         * <pre>
           request.queue(batchRequest, new JsonBatchCallback&lt;Booking&gt;() {

             public void onSuccess(Booking content, GoogleHeaders responseHeaders) {
               log("Success");
             }

             public void onFailure(GoogleJsonError e, GoogleHeaders responseHeaders) {
               log(e.getMessage());
             }
           });
         * </pre>
         *
         * @param batch a single batch of requests
         * @param callback batch callback
         * @since 1.6
         */
        public void queue(com.google.api.client.googleapis.batch.BatchRequest batch,
            com.google.api.client.googleapis.batch.json.JsonBatchCallback<com.appspot.api.services.bookingendpoint.model.Booking> callback)
            throws IOException {
          batch.queue(buildHttpRequest(), com.appspot.api.services.bookingendpoint.model.Booking.class,
              com.google.api.client.googleapis.json.GoogleJsonErrorContainer.class, callback);
        }

        /**
         * @since 1.7
         */
        @Override
        public Insert setFields(String fields) {
          super.setFields(fields);
          return this;
        }

        @com.google.api.client.util.Key
        private String hotelId;

        /**

         */
        public String getHotelId() {
          return hotelId;
        }

        public Insert setHotelId(String hotelId) {
          this.hotelId = hotelId;
          return this;
        }

      }
      /**
       * Create a request for the method "bookings.get".
       *
       * This request holds the parameters needed by the the bookingendpoint server.  After setting any
       * optional parameters, call the {@link Get#execute()} method to invoke the remote operation.
       *
       * @param hotelId
       * @param id
       * @return the request
       * @throws IOException if the initialization of the request fails
       */
      public Get get(String hotelId, String id) throws IOException {
        Get result = new Get(hotelId, id);
        initialize(result);
        return result;
      }

      public class Get extends BookingendpointRequest {

        private static final String REST_PATH = "hotels/{hotelId}/bookings/{id}";

        /**
         * Internal constructor.  Use the convenience method instead.
         */
        Get(String hotelId, String id) {
          super(Bookingendpoint.this, HttpMethod.GET, REST_PATH, null);
          this.hotelId = Preconditions.checkNotNull(hotelId, "Required parameter hotelId must be specified.");
          this.id = Preconditions.checkNotNull(id, "Required parameter id must be specified.");
        }

        /**
         * Sends the "get" request to the Bookingendpoint server.
         *
         * @return the {@link com.appspot.api.services.bookingendpoint.model.Booking} response
         * @throws IOException if the request fails
         */
        public com.appspot.api.services.bookingendpoint.model.Booking execute() throws IOException {
          HttpResponse response = executeUnparsed();
          com.appspot.api.services.bookingendpoint.model.Booking result = response.parseAs(
              com.appspot.api.services.bookingendpoint.model.Booking.class);
          result.setResponseHeaders(response.getHeaders());
          return result;
        }

        /**
         * Queues the "get" request to the Bookingendpoint server into the given batch request.
         *
         * <p>
         * Example usage:
         * </p>
         *
         * <pre>
           request.queue(batchRequest, new JsonBatchCallback&lt;Booking&gt;() {

             public void onSuccess(Booking content, GoogleHeaders responseHeaders) {
               log("Success");
             }

             public void onFailure(GoogleJsonError e, GoogleHeaders responseHeaders) {
               log(e.getMessage());
             }
           });
         * </pre>
         *
         * @param batch a single batch of requests
         * @param callback batch callback
         * @since 1.6
         */
        public void queue(com.google.api.client.googleapis.batch.BatchRequest batch,
            com.google.api.client.googleapis.batch.json.JsonBatchCallback<com.appspot.api.services.bookingendpoint.model.Booking> callback)
            throws IOException {
          batch.queue(buildHttpRequest(), com.appspot.api.services.bookingendpoint.model.Booking.class,
              com.google.api.client.googleapis.json.GoogleJsonErrorContainer.class, callback);
        }

        /**
         * @since 1.7
         */
        @Override
        public Get setFields(String fields) {
          super.setFields(fields);
          return this;
        }

        @com.google.api.client.util.Key
        private String hotelId;

        /**

         */
        public String getHotelId() {
          return hotelId;
        }

        public Get setHotelId(String hotelId) {
          this.hotelId = hotelId;
          return this;
        }

        @com.google.api.client.util.Key
        private String id;

        /**

         */
        public String getId() {
          return id;
        }

        public Get setId(String id) {
          this.id = id;
          return this;
        }

      }
      /**
       * Create a request for the method "bookings.list".
       *
       * This request holds the parameters needed by the the bookingendpoint server.  After setting any
       * optional parameters, call the {@link List#execute()} method to invoke the remote operation.
       *
       * @param hotelId
       * @return the request
       * @throws IOException if the initialization of the request fails
       */
      public List list(String hotelId) throws IOException {
        List result = new List(hotelId);
        initialize(result);
        return result;
      }

      public class List extends BookingendpointRequest {

        private static final String REST_PATH = "hotels/{hotelId}/bookings";

        /**
         * Internal constructor.  Use the convenience method instead.
         */
        List(String hotelId) {
          super(Bookingendpoint.this, HttpMethod.GET, REST_PATH, null);
          this.hotelId = Preconditions.checkNotNull(hotelId, "Required parameter hotelId must be specified.");
        }

        /**
         * Sends the "list" request to the Bookingendpoint server.
         *
         * @return the {@link com.appspot.api.services.bookingendpoint.model.Bookings} response
         * @throws IOException if the request fails
         */
        public com.appspot.api.services.bookingendpoint.model.Bookings execute() throws IOException {
          HttpResponse response = executeUnparsed();
          com.appspot.api.services.bookingendpoint.model.Bookings result = response.parseAs(
              com.appspot.api.services.bookingendpoint.model.Bookings.class);
          result.setResponseHeaders(response.getHeaders());
          return result;
        }

        /**
         * Queues the "list" request to the Bookingendpoint server into the given batch request.
         *
         * <p>
         * Example usage:
         * </p>
         *
         * <pre>
           request.queue(batchRequest, new JsonBatchCallback&lt;Bookings&gt;() {

             public void onSuccess(Bookings content, GoogleHeaders responseHeaders) {
               log("Success");
             }

             public void onFailure(GoogleJsonError e, GoogleHeaders responseHeaders) {
               log(e.getMessage());
             }
           });
         * </pre>
         *
         * @param batch a single batch of requests
         * @param callback batch callback
         * @since 1.6
         */
        public void queue(com.google.api.client.googleapis.batch.BatchRequest batch,
            com.google.api.client.googleapis.batch.json.JsonBatchCallback<com.appspot.api.services.bookingendpoint.model.Bookings> callback)
            throws IOException {
          batch.queue(buildHttpRequest(), com.appspot.api.services.bookingendpoint.model.Bookings.class,
              com.google.api.client.googleapis.json.GoogleJsonErrorContainer.class, callback);
        }

        /**
         * @since 1.7
         */
        @Override
        public List setFields(String fields) {
          super.setFields(fields);
          return this;
        }

        @com.google.api.client.util.Key
        private String hotelId;

        /**

         */
        public String getHotelId() {
          return hotelId;
        }

        public List setHotelId(String hotelId) {
          this.hotelId = hotelId;
          return this;
        }

      }
      /**
       * Create a request for the method "bookings.update".
       *
       * This request holds the parameters needed by the the bookingendpoint server.  After setting any
       * optional parameters, call the {@link Update#execute()} method to invoke the remote operation.
       *
       * @param hotelId
       * @param content the {@link com.appspot.api.services.bookingendpoint.model.Booking}
       * @return the request
       * @throws IOException if the initialization of the request fails
       */
      public Update update(String hotelId, com.appspot.api.services.bookingendpoint.model.Booking content) throws IOException {
        Update result = new Update(hotelId, content);
        initialize(result);
        return result;
      }

      public class Update extends BookingendpointRequest {

        private static final String REST_PATH = "hotels/{hotelId}/bookings";

        /**
         * Internal constructor.  Use the convenience method instead.
         */
        Update(String hotelId, com.appspot.api.services.bookingendpoint.model.Booking content) {
          super(Bookingendpoint.this, HttpMethod.PUT, REST_PATH, content);
          this.hotelId = Preconditions.checkNotNull(hotelId, "Required parameter hotelId must be specified.");
          Preconditions.checkNotNull(content);
        }

        /**
         * Sends the "update" request to the Bookingendpoint server.
         *
         * @return the {@link com.appspot.api.services.bookingendpoint.model.Booking} response
         * @throws IOException if the request fails
         */
        public com.appspot.api.services.bookingendpoint.model.Booking execute() throws IOException {
          HttpResponse response = executeUnparsed();
          com.appspot.api.services.bookingendpoint.model.Booking result = response.parseAs(
              com.appspot.api.services.bookingendpoint.model.Booking.class);
          result.setResponseHeaders(response.getHeaders());
          return result;
        }

        /**
         * Queues the "update" request to the Bookingendpoint server into the given batch request.
         *
         * <p>
         * Example usage:
         * </p>
         *
         * <pre>
           request.queue(batchRequest, new JsonBatchCallback&lt;Booking&gt;() {

             public void onSuccess(Booking content, GoogleHeaders responseHeaders) {
               log("Success");
             }

             public void onFailure(GoogleJsonError e, GoogleHeaders responseHeaders) {
               log(e.getMessage());
             }
           });
         * </pre>
         *
         * @param batch a single batch of requests
         * @param callback batch callback
         * @since 1.6
         */
        public void queue(com.google.api.client.googleapis.batch.BatchRequest batch,
            com.google.api.client.googleapis.batch.json.JsonBatchCallback<com.appspot.api.services.bookingendpoint.model.Booking> callback)
            throws IOException {
          batch.queue(buildHttpRequest(), com.appspot.api.services.bookingendpoint.model.Booking.class,
              com.google.api.client.googleapis.json.GoogleJsonErrorContainer.class, callback);
        }

        /**
         * @since 1.7
         */
        @Override
        public Update setFields(String fields) {
          super.setFields(fields);
          return this;
        }

        @com.google.api.client.util.Key
        private String hotelId;

        /**

         */
        public String getHotelId() {
          return hotelId;
        }

        public Update setHotelId(String hotelId) {
          this.hotelId = hotelId;
          return this;
        }

      }
      /**
       * Create a request for the method "bookings.listPerUser".
       *
       * This request holds the parameters needed by the the bookingendpoint server.  After setting any
       * optional parameters, call the {@link ListPerUser#execute()} method to invoke the remote
       * operation.
       *
       * @return the request
       * @throws IOException if the initialization of the request fails
       */
      public ListPerUser listPerUser() throws IOException {
        ListPerUser result = new ListPerUser();
        initialize(result);
        return result;
      }

      public class ListPerUser extends BookingendpointRequest {

        private static final String REST_PATH = "user/bookings";

        /**
         * Internal constructor.  Use the convenience method instead.
         */
        ListPerUser() {
          super(Bookingendpoint.this, HttpMethod.GET, REST_PATH, null);
        }

        /**
         * Sends the "listPerUser" request to the Bookingendpoint server.
         *
         * @return the {@link com.appspot.api.services.bookingendpoint.model.Bookings} response
         * @throws IOException if the request fails
         */
        public com.appspot.api.services.bookingendpoint.model.Bookings execute() throws IOException {
          HttpResponse response = executeUnparsed();
          com.appspot.api.services.bookingendpoint.model.Bookings result = response.parseAs(
              com.appspot.api.services.bookingendpoint.model.Bookings.class);
          result.setResponseHeaders(response.getHeaders());
          return result;
        }

        /**
         * Queues the "listPerUser" request to the Bookingendpoint server into the given batch request.
         *
         * <p>
         * Example usage:
         * </p>
         *
         * <pre>
           request.queue(batchRequest, new JsonBatchCallback&lt;Bookings&gt;() {

             public void onSuccess(Bookings content, GoogleHeaders responseHeaders) {
               log("Success");
             }

             public void onFailure(GoogleJsonError e, GoogleHeaders responseHeaders) {
               log(e.getMessage());
             }
           });
         * </pre>
         *
         * @param batch a single batch of requests
         * @param callback batch callback
         * @since 1.6
         */
        public void queue(com.google.api.client.googleapis.batch.BatchRequest batch,
            com.google.api.client.googleapis.batch.json.JsonBatchCallback<com.appspot.api.services.bookingendpoint.model.Bookings> callback)
            throws IOException {
          batch.queue(buildHttpRequest(), com.appspot.api.services.bookingendpoint.model.Bookings.class,
              com.google.api.client.googleapis.json.GoogleJsonErrorContainer.class, callback);
        }

        /**
         * @since 1.7
         */
        @Override
        public ListPerUser setFields(String fields) {
          super.setFields(fields);
          return this;
        }

      }
      /**
       * Create a request for the method "bookings.patch".
       *
       * This request holds the parameters needed by the the bookingendpoint server.  After setting any
       * optional parameters, call the {@link Patch#execute()} method to invoke the remote operation.
       *
       * @param hotelId
       * @param id
       * @return the request
       * @throws IOException if the initialization of the request fails
       */
      public Patch patch(String hotelId, String id) throws IOException {
        Patch result = new Patch(hotelId, id);
        initialize(result);
        return result;
      }

      public class Patch extends BookingendpointRequest {

        private static final String REST_PATH = "hotels/{hotelId}/bookings";

        /**
         * Internal constructor.  Use the convenience method instead.
         */
        Patch(String hotelId, String id) {
          super(Bookingendpoint.this, HttpMethod.PATCH, REST_PATH, null);
          this.hotelId = Preconditions.checkNotNull(hotelId, "Required parameter hotelId must be specified.");
          this.id = Preconditions.checkNotNull(id, "Required parameter id must be specified.");
        }

        /**
         * Sends the "patch" request to the Bookingendpoint server.
         *
         * @throws IOException if the request fails
         */
        public void execute() throws IOException {
          HttpResponse response = executeUnparsed();
          response.ignore();
        }

        /**
         * Queues the "patch" request to the Bookingendpoint server into the given batch request.
         *
         * <p>
         * Example usage:
         * </p>
         *
         * <pre>
           request.queue(batchRequest, new JsonBatchCallback&lt;Void&gt;() {

             public void onSuccess(Void content, GoogleHeaders responseHeaders) {
               log("Success");
             }

             public void onFailure(GoogleJsonError e, GoogleHeaders responseHeaders) {
               log(e.getMessage());
             }
           });
         * </pre>
         *
         * @param batch a single batch of requests
         * @param callback batch callback
         * @since 1.6
         */
        public void queue(com.google.api.client.googleapis.batch.BatchRequest batch,
            com.google.api.client.googleapis.batch.json.JsonBatchCallback<Void> callback)
            throws IOException {
          batch.queue(buildHttpRequest(), Void.class,
              com.google.api.client.googleapis.json.GoogleJsonErrorContainer.class, callback);
        }

        /**
         * @since 1.7
         */
        @Override
        public Patch setFields(String fields) {
          super.setFields(fields);
          return this;
        }

        @com.google.api.client.util.Key
        private String hotelId;

        /**

         */
        public String getHotelId() {
          return hotelId;
        }

        public Patch setHotelId(String hotelId) {
          this.hotelId = hotelId;
          return this;
        }

        @com.google.api.client.util.Key
        private String id;

        /**

         */
        public String getId() {
          return id;
        }

        public Patch setId(String id) {
          this.id = id;
          return this;
        }

      }
      /**
       * Create a request for the method "bookings.delete".
       *
       * This request holds the parameters needed by the the bookingendpoint server.  After setting any
       * optional parameters, call the {@link Delete#execute()} method to invoke the remote operation.
       *
       * @param hotelId
       * @param bookingId
       * @return the request
       * @throws IOException if the initialization of the request fails
       */
      public Delete delete(String hotelId, String bookingId) throws IOException {
        Delete result = new Delete(hotelId, bookingId);
        initialize(result);
        return result;
      }

      public class Delete extends BookingendpointRequest {

        private static final String REST_PATH = "hotels/{hotelId}/bookings/{bookingId}";

        /**
         * Internal constructor.  Use the convenience method instead.
         */
        Delete(String hotelId, String bookingId) {
          super(Bookingendpoint.this, HttpMethod.DELETE, REST_PATH, null);
          this.hotelId = Preconditions.checkNotNull(hotelId, "Required parameter hotelId must be specified.");
          this.bookingId = Preconditions.checkNotNull(bookingId, "Required parameter bookingId must be specified.");
        }

        /**
         * Sends the "delete" request to the Bookingendpoint server.
         *
         * @return the {@link com.appspot.api.services.bookingendpoint.model.Booking} response
         * @throws IOException if the request fails
         */
        public com.appspot.api.services.bookingendpoint.model.Booking execute() throws IOException {
          HttpResponse response = executeUnparsed();
          com.appspot.api.services.bookingendpoint.model.Booking result = response.parseAs(
              com.appspot.api.services.bookingendpoint.model.Booking.class);
          result.setResponseHeaders(response.getHeaders());
          return result;
        }

        /**
         * Queues the "delete" request to the Bookingendpoint server into the given batch request.
         *
         * <p>
         * Example usage:
         * </p>
         *
         * <pre>
           request.queue(batchRequest, new JsonBatchCallback&lt;Booking&gt;() {

             public void onSuccess(Booking content, GoogleHeaders responseHeaders) {
               log("Success");
             }

             public void onFailure(GoogleJsonError e, GoogleHeaders responseHeaders) {
               log(e.getMessage());
             }
           });
         * </pre>
         *
         * @param batch a single batch of requests
         * @param callback batch callback
         * @since 1.6
         */
        public void queue(com.google.api.client.googleapis.batch.BatchRequest batch,
            com.google.api.client.googleapis.batch.json.JsonBatchCallback<com.appspot.api.services.bookingendpoint.model.Booking> callback)
            throws IOException {
          batch.queue(buildHttpRequest(), com.appspot.api.services.bookingendpoint.model.Booking.class,
              com.google.api.client.googleapis.json.GoogleJsonErrorContainer.class, callback);
        }

        /**
         * @since 1.7
         */
        @Override
        public Delete setFields(String fields) {
          super.setFields(fields);
          return this;
        }

        @com.google.api.client.util.Key
        private String hotelId;

        /**

         */
        public String getHotelId() {
          return hotelId;
        }

        public Delete setHotelId(String hotelId) {
          this.hotelId = hotelId;
          return this;
        }

        @com.google.api.client.util.Key
        private String bookingId;

        /**

         */
        public String getBookingId() {
          return bookingId;
        }

        public Delete setBookingId(String bookingId) {
          this.bookingId = bookingId;
          return this;
        }

      }

    }
  }

  /**
   * Create a request for the method "dashboard".
   *
   * This request holds the parameters needed by the the bookingendpoint server.  After setting any
   * optional parameters, call the {@link Dashboard#execute()} method to invoke the remote operation.
   *
   * @return the request
   * @throws IOException if the initialization of the request fails
   */
  public Dashboard dashboard() throws IOException {
    Dashboard result = new Dashboard();
    initialize(result);
    return result;
  }

  public class Dashboard extends BookingendpointRequest {

    private static final String REST_PATH = "dashboard";

    /**
     * Internal constructor.  Use the convenience method instead.
     */
    Dashboard() {
      super(Bookingendpoint.this, HttpMethod.GET, REST_PATH, null);
    }

    /**
     * Sends the "dashboard" request to the Bookingendpoint server.
     *
     * @return the {@link com.appspot.api.services.bookingendpoint.model.Dashboard} response
     * @throws IOException if the request fails
     */
    public com.appspot.api.services.bookingendpoint.model.Dashboard execute() throws IOException {
      HttpResponse response = executeUnparsed();
      com.appspot.api.services.bookingendpoint.model.Dashboard result = response.parseAs(
          com.appspot.api.services.bookingendpoint.model.Dashboard.class);
      result.setResponseHeaders(response.getHeaders());
      return result;
    }

    /**
     * Queues the "dashboard" request to the Bookingendpoint server into the given batch request.
     *
     * <p>
     * Example usage:
     * </p>
     *
     * <pre>
       request.queue(batchRequest, new JsonBatchCallback&lt;Dashboard&gt;() {

         public void onSuccess(Dashboard content, GoogleHeaders responseHeaders) {
           log("Success");
         }

         public void onFailure(GoogleJsonError e, GoogleHeaders responseHeaders) {
           log(e.getMessage());
         }
       });
     * </pre>
     *
     * @param batch a single batch of requests
     * @param callback batch callback
     * @since 1.6
     */
    public void queue(com.google.api.client.googleapis.batch.BatchRequest batch,
        com.google.api.client.googleapis.batch.json.JsonBatchCallback<com.appspot.api.services.bookingendpoint.model.Dashboard> callback)
        throws IOException {
      batch.queue(buildHttpRequest(), com.appspot.api.services.bookingendpoint.model.Dashboard.class,
          com.google.api.client.googleapis.json.GoogleJsonErrorContainer.class, callback);
    }

    /**
     * @since 1.7
     */
    @Override
    public Dashboard setFields(String fields) {
      super.setFields(fields);
      return this;
    }

  }

  /**
   * Builder for {@link Bookingendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends GoogleClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport The transport to use for requests
     * @param jsonFactory A factory for creating JSON parsers and serializers
     * @param baseUrl The base URL of the service. Must end with a "/"
     */
    @Deprecated
    Builder(HttpTransport transport, JsonFactory jsonFactory, GenericUrl baseUrl) {
      super(transport, jsonFactory, baseUrl);
    }

    /**
     * Returns an instance of a new builder.
     *
     * @param transport The transport to use for requests
     * @param jsonFactory A factory for creating JSON parsers and serializers
     * @param httpRequestInitializer The HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(HttpTransport transport, JsonFactory jsonFactory,
        HttpRequestInitializer httpRequestInitializer) {
      super(transport, jsonFactory, DEFAULT_ROOT_URL, DEFAULT_SERVICE_PATH, httpRequestInitializer);
    }

    /** Builds a new instance of {@link Bookingendpoint}. */
    @SuppressWarnings("deprecation")
    @Override
    public Bookingendpoint build() {
      if (isBaseUrlUsed()) {
        return new Bookingendpoint(
            getTransport(),
            getJsonHttpRequestInitializer(),
            getHttpRequestInitializer(),
            getJsonFactory(),
            getObjectParser(),
            getBaseUrl().build(),
            getApplicationName());
      }
      return new Bookingendpoint(
          getTransport(),
          getJsonHttpRequestInitializer(),
          getHttpRequestInitializer(),
          getJsonFactory(),
          getObjectParser(),
          getRootUrl(),
          getServicePath(),
          getApplicationName(),
          getSuppressPatternChecks());
    }

    @Override
    @Deprecated
    public Builder setBaseUrl(GenericUrl baseUrl) {
      super.setBaseUrl(baseUrl);
      return this;
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      super.setRootUrl(rootUrl);
      return this;
    }

    @Override
    public Builder setServicePath(String servicePath) {
      super.setServicePath(servicePath);
      return this;
    }

    @Override
    public Builder setJsonHttpRequestInitializer(
        JsonHttpRequestInitializer jsonHttpRequestInitializer) {
      super.setJsonHttpRequestInitializer(jsonHttpRequestInitializer);
      return this;
    }

    @Override
    public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
      super.setHttpRequestInitializer(httpRequestInitializer);
      return this;
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      super.setApplicationName(applicationName);
      return this;
    }

    @Override
    public Builder setObjectParser(JsonObjectParser parser) {
      super.setObjectParser(parser);
      return this;
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      super.setSuppressPatternChecks(suppressPatternChecks);
      return this;
    }
  }
}
