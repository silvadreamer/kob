<!-- 上层为地图的组件 -->
<template>
    <div class="playground">
        <!-- 显示地图 -->
        <GameMap />
    </div>
</template>

<script>
import GameMap from '@/components/GameMap.vue';
export default {
    components: {
        GameMap
    }
}
</script>

<style scoped>
div.playground {
    width: 60vw;
    height: 70vh;
    margin: 40px auto;
}
</style>