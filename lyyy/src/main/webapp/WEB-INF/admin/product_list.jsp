<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: U
  Date: 2019/7/8
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String path = request.getContextPath(); %>
<% String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   %>
<jsp:include page="common/meta.jsp"/>
    <title>建材列表</title>
    <link rel="stylesheet" href="<%=basePath%>lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body>
<!--_header 作为公共模版分离出去-->
<jsp:include page="common/header.jsp"/>
<!--/_header 作为公共模版分离出去-->

<!--_menu 作为公共模版分离出去-->
<jsp:include page="common/menu.jsp"/>
<!--/_menu 作为公共模版分离出去-->

<section class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 产品管理 <span class="c-gray en">&gt;</span> 产品列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <div class="Hui-article">
        <div class="pos-a" style="width:150px;left:0;top:0; bottom:0; height:100%; border-right:1px solid #e5e5e5; background-color:#f5f5f5">
            <ul id="treeDemo" class="ztree">
            </ul>
        </div>
        <div style="margin-left:150px;">
            <div class="pd-20">
                <div class="text-c"> 日期范围：
                    <input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}'})" id="logmin" class="input-text Wdate" style="width:120px;">
                    -
                    <input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d'})" id="logmax" class="input-text Wdate" style="width:120px;">
                    <input type="text" name="" id="" placeholder=" 产品名称" style="width:250px" class="input-text">
                    <button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜产品</button>
                </div>
                <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" onclick="product_add('添加产品','product_add')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加产品</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div>
                <div class="mt-20">
                    <table class="table table-border table-bordered table-bg table-hover table-sort">
                        <thead>
                        <tr class="text-c">
                            <th width="40"><input name="" type="checkbox" value=""></th>
                            <th width="40">ID</th>
                            <th width="60">缩略图</th>
                            <th>产品名称</th>

                            <th width="60">发布状态</th>
                            <th width="100">操作</th>
                        </tr>
                        </thead>
                        <tbody>


                            <c:forEach items="${details}" var="details">
                            <tr class="text-c va-m">
                            <td><input name="" type="checkbox" value=""></td>
                            <td>${details.id}</td>
                            <td><a onClick="product_show('${details.title}','../root/${details.picUrl}','')" href="javascript:;"><img width="60" class="product-thumb" src="../../root/${details.picUrl}"></a></td>
                            <td class="text-l"><a style="text-decoration:none" onClick="product_show('${details.title}','product_show','${details.id}')" href="javascript:;"><img title="国内品牌" src="<%=basePath%>static/h-ui.admin/images/cn.gif">${details.text}</a></td>
                            <td class="td-status"><span class="label label-success radius">已发布</span></td>
                            <td class="td-manage"><a style="text-decoration:none" onClick="product_stop(this,'10001')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> <a style="text-decoration:none" class="ml-5" onClick="product_edit('产品编辑','product-add.html','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="product_del(this,'${details.text}')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
                            </tr>
                                </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>

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

    var zNodes =${category};

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

    $('.table-sort').dataTable({
        "aaSorting": [[ 1, "desc" ]],//默认第几个排序
        "bStateSave": true,//状态保存
        "aoColumnDefs": [
            {"orderable":false,"aTargets":[0,5]}// 制定列不参与排序
        ]
    });
    /*图片-添加*/
    function product_add(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*图片-查看*/
    function product_show(title,url,id){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*图片-审核*/
    function product_shenhe(obj,id){
        layer.confirm('审核文章？', {
                btn: ['通过','不通过'],
                shade: false
            },
            function(){
                $(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="product_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
                $(obj).remove();
                layer.msg('已发布', {icon:6,time:1000});
            },
            function(){
                $(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="product_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
                $(obj).remove();
                layer.msg('未通过', {icon:5,time:1000});
            });
    }
    /*图片-下架*/
    function product_stop(obj,id){
        layer.confirm('确认要下架吗？',function(index){
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="product_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
            $(obj).remove();
            layer.msg('已下架!',{icon: 5,time:1000});
        });
    }

    /*图片-发布*/
    function product_start(obj,id){
        layer.confirm('确认要发布吗？',function(index){
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="product_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
            $(obj).remove();
            layer.msg('已发布!',{icon: 6,time:1000});
        });
    }
    /*图片-申请上线*/
    function product_shenqing(obj,id){
        $(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
        $(obj).parents("tr").find(".td-manage").html("");
        layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
    }
    /*图片-编辑*/
    function product_edit(title,url,id){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*图片-删除*/
    function product_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                dataType:"json",
                url:"delete_product",
                async:false,
                type:"get",
                data:id,
                success:function(result){
                    if(result.code=1){
                        $(obj).parents("tr").remove();
                        layer.msg('已删除!',{icon:1,time:1000});
                    }else {
                        layer.msg('删除失败!',{icon:1,time:1000});
                    }
                }});

        });
    }
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
