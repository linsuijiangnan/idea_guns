/**
 * 初始化用户表1详情对话框
 */
var User1InfoDlg = {
    user1InfoData : {}
};

/**
 * 清除数据
 */
User1InfoDlg.clearData = function() {
    this.user1InfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
User1InfoDlg.set = function(key, val) {
    this.user1InfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
User1InfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
User1InfoDlg.close = function() {
    parent.layer.close(window.parent.User1.layerIndex);
}

/**
 * 收集数据
 */
User1InfoDlg.collectData = function() {
    this
    .set('userId')
    .set('userWeixinid')
    .set('userWeixinname')
    .set('userIdentity')
    .set('userIdentitycard')
    .set('userBrithday')
    .set('userCreatetime')
    .set('userName')
    .set('userVersion')
    .set('userIdentitypicturefront')
    .set('userIdentitypictureback');
}

/**
 * 提交添加
 */
User1InfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/user1/add", function(data){
        Feng.success("添加成功!");
        window.parent.User1.table.refresh();
        User1InfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.user1InfoData);
    ajax.start();
}

/**
 * 提交修改
 */
User1InfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/user1/update", function(data){
        Feng.success("修改成功!");
        window.parent.User1.table.refresh();
        User1InfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.user1InfoData);
    ajax.start();
}

$(function() {

});
