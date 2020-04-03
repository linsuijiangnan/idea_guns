/**
 * 回答管理初始化
 */
var Answer = {
    id: "AnswerTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Answer.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '引用ch_user表中的user_id', field: 'userId', visible: true, align: 'center', valign: 'middle'},
            {title: '回答Id', field: 'answerId', visible: true, align: 'center', valign: 'middle'},
            {title: '问问题id', field: 'questionId', visible: true, align: 'center', valign: 'middle'},
            {title: '解决程度', field: 'answerDegree', visible: true, align: 'center', valign: 'middle'},
            {title: '完成度', field: 'answerCompletion', visible: true, align: 'center', valign: 'middle'},
            {title: '态度', field: 'answerAttitude', visible: true, align: 'center', valign: 'middle'},
            {title: '效率', field: 'answerEfficiency', visible: true, align: 'center', valign: 'middle'},
            {title: '评价', field: 'answerEvaluation', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'answerRemake', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Answer.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Answer.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加回答
 */
Answer.openAddAnswer = function () {
    var index = layer.open({
        type: 2,
        title: '添加回答',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/answer/answer_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看回答详情
 */
Answer.openAnswerDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '回答详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/answer/answer_update/' + Answer.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除回答
 */
Answer.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/answer/delete", function (data) {
            Feng.success("删除成功!");
            Answer.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("answerId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询回答列表
 */
Answer.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Answer.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Answer.initColumn();
    var table = new BSTable(Answer.id, "/answer/list", defaultColunms);
    table.setPaginationType("client");
    Answer.table = table.init();
});
