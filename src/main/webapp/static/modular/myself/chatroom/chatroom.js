/**
 * 聊天室管理初始化
 */
var Chatroom = {
    id: "ChatroomTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Chatroom.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '聊天室主键100开始递增', field: 'chatroomId', visible: true, align: 'center', valign: 'middle'},
            {title: '专家id', field: 'chatroomExpertsid', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'chatroomUserid', visible: true, align: 'center', valign: 'middle'},
            {title: '聊天有效时间', field: 'chatroomTime', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'chartroomRemake', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Chatroom.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Chatroom.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加聊天室
 */
Chatroom.openAddChatroom = function () {
    var index = layer.open({
        type: 2,
        title: '添加聊天室',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/chatroom/chatroom_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看聊天室详情
 */
Chatroom.openChatroomDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '聊天室详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/chatroom/chatroom_update/' + Chatroom.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除聊天室
 */
Chatroom.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/chatroom/delete", function (data) {
            Feng.success("删除成功!");
            Chatroom.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("chatroomId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询聊天室列表
 */
Chatroom.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Chatroom.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Chatroom.initColumn();
    var table = new BSTable(Chatroom.id, "/chatroom/list", defaultColunms);
    table.setPaginationType("client");
    Chatroom.table = table.init();
});
