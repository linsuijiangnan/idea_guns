/**
 * 用户表2管理初始化
 */
var User2 = {
    id: "User2Table",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
User2.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '用户表2的id', field: 'user2Id', visible: true, align: 'center', valign: 'middle'},
            {title: '用户表的id引用主键ch_user1中的user_id', field: 'userId', visible: true, align: 'center', valign: 'middle'},
            {title: '电话', field: 'userPhoto', visible: true, align: 'center', valign: 'middle'},
            {title: '省份', field: 'userAddressproince', visible: true, align: 'center', valign: 'middle'},
            {title: '城市', field: 'userAddresscity', visible: true, align: 'center', valign: 'middle'},
            {title: '开始工作时间', field: 'userWorkstart', visible: true, align: 'center', valign: 'middle'},
            {title: '结束工作时间', field: 'userWorkover', visible: true, align: 'center', valign: 'middle'},
            {title: '职业方向', field: 'userIndustrytype', visible: true, align: 'center', valign: 'middle'},
            {title: '职业', field: 'userIndustry', visible: true, align: 'center', valign: 'middle'},
            {title: '工作状态（正常非正常）', field: 'userWorkstate', visible: true, align: 'center', valign: 'middle'},
            {title: '工作经历的公司', field: 'userExperiencecompany', visible: true, align: 'center', valign: 'middle'},
            {title: '工作经历的职业', field: 'userExperienceoccupation', visible: true, align: 'center', valign: 'middle'},
            {title: '价格', field: 'userPrice', visible: true, align: 'center', valign: 'middle'},
            {title: '个人介绍', field: 'userIntroduction', visible: true, align: 'center', valign: 'middle'},
            {title: '工作内容', field: 'userWorkcontent', visible: true, align: 'center', valign: 'middle'},
            {title: '工作内容图片', field: 'userWorkpicture', visible: true, align: 'center', valign: 'middle'},
            {title: '添加工作内容id引用other_addwork表中的addwork_id', field: 'addwork', visible: true, align: 'center', valign: 'middle'},
            {title: '常住地址', field: 'userAddress', visible: true, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'userName', visible: true, align: 'center', valign: 'middle'},
            {title: '支付宝账号', field: 'userAlipayuser', visible: true, align: 'center', valign: 'middle'},
            {title: '支付宝密码', field: 'userAlipaypass', visible: true, align: 'center', valign: 'middle'},
            {title: '评分', field: 'userScore', visible: true, align: 'center', valign: 'middle'},
            {title: '照片', field: 'userPicture', visible: true, align: 'center', valign: 'middle'},
            {title: '评论数', field: 'userCommentnumber', visible: true, align: 'center', valign: 'middle'},
            {title: '可用', field: 'userRemake', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
User2.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        User2.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加用户表2
 */
User2.openAddUser2 = function () {
    var index = layer.open({
        type: 2,
        title: '添加用户表2',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/user2/user2_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看用户表2详情
 */
User2.openUser2Detail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '用户表2详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/user2/user2_update/' + User2.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除用户表2
 */
User2.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/user2/delete", function (data) {
            Feng.success("删除成功!");
            User2.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("user2Id",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询用户表2列表
 */
User2.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    User2.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = User2.initColumn();
    var table = new BSTable(User2.id, "/user2/list", defaultColunms);
    table.setPaginationType("client");
    User2.table = table.init();
});
