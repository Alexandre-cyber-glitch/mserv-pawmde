
package com.pawmade;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PingController {

    @GetMapping("/ping")
    public Map<String, Object> ping() {
        return Map.of(
                "application", "PawMate",
                "status", "UP",
                "message", "Woof! PawMate is alive!",
                "timestamp", LocalDateTime.now()
        );
    }
}
