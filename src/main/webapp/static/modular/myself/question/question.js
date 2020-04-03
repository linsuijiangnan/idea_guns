/**
 * 问题管理初始化
 */
var Question = {
    id: "QuestionTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Question.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '引用ch_user表中的user_id', field: 'userId', visible: true, align: 'center', valign: 'middle'},
            {title: '问题id', field: 'questionId', visible: true, align: 'center', valign: 'middle'},
            {title: '问题方向', field: 'questionDirection', visible: true, align: 'center', valign: 'middle'},
            {title: '问题类型', field: 'questionType', visible: true, align: 'center', valign: 'middle'},
            {title: '图片', field: 'questionPicture', visible: true, align: 'center', valign: 'middle'},
            {title: '价格', field: 'questionPrice', visible: true, align: 'center', valign: 'middle'},
            {title: '联系电话', field: 'questionPhoto', visible: true, align: 'center', valign: 'middle'},
            {title: '问题描述', field: 'questionDescribe', visible: true, align: 'center', valign: 'middle'},
            {title: '回答者', field: 'questionResponder', visible: true, align: 'center', valign: 'middle'},
            {title: '时间限制', field: 'questionTime', visible: true, align: 'center', valign: 'middle'},
            {title: '可用', field: 'questionRemake', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Question.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Question.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加问题
 */
Question.openAddQuestion = function () {
    var index = layer.open({
        type: 2,
        title: '添加问题',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/question/question_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看问题详情
 */
Question.openQuestionDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '问题详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/question/question_update/' + Question.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除问题
 */
Question.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/question/delete", function (data) {
            Feng.success("删除成功!");
            Question.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("questionId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询问题列表
 */
Question.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Question.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Question.initColumn();
    var table = new BSTable(Question.id, "/question/list", defaultColunms);
    table.setPaginationType("client");
    Question.table = table.init();
});
