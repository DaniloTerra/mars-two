package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@RestController
public class Application {
    
    @RequestMapping(value = "/rest/mars/{instruction}", method = RequestMethod.POST)
    public ResponseEntity move(@PathVariable String instruction) {    
        try {
        	Robot spirit = new Robot();
        	return ResponseEntity.ok(spirit.move(instruction));
        } catch (Exception ex) {
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}