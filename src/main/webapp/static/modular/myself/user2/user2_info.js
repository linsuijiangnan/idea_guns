/**
 * 初始化用户表2详情对话框
 */
var User2InfoDlg = {
    user2InfoData : {}
};

/**
 * 清除数据
 */
User2InfoDlg.clearData = function() {
    this.user2InfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
User2InfoDlg.set = function(key, val) {
    this.user2InfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
User2InfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
User2InfoDlg.close = function() {
    parent.layer.close(window.parent.User2.layerIndex);
}

/**
 * 收集数据
 */
User2InfoDlg.collectData = function() {
    this
    .set('user2Id')
    .set('userId')
    .set('userPhoto')
    .set('userAddressproince')
    .set('userAddresscity')
    .set('userWorkstart')
    .set('userWorkover')
    .set('userIndustrytype')
    .set('userIndustry')
    .set('userWorkstate')
    .set('userExperiencecompany')
    .set('userExperienceoccupation')
    .set('userPrice')
    .set('userIntroduction')
    .set('userWorkcontent')
    .set('userWorkpicture')
    .set('addwork')
    .set('userAddress')
    .set('userName')
    .set('userAlipayuser')
    .set('userAlipaypass')
    .set('userScore')
    .set('userPicture')
    .set('userCommentnumber')
    .set('userRemake');
}

/**
 * 提交添加
 */
User2InfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/user2/add", function(data){
        Feng.success("添加成功!");
        window.parent.User2.table.refresh();
        User2InfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.user2InfoData);
    ajax.start();
}

/**
 * 提交修改
 */
User2InfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/user2/update", function(data){
        Feng.success("修改成功!");
        window.parent.User2.table.refresh();
        User2InfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.user2InfoData);
    ajax.start();
}

$(function() {

});
