
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for RefundPaymentRequest type.
 */
public class RefundPaymentRequest {
    private final String idempotencyKey;
    private final Money amountMoney;
    private final Money appFeeMoney;
    private final String paymentId;
    private final String reason;
    private final String paymentVersionToken;
    private final String teamMemberId;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  amountMoney  Money value for amountMoney.
     * @param  appFeeMoney  Money value for appFeeMoney.
     * @param  paymentId  String value for paymentId.
     * @param  reason  String value for reason.
     * @param  paymentVersionToken  String value for paymentVersionToken.
     * @param  teamMemberId  String value for teamMemberId.
     */
    @JsonCreator
    public RefundPaymentRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("app_fee_money") Money appFeeMoney,
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("reason") String reason,
            @JsonProperty("payment_version_token") String paymentVersionToken,
            @JsonProperty("team_member_id") String teamMemberId) {
        this.idempotencyKey = idempotencyKey;
        this.amountMoney = amountMoney;
        this.appFeeMoney = appFeeMoney;
        this.paymentId = paymentId;
        this.reason = reason;
        this.paymentVersionToken = paymentVersionToken;
        this.teamMemberId = teamMemberId;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `RefundPayment` request. The key can be any valid string
     * but must be unique for every `RefundPayment` request. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
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
    public Money getAmountMoney() {
        return amountMoney;
    }

    /**
     * Getter for AppFeeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("app_fee_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getAppFeeMoney() {
        return appFeeMoney;
    }

    /**
     * Getter for PaymentId.
     * The unique ID of the payment being refunded. Must be provided and non-empty.
     * @return Returns the String
     */
    @JsonGetter("payment_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Getter for Reason.
     * A description of the reason for the refund.
     * @return Returns the String
     */
    @JsonGetter("reason")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReason() {
        return reason;
    }

    /**
     * Getter for PaymentVersionToken.
     * Used for optimistic concurrency. This opaque token identifies the current `Payment` version
     * that the caller expects. If the server has a different version of the Payment, the update
     * fails and a response with a VERSION_MISMATCH error is returned. If the versions match, or the
     * field is not provided, the refund proceeds as normal.
     * @return Returns the String
     */
    @JsonGetter("payment_version_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPaymentVersionToken() {
        return paymentVersionToken;
    }

    /**
     * Getter for TeamMemberId.
     * An optional [TeamMember]($m/TeamMember) ID to associate with this refund.
     * @return Returns the String
     */
    @JsonGetter("team_member_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTeamMemberId() {
        return teamMemberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, amountMoney, appFeeMoney, paymentId, reason,
                paymentVersionToken, teamMemberId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RefundPaymentRequest)) {
            return false;
        }
        RefundPaymentRequest other = (RefundPaymentRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(appFeeMoney, other.appFeeMoney)
            && Objects.equals(paymentId, other.paymentId)
            && Objects.equals(reason, other.reason)
            && Objects.equals(paymentVersionToken, other.paymentVersionToken)
            && Objects.equals(teamMemberId, other.teamMemberId);
    }

    /**
     * Converts this RefundPaymentRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RefundPaymentRequest [" + "idempotencyKey=" + idempotencyKey + ", amountMoney="
                + amountMoney + ", appFeeMoney=" + appFeeMoney + ", paymentId=" + paymentId
                + ", reason=" + reason + ", paymentVersionToken=" + paymentVersionToken
                + ", teamMemberId=" + teamMemberId + "]";
    }

    /**
     * Builds a new {@link RefundPaymentRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RefundPaymentRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey, amountMoney)
                .appFeeMoney(getAppFeeMoney())
                .paymentId(getPaymentId())
                .reason(getReason())
                .paymentVersionToken(getPaymentVersionToken())
                .teamMemberId(getTeamMemberId());
        return builder;
    }

    /**
     * Class to build instances of {@link RefundPaymentRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private Money amountMoney;
        private Money appFeeMoney;
        private String paymentId;
        private String reason;
        private String paymentVersionToken;
        private String teamMemberId;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @param  amountMoney  Money value for amountMoney.
         */
        public Builder(String idempotencyKey, Money amountMoney) {
            this.idempotencyKey = idempotencyKey;
            this.amountMoney = amountMoney;
        }

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

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
         * Setter for appFeeMoney.
         * @param  appFeeMoney  Money value for appFeeMoney.
         * @return Builder
         */
        public Builder appFeeMoney(Money appFeeMoney) {
            this.appFeeMoney = appFeeMoney;
            return this;
        }

        /**
         * Setter for paymentId.
         * @param  paymentId  String value for paymentId.
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        /**
         * Setter for reason.
         * @param  reason  String value for reason.
         * @return Builder
         */
        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        /**
         * Setter for paymentVersionToken.
         * @param  paymentVersionToken  String value for paymentVersionToken.
         * @return Builder
         */
        public Builder paymentVersionToken(String paymentVersionToken) {
            this.paymentVersionToken = paymentVersionToken;
            return this;
        }

        /**
         * Setter for teamMemberId.
         * @param  teamMemberId  String value for teamMemberId.
         * @return Builder
         */
        public Builder teamMemberId(String teamMemberId) {
            this.teamMemberId = teamMemberId;
            return this;
        }

        /**
         * Builds a new {@link RefundPaymentRequest} object using the set fields.
         * @return {@link RefundPaymentRequest}
         */
        public RefundPaymentRequest build() {
            return new RefundPaymentRequest(idempotencyKey, amountMoney, appFeeMoney, paymentId,
                    reason, paymentVersionToken, teamMemberId);
        }
    }
}
