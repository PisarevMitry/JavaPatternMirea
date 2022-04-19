package com.example.task18.service.impl;

import com.example.task18.entity.GameAuthor;
import com.example.task18.repository.GameAuthorRepository;
import com.example.task18.service.base.GameAuthorService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class GameAuthorServiceImpl implements GameAuthorService {

    private final GameAuthorRepository gameAuthorRepository;

    private final ModelMapper modelMapper;

    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }
    @Autowired
    public GameAuthorServiceImpl(GameAuthorRepository gameAuthorRepository,
                                 SessionFactory sessionFactory) {
        this.gameAuthorRepository = gameAuthorRepository;
        this.sessionFactory = sessionFactory;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public GameAuthor findById(Long id) {
        return modelMapper.map(gameAuthorRepository.findById(id),
                GameAuthor.class);
    }

    @Override
    public List<GameAuthor> findAll() {
        return gameAuthorRepository.findAll();
    }

    @Override
    public void save(GameAuthor entity) {
        gameAuthorRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        gameAuthorRepository.deleteById(id);
    }

    @Override
    public List<GameAuthor> findFilter(String field, String value) {
        CriteriaBuilder criteria = session.getCriteriaBuilder();
        CriteriaQuery<GameAuthor> userCriteriaQuery =
                criteria.createQuery(GameAuthor.class);
        Root<GameAuthor> userRoot = userCriteriaQuery.from(GameAuthor.class);
        userCriteriaQuery.select(userRoot)
                .where(criteria.equal(userRoot.get(field), value));
        Query query = session.createQuery(userCriteriaQuery);
        return query.getResultList();
    }
}
