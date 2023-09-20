package br.com.gomide.hash_map;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class URLShortenerTest {

  @Test
  void encodeAndDecodeUrl() {
    String url = "https://www.google.com";
    IURLShortener urlShortener = new URLShortener();

    String encodedUrl = urlShortener.encode(url);
    String decodedUrl = urlShortener.decode(encodedUrl);

    assertTrue(encodedUrl.startsWith(urlShortener.getPrefix()));
    assertEquals(url, decodedUrl);
  }

  @Test
  void decodeAnInvalidUrl() {
    String invalidUrl = "asjoi;djfna;osdifjoa;sd";

    IURLShortener urlShortener = new URLShortener();

    assertThrows(RuntimeException.class, () -> {
      urlShortener.decode(invalidUrl);
    });
  }

  @Test
  void encodeAndDecodeUrlTwice() {
    String url = "https://www.google.com";
    IURLShortener urlShortener = new URLShortener();

    String encodedUrlFirst = urlShortener.encode(url);
    String decodedUrlFirst = urlShortener.decode(encodedUrlFirst);

    String encodedUrlSecond = urlShortener.encode(url);
    String decodedUrlSecond = urlShortener.decode(encodedUrlSecond);

    assertTrue(encodedUrlFirst.startsWith(urlShortener.getPrefix()));
    assertTrue(encodedUrlSecond.startsWith(urlShortener.getPrefix()));

    assertEquals(url, decodedUrlFirst);
    assertEquals(url, decodedUrlSecond);
  }

}
