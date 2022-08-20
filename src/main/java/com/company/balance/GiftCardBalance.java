package com.company.balance;

import java.util.UUID;

import static com.company.StaticConstants.GIFT_CARD_BALANCE_LIST;

public class GiftCardBalance extends Balance{


    public GiftCardBalance(UUID customerId, Double balance) {
        super(customerId, balance);
    }

    @Override
    public Double addBalance(Double additionalBalance) {
        double promotionAmount = additionalBalance * 10 / 100;
        setBalance(getBalance() + additionalBalance + promotionAmount);
        return getBalance();
    }

    public static GiftCardBalance findGiftCardBalance(UUID customerId) {
        for (Balance giftCarBalance : GIFT_CARD_BALANCE_LIST) {
            if (giftCarBalance.getCustomerId().equals(customerId)) {
                return (GiftCardBalance) giftCarBalance;
            }
        }

        GiftCardBalance giftCarBalance = new GiftCardBalance(customerId, 0d);
        GIFT_CARD_BALANCE_LIST.add(giftCarBalance);

        return giftCarBalance;
    }
}
