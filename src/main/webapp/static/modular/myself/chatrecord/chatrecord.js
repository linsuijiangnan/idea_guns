/**
 * 聊天内容管理初始化
 */
var Chatrecord = {
    id: "ChatrecordTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Chatrecord.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '聊天内容的id，自动递增从100开始', field: 'chatrecordId', visible: true, align: 'center', valign: 'middle'},
            {title: '聊天室的id可以和chatroom主外键', field: 'chatroomId', visible: true, align: 'center', valign: 'middle'},
            {title: '聊天时间', field: 'chatrecordTime', visible: true, align: 'center', valign: 'middle'},
            {title: '聊天内容', field: 'chatrecordContent', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'chatrecordRemake', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Chatrecord.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Chatrecord.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加聊天内容
 */
Chatrecord.openAddChatrecord = function () {
    var index = layer.open({
        type: 2,
        title: '添加聊天内容',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/chatrecord/chatrecord_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看聊天内容详情
 */
Chatrecord.openChatrecordDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '聊天内容详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/chatrecord/chatrecord_update/' + Chatrecord.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除聊天内容
 */
Chatrecord.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/chatrecord/delete", function (data) {
            Feng.success("删除成功!");
            Chatrecord.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("chatrecordId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询聊天内容列表
 */
Chatrecord.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Chatrecord.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Chatrecord.initColumn();
    var table = new BSTable(Chatrecord.id, "/chatrecord/list", defaultColunms);
    table.setPaginationType("client");
    Chatrecord.table = table.init();
});
