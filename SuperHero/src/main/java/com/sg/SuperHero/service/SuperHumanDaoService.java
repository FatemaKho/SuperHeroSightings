package com.sg.SuperHero.service;

import com.sg.SuperHero.dto.SuperHuman;

import java.util.List;

public interface SuperHumanDaoService {
        SuperHuman getById(int superhumanId);
        List<SuperHuman> getAll();
        void create(SuperHuman superhuman);
        void update(SuperHuman superhuman);
        void delete(int superhumanId);
    }


