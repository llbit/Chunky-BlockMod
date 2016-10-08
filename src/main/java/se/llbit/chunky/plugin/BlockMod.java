/* Copyright (c) 2016 Jesper Öqvist <jesper@llbit.se>
 *
 * Chunky is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Chunky is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Chunky.  If not, see <http://www.gnu.org/licenses/>.
 */
package se.llbit.chunky.plugin;

import se.llbit.chunky.Plugin;
import se.llbit.chunky.main.Chunky;
import se.llbit.chunky.main.ChunkyOptions;
import se.llbit.chunky.resources.Texture;
import se.llbit.chunky.resources.TexturePackLoader;
import se.llbit.chunky.ui.ChunkyFx;
import se.llbit.chunky.world.Block;

import java.io.FileNotFoundException;

/**
 * This plugin makes grass blocks render as lava blocks.
 */
public class BlockMod implements Plugin {
  @Override public void attach(Chunky chunky) {
    Block.set(Block.GRASS_ID, new Block(Block.GRASS_ID, "Not Grass", Texture.lava) {
      {
        isEmitter = true;
        emittance = 1.0;
      }
    });
  }

  public static void main(String[] args)
      throws FileNotFoundException, TexturePackLoader.TextureLoadingError {
    // Start Chunky normally with this plugin attached.
    Chunky.loadDefaultTextures();
    Chunky chunky = new Chunky(ChunkyOptions.getDefaults());
    new BlockMod().attach(chunky);
    ChunkyFx.startChunkyUI(chunky);
  }
}
