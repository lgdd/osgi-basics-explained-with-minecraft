package com.github.lgdd.osgi.minecraft.summon.enemies.service;

import com.github.lgdd.osgi.minecraft.summon.api.DockerSummonService;
import com.github.lgdd.osgi.minecraft.summon.api.Mob;
import com.github.lgdd.osgi.minecraft.summon.api.SummonService;
import com.github.lgdd.osgi.minecraft.summon.enemies.domain.Creeper;
import com.github.lgdd.osgi.minecraft.summon.enemies.domain.Zombie;
import org.osgi.service.component.annotations.Component;

@Component(
    service = SummonService.class
)
public class SummonZombieService
    extends DockerSummonService {

  @Override
  public Mob summon() {

    Zombie zombie = new Zombie();
    summonMob(zombie);
    return zombie;
  }
}
