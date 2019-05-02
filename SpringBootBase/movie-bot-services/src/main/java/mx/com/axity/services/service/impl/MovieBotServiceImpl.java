package mx.com.axity.services.service.impl;

import mx.com.axity.commons.to.MovieTO;
import mx.com.axity.model.MovieDO;
import mx.com.axity.persistence.MovieBotDAO;
import mx.com.axity.services.service.IMovieBotService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class MovieBotServiceImpl implements IMovieBotService {

    static final Logger LOG = LogManager.getLogger(MovieBotServiceImpl.class);

    @Autowired
    MovieBotDAO movieBotDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<MovieTO> getMovies() {

        LOG.info("Consultando lista de peliculas en exibicion");
        List<MovieDO> movieDO = this.movieBotDAO.findAll();

        Type userDAOType = new TypeToken<List<MovieDO>>() {}.getType();
        List<MovieTO> movieTO = (List<MovieTO>)this.modelMapper.map(movieDO, userDAOType);
        LOG.info("Se retornan {} elementos", movieTO.size());

        return movieTO;
    }
}
