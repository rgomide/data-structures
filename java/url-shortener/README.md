# URL Shortener

In this folder we have the URL Shortener project with the [IURLShortener](src/main/java/br/com/gomide/hash_map/IURLShortener.java) interface.

The `IURLShortener` interface contains three methods to generate a short URL:

- `getPrefix()`: The prefix of the shortener service. E.g.: `https://my-shortener-service.com/`
- `encode(url)`: Encode a URL to a short format. E.g.: `https://www.google.com` -> `https://my-shortener-service.com/abcde`
- `decode(encodedUrl)`: Decode a URL to the original format. E.g.: `https://my-shortener-service.com/abcde` -> `https://www.google.com`

## Exercise

We have a test class to check the [URLShortener](src/main/java/br/com/gomide/hash_map/URLShortener.java) implementation.

You should open the [URLShortenerTest](src/test/java/br/com/gomide/hash_map/URLShortenerTest.java) to know how `URLShortener` will work.

Complete the `URLShortener` implementation to make all tests green.
