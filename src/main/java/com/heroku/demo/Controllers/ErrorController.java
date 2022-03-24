package com.heroku.demo.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("**")
public class ErrorController {
  @GetMapping
  // @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public Exception getError() {
    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
  }

  @PostMapping
  public Exception postError() {
    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
  }

  @PutMapping
  public Exception putError() {
    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping
  public Exception deleteError() {
    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
  }
}
