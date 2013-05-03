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

/**
 * Model definition for Hotel.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the . For a detailed explanation see:
 * <a href="http://code.google.com/p/google-api-java-client/wiki/Json">http://code.google.com/p/google-api-java-client/wiki/Json</a>
 * </p>
 *
 * @author Google, Inc.
 */
public final class Hotel extends GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String city;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String zip;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String state;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String country;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Text image;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Integer numberOfStars;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @JsonString
  private Long price;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String hotelName;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String address;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @JsonString
  private Long id;

  /**

   * The value returned may be {@code null}.
   */
  public String getCity() {
    return city;
  }

  /**

   * The value set may be {@code null}.
   */
  public Hotel setCity(String city) {
    this.city = city;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public String getZip() {
    return zip;
  }

  /**

   * The value set may be {@code null}.
   */
  public Hotel setZip(String zip) {
    this.zip = zip;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public String getState() {
    return state;
  }

  /**

   * The value set may be {@code null}.
   */
  public Hotel setState(String state) {
    this.state = state;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public String getCountry() {
    return country;
  }

  /**

   * The value set may be {@code null}.
   */
  public Hotel setCountry(String country) {
    this.country = country;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public Text getImage() {
    return image;
  }

  /**

   * The value set may be {@code null}.
   */
  public Hotel setImage(Text image) {
    this.image = image;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public Integer getNumberOfStars() {
    return numberOfStars;
  }

  /**

   * The value set may be {@code null}.
   */
  public Hotel setNumberOfStars(Integer numberOfStars) {
    this.numberOfStars = numberOfStars;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public Long getPrice() {
    return price;
  }

  /**

   * The value set may be {@code null}.
   */
  public Hotel setPrice(Long price) {
    this.price = price;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public String getHotelName() {
    return hotelName;
  }

  /**

   * The value set may be {@code null}.
   */
  public Hotel setHotelName(String hotelName) {
    this.hotelName = hotelName;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public String getAddress() {
    return address;
  }

  /**

   * The value set may be {@code null}.
   */
  public Hotel setAddress(String address) {
    this.address = address;
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
  public Hotel setId(Long id) {
    this.id = id;
    return this;
  }

  private HttpHeaders responseHeaders;

  /**
   * Sets the HTTP headers returned with the server response, or <code>null</code>.
   *
   * This member should only be non-null if this object was the top level element of a response. For
   * example, a request that returns a single {@link Hotel} would include the response headers,
   * while a request which returns an array of {@link Hotel}, would have a non-null response header
   * in the enclosing object only.
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
