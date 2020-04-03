/**
 * 初始化评价详情对话框
 */
var EvaluationInfoDlg = {
    evaluationInfoData : {}
};

/**
 * 清除数据
 */
EvaluationInfoDlg.clearData = function() {
    this.evaluationInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
EvaluationInfoDlg.set = function(key, val) {
    this.evaluationInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
EvaluationInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
EvaluationInfoDlg.close = function() {
    parent.layer.close(window.parent.Evaluation.layerIndex);
}

/**
 * 收集数据
 */
EvaluationInfoDlg.collectData = function() {
    this
    .set('evaluationId')
    .set('evaluationExpertsid')
    .set('evaluationUserid')
    .set('evaluationContent')
    .set('evaluationTime')
    .set('evaluationRemake');
}

/**
 * 提交添加
 */
EvaluationInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/evaluation/add", function(data){
        Feng.success("添加成功!");
        window.parent.Evaluation.table.refresh();
        EvaluationInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.evaluationInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
EvaluationInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/evaluation/update", function(data){
        Feng.success("修改成功!");
        window.parent.Evaluation.table.refresh();
        EvaluationInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.evaluationInfoData);
    ajax.start();
}

$(function() {

});
