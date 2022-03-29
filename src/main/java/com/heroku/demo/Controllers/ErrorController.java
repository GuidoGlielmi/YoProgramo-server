package com.heroku.demo.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ErrorController {
  @RequestMapping(value = "*", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
      RequestMethod.DELETE })
  // @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public String error() {
    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
  }
}
