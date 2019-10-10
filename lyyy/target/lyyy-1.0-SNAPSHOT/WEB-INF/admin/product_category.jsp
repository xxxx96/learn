<%--
  Created by IntelliJ IDEA.
  User: U
  Date: 2019/7/8
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/meta.jsp"/>
<% String path = request.getContextPath();%>
<% String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   %>

    <title>产品分类</title>
    <link rel="stylesheet" href="<%=basePath%>lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body>
<!--_header 作为公共模版分离出去-->
<jsp:include page="common/header.jsp"/>
<!--_menu 作为公共模版分离出去-->
<jsp:include page="common/menu.jsp"/>
<!--/_menu 作为公共模版分离出去-->

<section class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 产品管理 <span class="c-gray en">&gt;</span> 产品分类 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <div class="Hui-article">
        <article class="cl pd-20">
            <table class="table">
                <tr>
                    <td width="200" class="va-t"><ul id="treeDemo" class="ztree"></ul></td>
                    <td class="va-t"><iframe ID="testIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=390px SRC="product_category_add"></iframe></td>
                </tr>
            </table>
        </article>
    </div>
</section>
<!--_footer 作为公共模版分离出去-->
<jsp:include page="common/footer.jsp"/>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->

<script type="text/javascript" src="<%=basePath%>lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=basePath%>lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="<%=basePath%>lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript">
    var setting = {
        view: {
            dblClickExpand: false,
            showLine: false,
            selectedMulti: false
        },
        data: {
            simpleData: {
                enable:true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        },
        callback: {
            beforeClick: function(treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("tree");
                if (treeNode.isParent) {
                    zTree.expandNode(treeNode);
                    return false;
                } else {
                    demoIframe.attr("src",treeNode.file + ".html");
                    return true;
                }
            }
        }
    };

    var zNodes =[
        { id:1, pId:0, name:"一级分类", open:true},
        { id:11, pId:1, name:"二级分类"},
        { id:111, pId:"11", name:"测试一"},
        { id:112, pId:"1,1", name:"测试二"},
        { id:113, pId:11, name:"三级分类"},
        { id:114, pId:11, name:"三级分类"},
        { id:115, pId:11, name:"三级分类"},
        { id:12, pId:1, name:"二级分类 1-2"},
        { id:121, pId:12, name:"三级分类 1-2-1"},
        { id:122, pId:12, name:"三级分类 1-2-2"},
    ];

    var code;

    function showCode(str) {
        if (!code) code = $("#code");
        code.empty();
        code.append("<li>"+str+"</li>");
    }

    $(document).ready(function(){
        var t = $("#treeDemo");
        t = $.fn.zTree.init(t, setting, zNodes);
        demoIframe = $("#testIframe");
        demoIframe.bind("load", loadReady);
        var zTree = $.fn.zTree.getZTreeObj("tree");
        zTree.selectNode(zTree.getNodeByParam("id",'11'));
    });
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
