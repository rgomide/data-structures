package br.com.gomide.data_structures.hash_map;

public interface IURLShortner {
	
	public String encode(String url) throws RuntimeException;
	
	public String decode(String encodedUrl) throws RuntimeException;
	
}
