package com.github.lgdd.osgi.minecraft.summon.animals.service;

import com.github.lgdd.osgi.minecraft.summon.animals.domain.Turtle;
import com.github.lgdd.osgi.minecraft.summon.api.DockerSummonService;
import com.github.lgdd.osgi.minecraft.summon.api.Mob;
import com.github.lgdd.osgi.minecraft.summon.api.SummonService;
import org.osgi.service.component.annotations.Component;

@Component(
    service = SummonService.class
)
public class SummonTurtleService
    extends DockerSummonService {

  @Override
  public Mob summon() {

    Turtle turtle = new Turtle();
    summonMob(turtle);
    return turtle;
  }

}
