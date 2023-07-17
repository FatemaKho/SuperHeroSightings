package com.sg.SuperHero.service;

import com.sg.SuperHero.dao.SuperHumanDao;
import com.sg.SuperHero.dto.SuperHuman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class SuperHumanDaoServiceImpl implements SuperHumanDaoService {

    private final SuperHumanDao superHumanDao;

    @Autowired
    public SuperHumanDaoServiceImpl(SuperHumanDao superHumanDao) {
        this.superHumanDao = superHumanDao;
    }

    @Override
    public SuperHuman getById(int superhumanId) {
        return superHumanDao.getById(superhumanId);
    }

    @Override
    public List<SuperHuman> getAll() {
        return superHumanDao.getAll();
    }

    @Override
    public void create(SuperHuman superhuman) {

        superHumanDao.create(superhuman);
    }

    @Override
    public void update(SuperHuman superhuman) {
        SuperHuman existingSuperHuman = superHumanDao.getById(superhuman.getSuperhumanId());
        if (existingSuperHuman == null) {
            throw new ValidationException("Superhuman with ID " + superhuman.getSuperhumanId() + " not found.");
        }

        superHumanDao.update(superhuman);
    }

    @Override
    public void delete(int superhumanId) {
        SuperHuman existingSuperHuman = superHumanDao.getById(superhumanId);
        if (existingSuperHuman == null) {
            throw new ValidationException("Superhuman with ID " + superhumanId + " not found.");
        }

        superHumanDao.delete(superhumanId);
    }
}
