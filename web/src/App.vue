<template>
  <NavBar/>
  <router-view/>
</template>

<script>
import NavBar from './components/NavBar.vue'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"

export default{
  components:{
    NavBar,
  },
  setup()
  {
    // $.ajax({
    //   url: 'http://localhost:3000/user/account/token/',
    //   type: "post",
    //   data: {
    //     username:"1",
    //     password:"1",
    //   },
    //   success(resp){
    //     console.log(resp)
    //   },
    //   error(resp){
    //     console.log(resp)
    //   }
    // })

    // $.ajax({
    //   url: 'http://localhost:3000/user/account/info/',
    //   type:'get',
    //   headers:{
    //     Authorization:"Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI5NDhmYzMxYTBhMzc0N2E4YmJjZGY0Nzk0YzBjNmUxZCIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTY4NTI1NTY1OCwiZXhwIjoxNjg2NDY1MjU4fQ.qUDt4NhtdRZQWCEBzJd6VfOtMF_jJo1rpE_tM7OUffE", 
    //   },
    //   success(resp){
    //     console.log(resp)
    //   },
    //   error(resp){
    //     console.log(resp)
    //   }
    // })
    
    // $.ajax({
    //   url:"http://localhost:3000/user/account/register/",
    //   type:'post',
    //   data:{
    //     username:4,
    //     password:4,
    //     confirmedPassword:4
    //   },
    //   success(resp){
    //     console.log(resp)
    //   },
    //   error(resp){
    //     console.log(resp)
    //   }
    // })

  }
}
</script>

<style>
body{
  background-image: url(./assets/img/background.jpg);
  background-size: cover;
}
</style>
