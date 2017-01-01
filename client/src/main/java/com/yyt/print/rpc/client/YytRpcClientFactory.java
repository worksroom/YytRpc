package com.yyt.print.rpc.client;

import com.yyt.print.rpc.client.ad.AdRpcServiceImpl;
import com.yyt.print.rpc.client.ad.IAdRpcService;
import com.yyt.print.rpc.client.friend.FriendChatRpcServiceImpl;
import com.yyt.print.rpc.client.friend.IFriendChatRpcService;
import com.yyt.print.rpc.client.info.IInfoRpcService;
import com.yyt.print.rpc.client.info.InfoRpcServiceImpl;
import com.yyt.print.rpc.client.product.IProductRpcService;
import com.yyt.print.rpc.client.product.ProductRpcServiceImpl;
import com.yyt.print.rpc.client.user.IUserRpcService;
import com.yyt.print.rpc.client.user.UserRpcServiceImpl;


public class YytRpcClientFactory {
    private static IFriendChatRpcService friendChatRpcService = null;
    private static IAdRpcService adRpcService = null;
    private static IInfoRpcService infoRpcService = null;
    private static IUserRpcService userRpcService = null;
    private static IProductRpcService productRpcService = null;


    public static IFriendChatRpcService getFriendChatRpcService() {
        if (friendChatRpcService != null) {
            return friendChatRpcService;
        } else {
            synchronized (YytRpcClientFactory.class) {
                if (friendChatRpcService != null) {
                    return friendChatRpcService;
                } else {
                    friendChatRpcService = new FriendChatRpcServiceImpl();
                }
            }
        }
        return friendChatRpcService;
    }


    public static IAdRpcService getAdRpcService() {
        if (adRpcService != null) {
            return adRpcService;
        } else {
            synchronized (YytRpcClientFactory.class) {
                if (adRpcService != null) {
                    return adRpcService;
                } else {
                    adRpcService = new AdRpcServiceImpl();
                }
            }
        }
        return adRpcService;
    }


    public static IInfoRpcService getInfoRpcService() {
        if (infoRpcService != null) {
            return infoRpcService;
        } else {
            synchronized (YytRpcClientFactory.class) {
                if (infoRpcService != null) {
                    return infoRpcService;
                } else {
                    infoRpcService = new InfoRpcServiceImpl();
                }
            }
        }
        return infoRpcService;
    }


    public static IUserRpcService getUserRpcService() {
        if (userRpcService != null) {
            return userRpcService;
        } else {
            synchronized (YytRpcClientFactory.class) {
                if (userRpcService != null) {
                    return userRpcService;
                } else {
                    userRpcService = new UserRpcServiceImpl();
                }
            }
        }
        return userRpcService;
    }

    public static IProductRpcService getProductRpcService() {
        if (productRpcService != null) {
            return productRpcService;
        } else {
            synchronized (YytRpcClientFactory.class) {
                if (productRpcService != null) {
                    return productRpcService;
                } else {
                    productRpcService = new ProductRpcServiceImpl();
                }
            }
        }
        return productRpcService;
    }
}
