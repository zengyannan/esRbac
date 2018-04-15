/**
 * Created by Ng on 2017/4/16.
 */
(function () {
    var login=(function () {
        var checkCookie =function () {
            if($.cookie('rmUser')=='true'){
                $('#remeber_me').prop('checked',true);
                $('#userName').val($.cookie('userName'));
            }
        }
        var eventHandler=function () {
            return function () {
                $(document).keydown(function(event){
                    if(event.keyCode == 13){ //绑定回车
                        $('#login-submit').click();
                    }
                });
				//提示框
                $('#login-submit').on('click', function () {
                    var userName = $('#userName').val();
                    var password = $('#inputPassword').val();
                    $.post("/admin/doLogin",
                        {userName:userName,password:password},
                        function (r) {
                            if(r.success==true){
                                location.href="/index/index";
                            }else{
                               // alert(r.error);
                                $('#login-submit').popover({animation:true,content:r.error,delay: { "show": 500, "hide": 100 }});
                                $('#login-submit').popover('show');
                            }
                        }
                        ,'json');
                });
                //绑定记住账号的选择框
                $('#remeber_me').on('click',function () {
                    if ($("#remeber_me").prop('checked') == true) {
                        console.log("ss");
                        var userName = $("#userName").val();
                        $.cookie("rmUser", "true", { expires: 7 }); // 存储一个带7天期限的 cookie
                        $.cookie("userName", userName, { expires: 7 }); // 存储一个带7天期限的 cookie
                    }
                    else {
                        $.cookie("rmUser", "false", { expires: -1 });        // 删除 cookie
                        $.cookie("userName", '', { expires: -1 });
                    }
                });
            }
        }
        return {eventHandler:eventHandler(),checkCookie:checkCookie}
    })();
    function main() {
        login.eventHandler();
        login.checkCookie();
    }
    main()
})();