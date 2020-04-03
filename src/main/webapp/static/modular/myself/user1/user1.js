/**
 * 用户表1管理初始化
 */
var User1 = {
    id: "User1Table",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
User1.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '用户id', field: 'userId', visible: true, align: 'center', valign: 'middle'},
            {title: '微信id', field: 'userWeixinid', visible: true, align: 'center', valign: 'middle'},
            {title: '微信名', field: 'userWeixinname', visible: true, align: 'center', valign: 'middle'},
            {title: '身份（管理员，普通，专家）', field: 'userIdentity', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证号', field: 'userIdentitycard', visible: true, align: 'center', valign: 'middle'},
            {title: '生日', field: 'userBrithday', visible: true, align: 'center', valign: 'middle'},
            {title: '创建日期', field: 'userCreatetime', visible: true, align: 'center', valign: 'middle'},
            {title: '真是姓名', field: 'userName', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'userVersion', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证正面', field: 'userIdentitypicturefront', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证反面', field: 'userIdentitypictureback', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
User1.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        User1.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加用户表1
 */
User1.openAddUser1 = function () {
    var index = layer.open({
        type: 2,
        title: '添加用户表1',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/user1/user1_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看用户表1详情
 */
User1.openUser1Detail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '用户表1详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/user1/user1_update/' + User1.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除用户表1
 */
User1.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/user1/delete", function (data) {
            Feng.success("删除成功!");
            User1.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("user1Id",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询用户表1列表
 */
User1.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    User1.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = User1.initColumn();
    var table = new BSTable(User1.id, "/user1/list", defaultColunms);
    table.setPaginationType("client");
    User1.table = table.init();
});
