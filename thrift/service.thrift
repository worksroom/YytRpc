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


service ProductThriftRpcService {

}

/**
* 广告service
**/
service AdThriftRpcService {
    i32 saveAd(1:string ad);

    i32 updateAd(1:string ad);

    i32 deleteAd(1:i32 id);

    string getAd(1:i32 id);

    string queryAdByPage(1:map<string, string> paramMap, 2:i32 pageIndex, 3:i32 pageSize);

    i32 saveAdCategory(1:string category);

    i32 updateAdCategory(2:string category);

    i32 deleteAdCategory(1:string id);

    string getAdCategory(2:string id);

    string queryAdCategoryByPage(1:map<string, string> paramMap, 2:i32 pageIndex, 3:i32 pageSize);
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
}