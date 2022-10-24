package br.com.gomide.data_structures.hash_map;

public interface IURLShortener {
	
	public String encode(String url);
	
	public String decode(String encodedUrl);
	
}
