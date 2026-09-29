package com.Users.config;

import com.Users.exception.PlaylistNotFound;

import feign.Response;
import feign.codec.ErrorDecoder;

public class PlaylistErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		// TODO Auto-generated method stub
		if(response.status()==404) {
			return new PlaylistNotFound("Playlist not found");
		}
		
		return new Default().decode(methodKey,response);
	}
}
