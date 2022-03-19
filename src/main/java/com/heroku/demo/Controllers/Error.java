package com.heroku.demo.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("**")
public class Error {
  @GetMapping
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public String getError() {
    return "URL does not exist";
  }

  @PostMapping
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public String postError() {
    return "URL does not exist";
  }

  @PutMapping
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public String putError() {
    return "URL does not exist";
  }

  @DeleteMapping
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public String deleteError() {
    return "URL does not exist";
  }
}
