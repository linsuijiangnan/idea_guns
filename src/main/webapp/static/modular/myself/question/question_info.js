/**
 * 初始化问题详情对话框
 */
var QuestionInfoDlg = {
    questionInfoData : {}
};

/**
 * 清除数据
 */
QuestionInfoDlg.clearData = function() {
    this.questionInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
QuestionInfoDlg.set = function(key, val) {
    this.questionInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
QuestionInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
QuestionInfoDlg.close = function() {
    parent.layer.close(window.parent.Question.layerIndex);
}

/**
 * 收集数据
 */
QuestionInfoDlg.collectData = function() {
    this
    .set('userId')
    .set('questionId')
    .set('questionDirection')
    .set('questionType')
    .set('questionPicture')
    .set('questionPrice')
    .set('questionPhoto')
    .set('questionDescribe')
    .set('questionResponder')
    .set('questionTime')
    .set('questionRemake');
}

/**
 * 提交添加
 */
QuestionInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/question/add", function(data){
        Feng.success("添加成功!");
        window.parent.Question.table.refresh();
        QuestionInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.questionInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
QuestionInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/question/update", function(data){
        Feng.success("修改成功!");
        window.parent.Question.table.refresh();
        QuestionInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.questionInfoData);
    ajax.start();
}

$(function() {

});
