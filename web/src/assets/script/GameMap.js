import { GameObject } from "./GameObject";
import { Walls } from "./Walls";



export class GameMap extends GameObject {
    constructor(ctx, parent) {
        super();

        //获得上下文
        this.ctx = ctx;
        this.parent = parent;
        this.L = 0;

        this.col = 13;
        this.row = 13;

        this.walls_count = 24;
        this.walls = [];

    }

    //检查是否连通
    check_is_valid(g, sx, sy, ex, ey) {
        if (sx == ex && sy == ey) return true;
        g[sx][sy] = true;

        let dx = [-1, 0, 1, 0], dy = [0, 1, 0 - 1];
        for (let i = 0; i < 4; i++) {
            let x = sx + dx[i], y = sy + dy[i];
            if (g[x][y] == false && this.check_is_valid(g, x, y, ex, ey) == true) return true;
        }

        return false;
    }

    //建立障碍
    CreateWalls() {
        const g = [];
        for (let i = 0; i < this.row; i++) {
            g[i] = [];
            for (let j = 0; j < this.col; j++) {
                g[i][j] = false;
            }
        }

        //创建边缘障碍物
        for (let i = 0; i < this.row; i++) {
            g[i][0] = g[i][this.col - 1] = true;
        }

        for (let i = 0; i < this.col; i++) {
            g[0][i] = g[this.row - 1][i] = true;
        }

        //创建随机障碍物
        for (let i = 0; i < this.walls_count/2; i++) {
            for (let j = 0; j < 1000; j++) {
                let r = parseInt(Math.random() * this.row);
                let c = parseInt(Math.random() * this.col);
                if (g[r][c] || g[c][r]) continue;
                if (r == this.row - 2 && c == 1 || r == 1 && c == this.col - 2) continue;
                g[r][c] = g[c][r] = true;
                break;
            }
        }

        const copy_g = JSON.parse(JSON.stringify(g));
        if (!this.check_is_valid(copy_g, this.row - 2, 1, 1, this.col - 2)) return false;

        for (let i = 0; i < this.row; i++) {
            for (let j = 0; j < this.col; j++) {
                if (g[i][j]) {
                    this.walls.push(new Walls(i, j, this));
                }
            }
        }

        return true;
    }

    start() {
        for (let i = 1; i <= 1000; i++) {
            if (this.CreateWalls()) break;
        }
    }

    update_size() {
        this.L = parseInt(Math.min(this.parent.clientWidth / this.col, this.parent.clientHeight / this.row));
        this.ctx.canvas.width = this.L * this.col;
        this.ctx.canvas.height = this.L * this.row;
    }

    update() {
        this.update_size();
        this.render();
    }

    //绘制地图背景
    render() {
        const color_even = "#AAD771", color_odd = "#AAD730";
        for (let r = 0; r < this.row; r++) {
            for (let c = 0; c < this.col; c++) {
                if ((r + c) % 2 == 0) {
                    this.ctx.fillStyle = color_even;
                }
                else {
                    this.ctx.fillStyle = color_odd;
                }
                this.ctx.fillRect(c * this.L, r * this.L, this.L, this.L);
            }
        }
    }
}