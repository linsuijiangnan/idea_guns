/**
 * 初始化解释详情对话框
 */
var ExplanationInfoDlg = {
    explanationInfoData : {}
};

/**
 * 清除数据
 */
ExplanationInfoDlg.clearData = function() {
    this.explanationInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ExplanationInfoDlg.set = function(key, val) {
    this.explanationInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ExplanationInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ExplanationInfoDlg.close = function() {
    parent.layer.close(window.parent.Explanation.layerIndex);
}

/**
 * 收集数据
 */
ExplanationInfoDlg.collectData = function() {
    this
    .set('explanationId')
    .set('userId')
    .set('explanationDriection')
    .set('explanationType');
}

/**
 * 提交添加
 */
ExplanationInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/explanation/add", function(data){
        Feng.success("添加成功!");
        window.parent.Explanation.table.refresh();
        ExplanationInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.explanationInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ExplanationInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/explanation/update", function(data){
        Feng.success("修改成功!");
        window.parent.Explanation.table.refresh();
        ExplanationInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.explanationInfoData);
    ajax.start();
}

$(function() {

});
