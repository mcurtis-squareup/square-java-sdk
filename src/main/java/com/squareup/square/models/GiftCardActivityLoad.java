
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for GiftCardActivityLoad type.
 */
public class GiftCardActivityLoad {
    private final Money amountMoney;
    private final String orderId;
    private final String lineItemUid;
    private final String referenceId;
    private final List<String> buyerPaymentInstrumentIds;

    /**
     * Initialization constructor.
     * @param  amountMoney  Money value for amountMoney.
     * @param  orderId  String value for orderId.
     * @param  lineItemUid  String value for lineItemUid.
     * @param  referenceId  String value for referenceId.
     * @param  buyerPaymentInstrumentIds  List of String value for buyerPaymentInstrumentIds.
     */
    @JsonCreator
    public GiftCardActivityLoad(
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("order_id") String orderId,
            @JsonProperty("line_item_uid") String lineItemUid,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("buyer_payment_instrument_ids") List<String> buyerPaymentInstrumentIds) {
        this.amountMoney = amountMoney;
        this.orderId = orderId;
        this.lineItemUid = lineItemUid;
        this.referenceId = referenceId;
        this.buyerPaymentInstrumentIds = buyerPaymentInstrumentIds;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("amount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getAmountMoney() {
        return amountMoney;
    }

    /**
     * Getter for OrderId.
     * The `order_id` of the order associated with the activity. It is populated along with
     * `line_item_uid` and is required if using the Square Orders API.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getOrderId() {
        return orderId;
    }

    /**
     * Getter for LineItemUid.
     * The `line_item_uid` of the gift card’s line item in the order associated with the activity.
     * It is populated along with `order_id` and is required if using the Square Orders API.
     * @return Returns the String
     */
    @JsonGetter("line_item_uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLineItemUid() {
        return lineItemUid;
    }

    /**
     * Getter for ReferenceId.
     * A client-specified ID to associate an entity, in another system, with this gift card
     * activity. This can be used to track the order or payment related information when the Square
     * Orders API is not being used.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Getter for BuyerPaymentInstrumentIds.
     * If you are not using the Orders API, this field is required because it is used to identify a
     * buyer to perform compliance checks.
     * @return Returns the List of String
     */
    @JsonGetter("buyer_payment_instrument_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getBuyerPaymentInstrumentIds() {
        return buyerPaymentInstrumentIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountMoney, orderId, lineItemUid, referenceId,
                buyerPaymentInstrumentIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GiftCardActivityLoad)) {
            return false;
        }
        GiftCardActivityLoad other = (GiftCardActivityLoad) obj;
        return Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(orderId, other.orderId)
            && Objects.equals(lineItemUid, other.lineItemUid)
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(buyerPaymentInstrumentIds, other.buyerPaymentInstrumentIds);
    }

    /**
     * Converts this GiftCardActivityLoad into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GiftCardActivityLoad [" + "amountMoney=" + amountMoney + ", orderId=" + orderId
                + ", lineItemUid=" + lineItemUid + ", referenceId=" + referenceId
                + ", buyerPaymentInstrumentIds=" + buyerPaymentInstrumentIds + "]";
    }

    /**
     * Builds a new {@link GiftCardActivityLoad.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GiftCardActivityLoad.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .amountMoney(getAmountMoney())
                .orderId(getOrderId())
                .lineItemUid(getLineItemUid())
                .referenceId(getReferenceId())
                .buyerPaymentInstrumentIds(getBuyerPaymentInstrumentIds());
        return builder;
    }

    /**
     * Class to build instances of {@link GiftCardActivityLoad}.
     */
    public static class Builder {
        private Money amountMoney;
        private String orderId;
        private String lineItemUid;
        private String referenceId;
        private List<String> buyerPaymentInstrumentIds;



        /**
         * Setter for amountMoney.
         * @param  amountMoney  Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for orderId.
         * @param  orderId  String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Setter for lineItemUid.
         * @param  lineItemUid  String value for lineItemUid.
         * @return Builder
         */
        public Builder lineItemUid(String lineItemUid) {
            this.lineItemUid = lineItemUid;
            return this;
        }

        /**
         * Setter for referenceId.
         * @param  referenceId  String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = referenceId;
            return this;
        }

        /**
         * Setter for buyerPaymentInstrumentIds.
         * @param  buyerPaymentInstrumentIds  List of String value for buyerPaymentInstrumentIds.
         * @return Builder
         */
        public Builder buyerPaymentInstrumentIds(List<String> buyerPaymentInstrumentIds) {
            this.buyerPaymentInstrumentIds = buyerPaymentInstrumentIds;
            return this;
        }

        /**
         * Builds a new {@link GiftCardActivityLoad} object using the set fields.
         * @return {@link GiftCardActivityLoad}
         */
        public GiftCardActivityLoad build() {
            return new GiftCardActivityLoad(amountMoney, orderId, lineItemUid, referenceId,
                    buyerPaymentInstrumentIds);
        }
    }
}
