/**
 * 评价管理初始化
 */
var Evaluation = {
    id: "EvaluationTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Evaluation.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '评价表主键100开始递增', field: 'evaluationId', visible: true, align: 'center', valign: 'middle'},
            {title: '专家id', field: 'evaluationExpertsid', visible: true, align: 'center', valign: 'middle'},
            {title: '用户id', field: 'evaluationUserid', visible: true, align: 'center', valign: 'middle'},
            {title: '评价内容', field: 'evaluationContent', visible: true, align: 'center', valign: 'middle'},
            {title: '评价时间', field: 'evaluationTime', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'evaluationRemake', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Evaluation.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Evaluation.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加评价
 */
Evaluation.openAddEvaluation = function () {
    var index = layer.open({
        type: 2,
        title: '添加评价',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/evaluation/evaluation_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看评价详情
 */
Evaluation.openEvaluationDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '评价详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/evaluation/evaluation_update/' + Evaluation.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除评价
 */
Evaluation.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/evaluation/delete", function (data) {
            Feng.success("删除成功!");
            Evaluation.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("evaluationId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询评价列表
 */
Evaluation.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Evaluation.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Evaluation.initColumn();
    var table = new BSTable(Evaluation.id, "/evaluation/list", defaultColunms);
    table.setPaginationType("client");
    Evaluation.table = table.init();
});
