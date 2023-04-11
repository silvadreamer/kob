<template>
    <nav class="navbar navbar-expand-lg bg-body-tertiary navbar-dark bg-dark">
        <div class="container">
            <!-- 路由模式，不刷新 -->
            <router-link class="navbar-brand" :to="{ name: 'home' }">KoB</router-link>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <router-link class="nav-link" active-class="active" :to="{ name: 'PkIndexView' }">对战</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" active-class="active"
                            :to="{ name: 'RecordIndexView' }">对局列表</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" active-class="active"
                            :to="{ name: 'RanklistIndexView' }">排行榜</router-link>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            我的
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <router-link class="dropdown-item" :to="{ name: 'UserBotIndexView' }">我的bot</router-link>
                            </li>
                            <li><a class="dropdown-item" href="#">退出登录</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>

<script>

</script>

<style scoped></style>