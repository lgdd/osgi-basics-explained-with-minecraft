package com.github.lgdd.osgi.minecraft.summon.api;

import java.io.IOException;

public abstract class DockerSummonService
    implements SummonService {

  protected void summonMob(Mob mob) {

    try {
      ProcessBuilder processBuilder = new ProcessBuilder(
          "docker", "exec", "mc", "rcon-cli",
          "execute", "at", "@a", "run", "summon", mob.getName().toLowerCase()
      );
      Process process = processBuilder.start();
      var exitCode = process.waitFor();

      if (exitCode != 0) {
        throw new RuntimeException("Minecraft summon command failed with exit code " + exitCode);
      }

      process.destroy();

    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
