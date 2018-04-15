/**
 * Created by Ng on 2017/4/12.
 */
(function () {
    var Tree = (function () {
        var SCOPE_URL={
            leftTreeUrl:"/index/leftTree",
        }
        var loadNodeHref =function () {
            return function(href){
                $("#load-content").load(href,function (data) {

                });
            }
        };
        var init=function () {
            return $.get(SCOPE_URL.leftTreeUrl,function (r) {
                var treeData =[r.data];
                $('#tree').treeview({
                    data:treeData,
                   enableLinks:true,
                    levels: 4,
                    // onNodeSelected:function (event,data) {
                    //     if(data.href !== null && data.href !== undefined && data.href !== '' &&data.href.length!=0){
                    //         Tree.loadNodeHref(data.href);
                    //     }
                    // }
                });
            },'json');
        };
        return {init:init,loadNodeHref:loadNodeHref(),SCOPE_URL:SCOPE_URL}
    })();
    function main() {
        Tree.init();
    }
    main();
})();