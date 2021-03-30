package com.github.lgdd.osgi.minecraft.summon.animals.service;

import com.github.lgdd.osgi.minecraft.summon.animals.domain.Fox;
import com.github.lgdd.osgi.minecraft.summon.api.DockerSummonService;
import com.github.lgdd.osgi.minecraft.summon.api.Mob;
import com.github.lgdd.osgi.minecraft.summon.api.SummonService;
import org.osgi.service.component.annotations.Component;

@Component(
    service = SummonService.class
)
public class SummonFoxService
    extends DockerSummonService {


  @Override
  public Mob summon() {

    Fox fox = new Fox();
    summonMob(fox);
    return fox;
  }

}
