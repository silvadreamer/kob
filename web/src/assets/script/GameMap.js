import { GameObject } from "./GameObject";

export class GameMap extends GameObject {
    constructor(ctx, parent) {
        super();

        this.ctx = ctx;
        this.parent = parent;
        this.L = 0;

        this.col = 13;
        this.row = 13;
    }

    start() {

    }

    update_size(){
        this.L = Math.min(this.parent.clientWidth / this.col, this.parent.clientHeight / this.row);
        this.ctx.canvas.width = this.L * this.col;
        this.ctx.canvas.height = this.L * this.row;
    }

    update() {
        this.update_size();
        this.render();
    }

    render() {
        const color_even = "#AAD751", color_odd = "#AAD780";
        for(let r = 0; r < this.row; r ++)
        {
            for(let c = 0; c < this.col; c ++)
            {
                if((r + c) % 2 == 0){
                    this.ctx.fillStyle = color_even;
                }
                else
                {
                    this.ctx.fillStyle = color_odd;
                }
                this.ctx.fillRect(c * this.L, r * this.L, this.L, this.L);
            }
        }
    }
}