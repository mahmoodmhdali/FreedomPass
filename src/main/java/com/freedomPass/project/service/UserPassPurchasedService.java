package com.freedomPass.project.service;

import com.freedomPass.project.helpermodel.ResponseBodyEntity;
import com.freedomPass.project.helpermodel.UserPassPurchasedPagination;
import com.freedomPass.project.model.UserPassPurchased;
import java.util.List;

public interface UserPassPurchasedService {

    List<UserPassPurchased> getUserPassPurchaseds();
    
    List<UserPassPurchased> getUserPassPurchasedsGifted(Long userID, boolean isGifted, Long headID);

    UserPassPurchased getUserPassPurchased(Long id);

    UserPassPurchasedPagination getUserPassPurchasedPagination(int pageNumber, int maxRes);

    ResponseBodyEntity addUserPassPurchased(UserPassPurchased userPassPurchased, Long packageId, boolean isGifted);

    ResponseBodyEntity editUserPassPurchased(UserPassPurchased userPassPurchased);

    ResponseBodyEntity transferUserPassPurchased(Long fromUser, Long toUser, Long packageID);

}
