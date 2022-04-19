package com.example.task19.service.impl;

import com.example.task19.entity.Game;
import com.example.task19.entity.GameAuthor;
import com.example.task19.repository.GameAuthorRepository;
import com.example.task19.repository.GameRepository;
import com.example.task19.service.base.GameService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    private final GameAuthorRepository gameAuthorRepository;

    private final ModelMapper modelMapper;

    private final SessionFactory sessionFactory;

    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public GameServiceImpl(GameRepository gameRepository,
                           GameAuthorRepository gameAuthorRepository,
                           SessionFactory sessionFactory) {
        this.gameRepository = gameRepository;
        this.gameAuthorRepository = gameAuthorRepository;
        this.sessionFactory = sessionFactory;
        this.modelMapper = new ModelMapper();
        log.info("init GameService");
    }

    @Override
    public Game findById(Long id) {
        log.info("GameService.findById method is executed");
        return modelMapper.map(gameRepository.findById(id), Game.class);
    }

    @Override
    public List<Game> findAll() {
        log.info("GameService.findAll method is executed");
        return gameRepository.findAll();
    }

    @Override
    public void save(Game entity) {
        log.info("GameService.save method is executed");
        gameRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        log.info("GameService.deleteById method is executed");
        gameRepository.deleteById(id);
    }

    @Override
    public List<Game> getGameFullList() {
        log.info("GameService.getGameFullList method is executed");
        List<Game> result = gameRepository.findAll().stream().map(el -> {
            el.setGameAuthor(
                    modelMapper.map(gameAuthorRepository.findById(el.getId()),
                            GameAuthor.class));
            return modelMapper.map(el, Game.class);
        }).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<Game> findFilter(String field, String value) {
        log.info("GameService.findFilter method is executed");
        CriteriaBuilder criteria = session.getCriteriaBuilder();
        CriteriaQuery<Game> userCriteriaQuery =
                criteria.createQuery(Game.class);
        Root<Game> userRoot = userCriteriaQuery.from(Game.class);
        userCriteriaQuery.select(userRoot)
                .where(criteria.equal(userRoot.get(field), value));
        Query query = session.createQuery(userCriteriaQuery);
        return query.getResultList();
    }
}
