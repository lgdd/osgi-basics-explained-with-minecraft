package com.github.lgdd.osgi.minecraft.summon.scheduler;

import com.github.lgdd.osgi.minecraft.summon.api.Mob;
import com.github.lgdd.osgi.minecraft.summon.api.SummonService;
import java.util.List;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicyOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    immediate = true,
    property = {
        "scheduler.name=SummonerJob",
        "scheduler.period:Long=10",
        "scheduler.concurrent:Boolean=false"
    }
)
public class SummonScheduler
    implements Runnable {

  @Override
  public void run() {

    if (summonServices == null || summonServices.isEmpty()) {
      log.info("No summon service available. Waiting for one...");
    } else {
      summonServices.forEach(summonService -> {
        Mob mob = summonService.summon();
        log.info("Summon new {}", mob.getName());
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      });
      log.info("---");
    }
  }

  @Reference(
      cardinality = ReferenceCardinality.MULTIPLE,
      policyOption = ReferencePolicyOption.GREEDY
  )
  private List<SummonService> summonServices;

  private static final Logger log = LoggerFactory.getLogger(SummonScheduler.class);
}
