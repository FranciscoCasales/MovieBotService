package mx.com.axity.web.rest;

import io.swagger.annotations.Api;
import mx.com.axity.commons.to.MovieTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.facade.IProjectFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("chatbot")
@Api(value="project", description="Operaciones con project")
public class MovieController {

    static final Logger LOG = LogManager.getLogger(MovieController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IProjectFacade IprojectFacade;

    @RequestMapping(value = "movies", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<MovieTO>> getAllMovies() {
        return null;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UserTO>> getAllUsers() {
        LOG.info("Se invoca /find");
        List<UserTO> users = this.IprojectFacade.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity test() {
        LOG.info("Se invoca /test");
        return new ResponseEntity<>("Prueba Ok", HttpStatus.OK);
    }
}
