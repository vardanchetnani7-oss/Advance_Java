package com.Users.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	  @ExceptionHandler(PlaylistNotFound.class)
	    public ResponseEntity<String> handlePlaylistNotFound(
	            PlaylistNotFound ex) {

	        return ResponseEntity
	                .status(404)
	                .body("Playlist not found");
	    }
}
