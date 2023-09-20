package br.com.gomide.hash_map;

public interface IURLShortener {

  /**
   * Contains the URL prefix of the shortener service
   * 
   * @return a url in "http://my-service/" format
   */
  public String getPrefix();

  /**
   * Encode a URL to a short format
   * 
   * @param url
   * @return a new URL with "getPrefix()/hash-url" format
   */
  public String encode(String url);

  /**
   * Decode a URL to the original address
   * 
   * @param encodedUrl
   * @return the original URL
   */
  public String decode(String encodedUrl);

}
