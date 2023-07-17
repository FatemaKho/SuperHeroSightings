package com.sg.SuperHero.dao;

import com.sg.SuperHero.dto.SuperHuman;

import java.util.List;

public interface SuperHumanDao {
    SuperHuman getById(int superhumanId);
    List<SuperHuman> getAll();
    void create(SuperHuman superhuman);
    void update(SuperHuman superhuman);

    void delete(int superhumanId);
}
