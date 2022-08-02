package com.heroku.demo.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.heroku.demo.DTO.ResponseStateDto;

@RestController
public class ErrorController {
  @RequestMapping(value = "*", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
      RequestMethod.DELETE })
  // @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ResponseEntity<ResponseStateDto> error() {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseStateDto(404));
  }
}
