package com.sg.SuperHero.dao;

import com.sg.SuperHero.dto.SuperPower;
import java.util.List;

public interface SuperPowerDAO {
    SuperPower getSuperPowerById(int superpowerID);
    List<SuperPower> getAllSuperPowers();
    void addSuperPower(SuperPower superPower);
    void updateSuperPower(SuperPower superPower);
    void deleteSuperPower(int superpowerID);
}