<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/29
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#submit").click(function () {
                    var name = $("#name").val();
                    var psd = $("#password").val();
                    if (name == null || psd == null) {
                        alert("用户名和用户密码不可以为空！");
                        return;
                    }
                    $.ajax({
                        url: "/User/register",
                        type: "GET",
                        data: {
                            name: name,
                            password: psd
                        },
                        success(data) {
                            debugger;
                            if (data == 1) {
                                alert("注册成功！");
                                window.location.href = "index";
                            } else if(data == 2){
                                alert("该用于已经存在！");
                            } else {
                                alert("注册失败！");
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
<h3>注册页面</h3>
<br>
<table>
    <tr>
        <td><label>登录名：</label></td>
        <td><input type="input" id="name"></td>
    </tr>
    <tr>
        <td><label>密码：</label></td>
        <td><input type="password" id="password"></td>
    </tr>
    <tr>
        <td><input id="submit" type="submit" value="注册"></td>
    </tr>
</table>
</body>
</html>


