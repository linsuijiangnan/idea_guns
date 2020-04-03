/**
 * 初始化回答详情对话框
 */
var AnswerInfoDlg = {
    answerInfoData : {}
};

/**
 * 清除数据
 */
AnswerInfoDlg.clearData = function() {
    this.answerInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AnswerInfoDlg.set = function(key, val) {
    this.answerInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AnswerInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
AnswerInfoDlg.close = function() {
    parent.layer.close(window.parent.Answer.layerIndex);
}

/**
 * 收集数据
 */
AnswerInfoDlg.collectData = function() {
    this
    .set('userId')
    .set('answerId')
    .set('questionId')
    .set('answerDegree')
    .set('answerCompletion')
    .set('answerAttitude')
    .set('answerEfficiency')
    .set('answerEvaluation')
    .set('answerRemake');
}

/**
 * 提交添加
 */
AnswerInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/answer/add", function(data){
        Feng.success("添加成功!");
        window.parent.Answer.table.refresh();
        AnswerInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.answerInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
AnswerInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/answer/update", function(data){
        Feng.success("修改成功!");
        window.parent.Answer.table.refresh();
        AnswerInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.answerInfoData);
    ajax.start();
}

$(function() {

});
