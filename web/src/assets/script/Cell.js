export class Cell {
    constructor(r, c) {
        this.r = r;
        this.c = c;
        this.x = r + 0.5;
        this.y = c + 0.5;
    }
}