import { GameObject } from "./GameObject";

//障碍物
export class Walls extends GameObject{
    constructor(r, c, GameMap){
        super();
        
        this.r = r;
        this.c =c;
        this.gamemap = GameMap;
        this.color = "#B37226";
    }

    update(){
        this.render();
    }

    render()
    {
        this.L = this.gamemap.L;
        this.ctx = this.gamemap.ctx;

        this.ctx.fillStyle = this.color;
        this.ctx.fillRect(this.c * this.L, this.r * this.L, this.L, this.L);
    }
}