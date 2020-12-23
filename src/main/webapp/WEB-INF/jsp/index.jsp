<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <meta charset="UTF-8">
    <script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#submit").click(function () {
                    var name = $("#name").val();
                    var psd = $("#password").val();
                    if(name == null || psd == null){
                        alert("用户名和用户密码不可以为空！");
                        return;
                    }
                    $.ajax({
                        url: "/User/login",
                        type: "GET",
                        data: {
                            name: name,
                            password: psd
                        },
                        success(data) {
                            if (data == 1) {
                                alert("登陆成功！");
                                alert("正在跳转主界面！");
                            } else {
                                alert("登陆失败！");
                            }
                        },
                        error() {
                            alert("操作异常，请重新登录！");
                        }

                    })
                }
            );
        });
    </script>
</head>

<body>

<fieldset>
    用户名:<input type="text" id="name"><br>
    密&nbsp;&nbsp;&nbsp;码:<input type="password" id="password"><br>
    <input type="button" id="submit" value="登录"><br>
</fieldset>
</body>
</html>
