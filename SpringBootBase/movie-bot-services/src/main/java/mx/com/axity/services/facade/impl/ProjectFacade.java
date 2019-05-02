package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.facade.IProjectFacade;
import mx.com.axity.services.service.IMovieBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProjectFacade implements IProjectFacade {

    @Autowired
    private IMovieBotService projectService;

    public List<UserTO> getAllUsers() {
        return this.projectService.getMovies();
    }
}
