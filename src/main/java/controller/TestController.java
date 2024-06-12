package controller;

import Model.User;
import exception.UserNotFoundException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/hello")
    public String getHelloString(@RequestHeader(HttpHeaders.USER_AGENT) String agent) {
        return "Hello, World. BTW User-Agent is: " + agent;
    }

    @PostMapping("/greet")
    public String setGreetingsString(@RequestBody Map<String, Object> payload) {
        return payload.get("name").toString();
    }

    @PostMapping("/reg")
    public String setRegString(@RequestBody @Validated User user) {
        return "Registration for user " + user.getName() + " with email " + user.getEmail() + " successfully done";
    }

    @GetMapping("/id/{name}")
    public String getIdAndName(@RequestParam String id, @PathVariable String name) {
        return id + " " + name;
    }

    @GetMapping("/error")
    public void throwError() {
        throw new UserNotFoundException("test UserNotFoundException");
    }

    @GetMapping("/checkDate/{date}")
    public String checkDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return "Date " + date.toString() + " is correct";
    }

    @GetMapping("/helloName")
    public String getHelloStringWithName(@RequestParam(defaultValue = "Anderson") String name) {
        return "Good morning, Mr " + name;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String handleException(Exception e) {
        return "Handled exception with message " + e.getMessage();
    }
}
