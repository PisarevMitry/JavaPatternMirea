package com.example.task17.service.impl;

import com.example.task17.entity.Game;
import com.example.task17.entity.GameAuthor;
import com.example.task17.repository.GameAuthorRepository;
import com.example.task17.repository.GameRepository;
import com.example.task17.service.base.GameService;
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
    }

    @Override
    public Game findById(Long id) {
        return modelMapper.map(gameRepository.findById(id), Game.class);
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public void save(Game entity) {
        gameRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        gameRepository.deleteById(id);
    }

    @Override
    public List<Game> getGameFullList() {
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
