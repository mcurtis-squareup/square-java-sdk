
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Dispute type.
 */
public class Dispute {
    private final String disputeId;
    private final String id;
    private final Money amountMoney;
    private final String reason;
    private final String state;
    private final String dueAt;
    private final DisputedPayment disputedPayment;
    private final List<String> evidenceIds;
    private final String cardBrand;
    private final String createdAt;
    private final String updatedAt;
    private final String brandDisputeId;
    private final String reportedDate;
    private final String reportedAt;
    private final Integer version;
    private final String locationId;

    /**
     * Initialization constructor.
     * @param  disputeId  String value for disputeId.
     * @param  id  String value for id.
     * @param  amountMoney  Money value for amountMoney.
     * @param  reason  String value for reason.
     * @param  state  String value for state.
     * @param  dueAt  String value for dueAt.
     * @param  disputedPayment  DisputedPayment value for disputedPayment.
     * @param  evidenceIds  List of String value for evidenceIds.
     * @param  cardBrand  String value for cardBrand.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  brandDisputeId  String value for brandDisputeId.
     * @param  reportedDate  String value for reportedDate.
     * @param  reportedAt  String value for reportedAt.
     * @param  version  Integer value for version.
     * @param  locationId  String value for locationId.
     */
    @JsonCreator
    public Dispute(
            @JsonProperty("dispute_id") String disputeId,
            @JsonProperty("id") String id,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("reason") String reason,
            @JsonProperty("state") String state,
            @JsonProperty("due_at") String dueAt,
            @JsonProperty("disputed_payment") DisputedPayment disputedPayment,
            @JsonProperty("evidence_ids") List<String> evidenceIds,
            @JsonProperty("card_brand") String cardBrand,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("brand_dispute_id") String brandDisputeId,
            @JsonProperty("reported_date") String reportedDate,
            @JsonProperty("reported_at") String reportedAt,
            @JsonProperty("version") Integer version,
            @JsonProperty("location_id") String locationId) {
        this.disputeId = disputeId;
        this.id = id;
        this.amountMoney = amountMoney;
        this.reason = reason;
        this.state = state;
        this.dueAt = dueAt;
        this.disputedPayment = disputedPayment;
        this.evidenceIds = evidenceIds;
        this.cardBrand = cardBrand;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.brandDisputeId = brandDisputeId;
        this.reportedDate = reportedDate;
        this.reportedAt = reportedAt;
        this.version = version;
        this.locationId = locationId;
    }

    /**
     * Getter for DisputeId.
     * The unique ID for this `Dispute`, generated by Square.
     * @return Returns the String
     */
    @JsonGetter("dispute_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDisputeId() {
        return disputeId;
    }

    /**
     * Getter for Id.
     * The unique ID for this `Dispute`, generated by Square.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
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
     * Getter for Reason.
     * The list of possible reasons why a cardholder might initiate a dispute with their bank.
     * @return Returns the String
     */
    @JsonGetter("reason")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReason() {
        return reason;
    }

    /**
     * Getter for State.
     * The list of possible dispute states.
     * @return Returns the String
     */
    @JsonGetter("state")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getState() {
        return state;
    }

    /**
     * Getter for DueAt.
     * The time when the next action is due, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("due_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDueAt() {
        return dueAt;
    }

    /**
     * Getter for DisputedPayment.
     * The payment the cardholder disputed.
     * @return Returns the DisputedPayment
     */
    @JsonGetter("disputed_payment")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DisputedPayment getDisputedPayment() {
        return disputedPayment;
    }

    /**
     * Getter for EvidenceIds.
     * The IDs of the evidence associated with the dispute.
     * @return Returns the List of String
     */
    @JsonGetter("evidence_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getEvidenceIds() {
        return evidenceIds;
    }

    /**
     * Getter for CardBrand.
     * Indicates a card's brand, such as `VISA` or `MASTERCARD`.
     * @return Returns the String
     */
    @JsonGetter("card_brand")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCardBrand() {
        return cardBrand;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the dispute was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the dispute was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for BrandDisputeId.
     * The ID of the dispute in the card brand system, generated by the card brand.
     * @return Returns the String
     */
    @JsonGetter("brand_dispute_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBrandDisputeId() {
        return brandDisputeId;
    }

    /**
     * Getter for ReportedDate.
     * The timestamp when the dispute was reported, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("reported_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReportedDate() {
        return reportedDate;
    }

    /**
     * Getter for ReportedAt.
     * The timestamp when the dispute was reported, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("reported_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReportedAt() {
        return reportedAt;
    }

    /**
     * Getter for Version.
     * The current version of the `Dispute`.
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for LocationId.
     * The ID of the location where the dispute originated.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationId() {
        return locationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(disputeId, id, amountMoney, reason, state, dueAt, disputedPayment,
                evidenceIds, cardBrand, createdAt, updatedAt, brandDisputeId, reportedDate,
                reportedAt, version, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Dispute)) {
            return false;
        }
        Dispute other = (Dispute) obj;
        return Objects.equals(disputeId, other.disputeId)
            && Objects.equals(id, other.id)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(reason, other.reason)
            && Objects.equals(state, other.state)
            && Objects.equals(dueAt, other.dueAt)
            && Objects.equals(disputedPayment, other.disputedPayment)
            && Objects.equals(evidenceIds, other.evidenceIds)
            && Objects.equals(cardBrand, other.cardBrand)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(brandDisputeId, other.brandDisputeId)
            && Objects.equals(reportedDate, other.reportedDate)
            && Objects.equals(reportedAt, other.reportedAt)
            && Objects.equals(version, other.version)
            && Objects.equals(locationId, other.locationId);
    }

    /**
     * Converts this Dispute into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Dispute [" + "disputeId=" + disputeId + ", id=" + id + ", amountMoney="
                + amountMoney + ", reason=" + reason + ", state=" + state + ", dueAt=" + dueAt
                + ", disputedPayment=" + disputedPayment + ", evidenceIds=" + evidenceIds
                + ", cardBrand=" + cardBrand + ", createdAt=" + createdAt + ", updatedAt="
                + updatedAt + ", brandDisputeId=" + brandDisputeId + ", reportedDate="
                + reportedDate + ", reportedAt=" + reportedAt + ", version=" + version
                + ", locationId=" + locationId + "]";
    }

    /**
     * Builds a new {@link Dispute.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Dispute.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .disputeId(getDisputeId())
                .id(getId())
                .amountMoney(getAmountMoney())
                .reason(getReason())
                .state(getState())
                .dueAt(getDueAt())
                .disputedPayment(getDisputedPayment())
                .evidenceIds(getEvidenceIds())
                .cardBrand(getCardBrand())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .brandDisputeId(getBrandDisputeId())
                .reportedDate(getReportedDate())
                .reportedAt(getReportedAt())
                .version(getVersion())
                .locationId(getLocationId());
        return builder;
    }

    /**
     * Class to build instances of {@link Dispute}.
     */
    public static class Builder {
        private String disputeId;
        private String id;
        private Money amountMoney;
        private String reason;
        private String state;
        private String dueAt;
        private DisputedPayment disputedPayment;
        private List<String> evidenceIds;
        private String cardBrand;
        private String createdAt;
        private String updatedAt;
        private String brandDisputeId;
        private String reportedDate;
        private String reportedAt;
        private Integer version;
        private String locationId;



        /**
         * Setter for disputeId.
         * @param  disputeId  String value for disputeId.
         * @return Builder
         */
        public Builder disputeId(String disputeId) {
            this.disputeId = disputeId;
            return this;
        }

        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
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
         * Setter for reason.
         * @param  reason  String value for reason.
         * @return Builder
         */
        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        /**
         * Setter for state.
         * @param  state  String value for state.
         * @return Builder
         */
        public Builder state(String state) {
            this.state = state;
            return this;
        }

        /**
         * Setter for dueAt.
         * @param  dueAt  String value for dueAt.
         * @return Builder
         */
        public Builder dueAt(String dueAt) {
            this.dueAt = dueAt;
            return this;
        }

        /**
         * Setter for disputedPayment.
         * @param  disputedPayment  DisputedPayment value for disputedPayment.
         * @return Builder
         */
        public Builder disputedPayment(DisputedPayment disputedPayment) {
            this.disputedPayment = disputedPayment;
            return this;
        }

        /**
         * Setter for evidenceIds.
         * @param  evidenceIds  List of String value for evidenceIds.
         * @return Builder
         */
        public Builder evidenceIds(List<String> evidenceIds) {
            this.evidenceIds = evidenceIds;
            return this;
        }

        /**
         * Setter for cardBrand.
         * @param  cardBrand  String value for cardBrand.
         * @return Builder
         */
        public Builder cardBrand(String cardBrand) {
            this.cardBrand = cardBrand;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Setter for brandDisputeId.
         * @param  brandDisputeId  String value for brandDisputeId.
         * @return Builder
         */
        public Builder brandDisputeId(String brandDisputeId) {
            this.brandDisputeId = brandDisputeId;
            return this;
        }

        /**
         * Setter for reportedDate.
         * @param  reportedDate  String value for reportedDate.
         * @return Builder
         */
        public Builder reportedDate(String reportedDate) {
            this.reportedDate = reportedDate;
            return this;
        }

        /**
         * Setter for reportedAt.
         * @param  reportedAt  String value for reportedAt.
         * @return Builder
         */
        public Builder reportedAt(String reportedAt) {
            this.reportedAt = reportedAt;
            return this;
        }

        /**
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Builds a new {@link Dispute} object using the set fields.
         * @return {@link Dispute}
         */
        public Dispute build() {
            return new Dispute(disputeId, id, amountMoney, reason, state, dueAt, disputedPayment,
                    evidenceIds, cardBrand, createdAt, updatedAt, brandDisputeId, reportedDate,
                    reportedAt, version, locationId);
        }
    }
}
