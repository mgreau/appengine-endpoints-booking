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
 * Warning! This file is generated. Modify at your own risk.
 */

package com.appspot.api.services.bookingendpoint.model;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.DateTime;

/**
 * Model definition for Booking.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the . For a detailed explanation see:
 * <a href="http://code.google.com/p/google-api-java-client/wiki/Json">http://code.google.com/p/google-api-java-client/wiki/Json</a>
 * </p>
 *
 * @author Google, Inc.
 */
public final class Booking extends GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Integer nights;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private DateTime checkoutDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String description;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private DateTime checkinDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Integer beds;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private User user;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Boolean smoking;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Integer total;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @JsonString
  private Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @JsonString
  private Long hotelId;

  /**

   * The value returned may be {@code null}.
   */
  public Integer getNights() {
    return nights;
  }

  /**

   * The value set may be {@code null}.
   */
  public Booking setNights(Integer nights) {
    this.nights = nights;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public DateTime getCheckoutDate() {
    return checkoutDate;
  }

  /**

   * The value set may be {@code null}.
   */
  public Booking setCheckoutDate(DateTime checkoutDate) {
    this.checkoutDate = checkoutDate;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public String getDescription() {
    return description;
  }

  /**

   * The value set may be {@code null}.
   */
  public Booking setDescription(String description) {
    this.description = description;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public DateTime getCheckinDate() {
    return checkinDate;
  }

  /**

   * The value set may be {@code null}.
   */
  public Booking setCheckinDate(DateTime checkinDate) {
    this.checkinDate = checkinDate;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public Integer getBeds() {
    return beds;
  }

  /**

   * The value set may be {@code null}.
   */
  public Booking setBeds(Integer beds) {
    this.beds = beds;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public User getUser() {
    return user;
  }

  /**

   * The value set may be {@code null}.
   */
  public Booking setUser(User user) {
    this.user = user;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public Boolean getSmoking() {
    return smoking;
  }

  /**

   * The value set may be {@code null}.
   */
  public Booking setSmoking(Boolean smoking) {
    this.smoking = smoking;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public Integer getTotal() {
    return total;
  }

  /**

   * The value set may be {@code null}.
   */
  public Booking setTotal(Integer total) {
    this.total = total;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public Long getId() {
    return id;
  }

  /**

   * The value set may be {@code null}.
   */
  public Booking setId(Long id) {
    this.id = id;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public Long getHotelId() {
    return hotelId;
  }

  /**

   * The value set may be {@code null}.
   */
  public Booking setHotelId(Long hotelId) {
    this.hotelId = hotelId;
    return this;
  }

  private HttpHeaders responseHeaders;

  /**
   * Sets the HTTP headers returned with the server response, or <code>null</code>.
   *
   * This member should only be non-null if this object was the top level element of a response. For
   * example, a request that returns a single {@link Booking} would include the response headers,
   * while a request which returns an array of {@link Booking}, would have a non-null response
   * header in the enclosing object only.
   */
  public void setResponseHeaders(HttpHeaders responseHeaders) {
    this.responseHeaders = responseHeaders;
  }

  /**
   * Returns the HTTP headers that were returned with the server response, or
   * <code>null</code>.
   */
  public HttpHeaders getResponseHeaders() {
    return responseHeaders;
  }

}
