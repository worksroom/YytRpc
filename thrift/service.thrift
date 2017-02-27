namespace java com.yyt.print.rpc.thrift.gen
/**
* 好友聊天Service
**/
service FriendChatThriftRpcService {
    /**
     * 保存好友关系
     * @param userId 用户ID
     * @param friendId 好友ID
     * @return
     */
    i32 saveFriend(1:i32 userId, 2:i32 friendId);

    /**
     * 删除好友关系
     * @param userId 用户ID
     * @param friendId 好友ID
     * @return
     */
    i32 deleteFriend(1:i32 userId, 2:i32 friendId);

    /**
     * 查询好友关系是否存在
     * @param userId
     * @param friendId
     * @return
     */
    string getFriend(1:i32 userId, 2:i32 friendId);

    /**
     * 查询我的好友列表
     * @param userId 用户ID
     * @return
     */
    string queryMyFriend(1:i32 userId);


    /**
     * 保存申请关系，申请成为好友调用
     * @param friendApply
     * @return
     */
    i32 saveFriendApply(1:string friendApply);

    /**
     * 查询状态为‘申请中’的好友申请
     * @param userId
     * @return
     */
    string queryFriendApply(1:i32 userId);

    /**
     * 同意申请，成为好友
     * @param applyId 申请ID
     * @param userId 用户ID
     * @param friendId 好友ID
     * @return
     */
    i32 agreeFriendApply(1:i32 applyId, 2:i32 userId, 3:i32 friendId);

    /**
     * 拒绝申请
     * @param applyId 申请ID
     * @param userId 用户ID
     * @param friendId 好友ID
     * @return
     */
    i32 refuseFriendApply(1:i32 applyId, 2:i32 userId, 3:i32 friendId);

    /**
     * 创建会话，首次发起聊天时创建
     * @param chatSession
     * @return
     */
    i32 saveChatSession(1:string chatSession);

    /**
     * 查询会话列表
     * @param userId 用户ID
     * @param position 起始位置
     * @param size 条数
     * @return
     */
    string queryChatSessionList(1:i32 userId, 2:i32 position, 3:i32 size);

    /**
     * 根据会话ID查询聊天记录
     * @param sessionId
     * @param position
     * @param size
     * @return
     */
    string queryChartRecordList(1:i32 sessionId, 2:i32 position, 3:i32 size);

    /**
     * 发送消息
     * @param userId
     * @param msgId 消息ID，重新发送时使用
     * @param msgContent 消息内容
     * @param type 消息内容类型
     * @return 返回消息ID
     */
    i32 sendMsg(1:i32 userId, 2:i32 toUid, 3:i32 msgId, 4:string msgContent, 5:i32 type);
}


service InfoThriftRpcService {
    i32 saveFragmentHome(1:string fragmentHome);

    i32 updateFragmentHome(2:string fragmentHome);

    i32 deleteFragmentHome(1:i32 id);

    string getFragmentHome(1:i32 id);

    string queryFragmentHomeByPage(1:map<string, string> paramMap, 2:i32 pageIndex, 3:i32 pageSize);



    i32 saveInfoCategory(1:string category);

    i32 updateInfoCategory(1:string category);

    /**
     * 删除资讯类别时，是否要删除该类别下子类别及资讯，谨慎！
     * @param id
     * @return
     */
    i32 deleteInfoCategory(1:i32 id);

    string getInfoCategory(1:i32 id);

    /**
     * 查询子类别
     * @param parentId
     * @return
     */
    string findInfoCategoryByParentId(1:i32 parentId);

    string queryInfoCategoryByPage(1:map<string, string> paramMap, 2:i32 pageIndex, 3:i32 pageSize);



    i32 saveInfoContent(1:string infoContent);

    i32 deleteInfoContent(1:i32 id);

    i32 updateInfoContent(1:string infoContent);

    string getInfoContent(1:i32 id);

    string queryInfoContentByPage(1:map<string, string> paramMap, 2:i32 pageIndex, 3:i32 pageSize);

    string queryInfoContentList(1:string title, 2:string des, 3:i32 id, 4:i32 limit);
}

/**
* 商品相关
**/
service ProductThriftRpcService {
    /** 查询全部的分类 **/
    string queryAllMallProductCategory();

    /** 查询分类的子节点 **/
    string findMallProductCategoryList(1:i32 parentId);

    /** 保存商品分类 **/
    i32 saveMallProductCategory(1:string mallProductCategory);

    /** 修改商品分类 **/
    i32 updateMallProductCategory(1:string mallProductCategory);

    /** 删除分类 **/
    i32 deleteMallProductCategory(1:i32 id);

    /** 获取商品分类 **/
    string getMallProductCategory(1:i32 id);

    /** 通过产品分类查询属性和属性值 **/
    string findProValueByClassId(1:i32 classId);

    /** 添加属性和属性值 **/
    i32 addProAndValues(1:i32 classId,2:string pro,3:string values);

    /** 通过分类查询属性列表 **/
    string findProList(1:i32 classId);

    /** 通过分类属性查询分类属性值 **/
    string findProValueList(1:i32 proId);

    /** 增加分类属性 **/
    i32 addPro(1:string pro);

    /** 批量增加分类属性 **/
    i32 addProValue(1:string values);

    /** 批量删除分类属性 **/
    string delPros(1:list<i32> proIds);

    /** 批量产出分类属性值 **/
    string delProValues(1:list<i32> proValueIds);

    /** 修改属性 **/
    i32 modifyPro(1:string pro);

    /** 修改属性值 **/
    i32 modifyProValue(1:string value);

    /** 货品查询 可通过多个参数查询 **/
    string findMallGoods(1:string value);

    /** 审核货品 **/
    i32 reviewMallGoods(1:i32 id, 2:bool status);

    /** 店铺查询 可通过多个参数查询 **/
    string findUserShop(1:string value);

    /** 审核店铺 **/
    i32 reviewUserShop(1:i32 id, 2:bool status);
    
    /** 添加首页碎片 **/
    i32 addMallIndex(1:string mallIndex 2:string mallindexContent);

    /** 修改首页碎片 **/
    i32 updateMallIndex(1:string mallIndex 2:string mallindexContent);



    /** 修改首页碎片状态 **/
    i32 updateStatus(1:i32 id, 2:bool status);

    /** 查询首页碎片 管理平台使用 **/
    string queryMallIndex(1:i32 status, 2:i32 pageIndex , 3:i32 pageSize);

    /** 查询首页碎片 前端使用 **/
    string queryUserMallIndex();

    /** 获取首页碎片明细 **/
    string getMallIndex(1:i32 id);

    /** 上架货品 **/
    i32 shelves(1:string mallGoods,2:string mallProductSets,3:string other);

    /** 更新单个商品 **/
    i32 goodAddProduct(1:i32 goodsId,2:string mallProductSets,3:string other);

    /** 根据货品id获取货品 **/
    string getMallGoodsSetByGood(1:i32 goods);

    /** 根据商品id获取货品 **/
    string getMallGoodsSetByProduct(1:i32 productId);

    /** 保存运费模板 **/
    i32 saveFareMould(1:string fareMould);

    /** 获取运费模板 **/
    string getFareMould(1:i32 id);

    /** 修改运费模板 **/
    i32 updateFareMould(1:string fareMould);

    /** 删除运费模板 **/
    i32 delFareMould(1:i32 id);

    /** 获取商铺下的运费模板 **/
    string findFareMoulds(1:i32 shopId);

    /**
     * 添加库存为止
     * @param storeLocation
     * @return
     */
    i32 saveStoreLocation(1:string storeLocation);

    /**
     * 获取库存位置
     * @param id
     * @return
     */
    string getStoreLocation(1:i32 id);

    /**
     * 删除库存位置
     * @param id
     * @return
     */
    i32 delStoreLocation(1:i32 id);

    /**
     * 修改库存位置
     * @param storeLocation
     * @return
     */
    i32 updateStoreLocation(1:string storeLocation);

    /**
     * 查询商铺的所有库存位置
     * @param shopId
     * @return
     */
    string findStoreLocations(1:i32 shopId);

    /** 评论货品 **/
    i32 commentGoods(1:string comment);

    /** 查询货品评论 **/
    string findProductEvaluateList(1:i32 goodIds,2:i32 seq,3:i32 num);

    /**
     * 店铺设置用户
     * @param shopUser
     * @return
     */
    i32 addShopUser(1:string shopUser);

    /**
     * 获取用户的店铺id
     * @param uid
     * @return
     */
    string getShopIdFromUid(1:i32 uid);

    /**
     * 获取店铺的创建者
     * @param shopId
     * @return
     */
    string getCreateShopUid(1:i32 shopId);

    /**
     * 获取店铺的所有员工
     * @param shopId
     * @return
     */
    string findShopUids(1:i32 shopId);

}

/**
* 广告service
**/
service AdThriftRpcService {
    i32 saveAd(1:string ad);

    i32 updateAd(1:string ad);

    i32 deleteAd(1:i32 id);

    string getAd(1:i32 id);

    string queryAdByPage(1:i32 adType, 2:i32 used, 3:i32 pageIndex, 4:i32 pageSize);

    i32 saveAdCategory(1:string category);

    i32 updateAdCategory(1:string category);

    i32 deleteAdCategory(1:i32 id);

    string getAdCategory(1:i32 id);

    string queryAdCategoryByPage(1:string name, 2:i32 pageIndex, 3:i32 pageSize);
}

/**
* 用户Service
**/
service UserThriftRpcService {
    i32 saveUser(1:string user);

    string getUser(1:i32 userId);

    /**
     * 用户ID，用户名不能更改
     * @param user
     * @return
     */
    i32 updateUser(1:string user);

    string getUserList(1:list<i32> userIdList);

    string getUserMap(1:list<i32> userIdList);

    string queryUserByPage(1:i32 userId, 2:string userName, 3:string nickName, 4:string phone, 5:i32 pageIndex, 6:i32 pageSize);

    /**
     * 用户注册接口
     * @param username 用户名，三方注册时此字段代表openid
     * @param password 密码，三方注册时此字段代表token令牌
     * @param type 三方类型 {@link com.yyt.print.user.pojo.User}
     * @param ip IP地址
     * @return
     */
    string login(1:string username, 2:string password, 3:i32 type, 4:string ip);

    /**
     * session验证接口
     * @param username 用户名，第三方登录时此字段代表openid
     * @param session 系统生成的会话ID
     * @param type 三方类型 {@link com.yyt.print.user.pojo.User}
     * @param token 第三方token
     * @return
     */
    string auth(1:string username, 2:string session, 3:string token, 4:i32 type);

    /**
     * 用户注册接口
     * @param username 用户名，三方注册时此字段代表openid
     * @param password 密码，三方注册时此字段代表token令牌
     * @param type 三方类型 {@link com.yyt.print.user.pojo.User}
     * @param nickname 昵称，三方注册时使用第三方的昵称
     * @param headImgUrl 头像地址
     * @param signature 签名
     * @param ip IP地址
     * @return
     */
    string regist(1:string username, 2:string password, 3:i32 type, 4:string nickname, 5:string headImgUrl, 6:string signature, 7:string ip);


    i32 saveUserBuyer(1:string userBuyer);

    string getUserBuyer(1:i32 userId);

    i32 updateUserBuyer(1:string userBuyer);

    string queryUserBuyerByPage(1:i32 userId, 2:string userName, 3:string nickName, 4:string phone, 5:string cardNumber, 6:string name, 7:i32 pageIndex, 8:i32 pageSize);

    i32 saveUserSeller(1:string userSeller);

    string getUserSeller(1:i32 userId);

    i32 updateUserSeller(1:string userSeller);

    string queryUserSellerByPage(1:i32 userId, 2:string userName, 3:string nickName, 4:string phone, 5:string cardNumber, 6:string name, 7:i32 pageIndex, 8:i32 pageSize);

    i32 saveUserThirdBind(1:string thirdBind);

    string getUserThirdBind(1:string thirdId, 2:i32 type);

    i32 saveUserErp(1:i32 erpUid, 2:string phone);

    string findUserErpByPhone(1:string phone);


}