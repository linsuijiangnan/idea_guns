/**
 * 初始化聊天内容详情对话框
 */
var ChatrecordInfoDlg = {
    chatrecordInfoData : {}
};

/**
 * 清除数据
 */
ChatrecordInfoDlg.clearData = function() {
    this.chatrecordInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ChatrecordInfoDlg.set = function(key, val) {
    this.chatrecordInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ChatrecordInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ChatrecordInfoDlg.close = function() {
    parent.layer.close(window.parent.Chatrecord.layerIndex);
}

/**
 * 收集数据
 */
ChatrecordInfoDlg.collectData = function() {
    this
    .set('chatrecordId')
    .set('chatroomId')
    .set('chatrecordTime')
    .set('chatrecordContent')
    .set('chatrecordRemake');
}

/**
 * 提交添加
 */
ChatrecordInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/chatrecord/add", function(data){
        Feng.success("添加成功!");
        window.parent.Chatrecord.table.refresh();
        ChatrecordInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.chatrecordInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ChatrecordInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/chatrecord/update", function(data){
        Feng.success("修改成功!");
        window.parent.Chatrecord.table.refresh();
        ChatrecordInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.chatrecordInfoData);
    ajax.start();
}

$(function() {

});
