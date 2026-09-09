package com.example.myclient.gui;

import com.example.myclient.core.*;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public final class ClickGuiScreen extends Screen {
    private static final int BG=0xD90D1016, PANEL=0xE51A1D25, ROW=0xE52A2D36, ON=0xE52D55A0, TEXT=0xFFF1F4F8, MUTED=0xFF9AA4B2, BLUE=0xFF64B5FF;
    private final Category[] cats = Category.values();
    private int scroll;
    public ClickGuiScreen() { super(Text.literal("MyClient")); }

    @Override public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        ctx.fill(0,0,width,height,BG);
        int gap=8, panelW=172, top=22, bottom=height-12;
        int total=cats.length*panelW+(cats.length-1)*gap;
        int x0=Math.max(8,(width-total)/2);
        for(int ci=0;ci<cats.length;ci++) {
            int x=x0+ci*(panelW+gap);
            ctx.fill(x,top,x+panelW,bottom,PANEL);
            ctx.drawTextWithShadow(textRenderer,Text.literal(cats[ci].name()),x+9,top+7,BLUE);
            int y=top+29+scroll;
            for(Module m:ModuleManager.category(cats[ci])) {
                if(y<top+25){y+=22;continue;}
                if(y+19>bottom) break;
                int color=m.enabled()?ON:ROW;
                ctx.fill(x+4,y,x+panelW-4,y+19,color);
                String label=m.name()+(m.implemented()?"":" *");
                ctx.drawTextWithShadow(textRenderer,Text.literal(label),x+9,y+5,m.enabled()?TEXT:MUTED);
                y+=22;
            }
        }
        ctx.drawTextWithShadow(textRenderer,Text.literal("Right Shift: GUI  |  * = registered/WIP"),10,height-9,0xFF7E8794);
        super.render(ctx,mouseX,mouseY,delta);
    }

    @Override public boolean mouseClicked(double mx,double my,int button) {
        if(button!=0) return super.mouseClicked(mx,my,button);
        int gap=8,panelW=172,top=22,bottom=height-12,total=cats.length*panelW+(cats.length-1)*gap,x0=Math.max(8,(width-total)/2);
        for(int ci=0;ci<cats.length;ci++) {
            int x=x0+ci*(panelW+gap); if(mx<x||mx>x+panelW) continue;
            int y=top+29+scroll;
            for(Module m:ModuleManager.category(cats[ci])) {
                if(my>=y&&my<=y+19){m.toggle();return true;} y+=22;
            }
        }
        return true;
    }
    @Override public boolean mouseScrolled(double mx,double my,double h,double v){scroll=(int)Math.max(-800,Math.min(0,scroll+(v>0?30:-30)));return true;}
    @Override public boolean shouldPause(){return false;}
}
