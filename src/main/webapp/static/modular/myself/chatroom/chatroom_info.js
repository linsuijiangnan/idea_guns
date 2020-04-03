/**
 * 初始化聊天室详情对话框
 */
var ChatroomInfoDlg = {
    chatroomInfoData : {}
};

/**
 * 清除数据
 */
ChatroomInfoDlg.clearData = function() {
    this.chatroomInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ChatroomInfoDlg.set = function(key, val) {
    this.chatroomInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ChatroomInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ChatroomInfoDlg.close = function() {
    parent.layer.close(window.parent.Chatroom.layerIndex);
}

/**
 * 收集数据
 */
ChatroomInfoDlg.collectData = function() {
    this
    .set('chatroomId')
    .set('chatroomExpertsid')
    .set('chatroomUserid')
    .set('chatroomTime')
    .set('chartroomRemake');
}

/**
 * 提交添加
 */
ChatroomInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/chatroom/add", function(data){
        Feng.success("添加成功!");
        window.parent.Chatroom.table.refresh();
        ChatroomInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.chatroomInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ChatroomInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/chatroom/update", function(data){
        Feng.success("修改成功!");
        window.parent.Chatroom.table.refresh();
        ChatroomInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.chatroomInfoData);
    ajax.start();
}

$(function() {

});
