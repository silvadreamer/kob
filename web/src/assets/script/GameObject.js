const Game_object = [];

export class GameObject {
    constructor() {
        //每构造一次，就push一个(每个小格)
        Game_object.push(this);
        //时间差
        this.timedelta = 0;
        this.has_called_start = false;
    }

    start() //只执行一次
    { }

    update()    //每一帧都执行,除了第一帧
    { }

    on_destory()    //删除之前执行
    { }

    destory() {
        this.on_destory();

        for (let i in Game_object) {
            const obj = Game_object[i];
            if (obj === this) {
                Game_object.splice(i);
                break;
            }
        }
    }
}

let last_timestamp; //上一次执行的时刻
const step = (timestamp) => {
    for (let obj of Game_object) {
        if (!obj.has_called_start) {
            obj.has_called_start = true;
            //
            obj.start();
        }
        else {
            obj.timedelta = timestamp - last_timestamp;
            obj.update()
        }
    }

    last_timestamp = timestamp;
    requestAnimationFrame(step);
}

//调用
requestAnimationFrame(step);