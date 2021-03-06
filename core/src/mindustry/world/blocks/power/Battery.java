package mindustry.world.blocks.power;

import arc.graphics.*;
import arc.graphics.g2d.*;
import mindustry.client.*;
import mindustry.graphics.*;
import mindustry.world.*;

import static mindustry.Vars.*;

public class Battery extends PowerDistributor{
    public int topRegion = reg("-top");

    public Color emptyLightColor = Color.valueOf("f8c266");
    public Color fullLightColor = Color.valueOf("fb9567");

    public Battery(String name){
        super(name);
        outputsPower = true;
        consumesPower = true;
    }

    @Override
    public void draw(Tile tile){
        Draw.color(emptyLightColor, fullLightColor, tile.entity.power.status);
        if(Client.xray){
            Draw.alpha(Transparency.convertTransparency(1f));
        }
        Fill.square(tile.drawx(), tile.drawy(), tilesize * size / 2f - 1);
        Draw.color();

        Draw.alpha(Transparency.convertTransparency(1f));
        Draw.rect(reg(topRegion), tile.drawx(), tile.drawy());
    }
}
