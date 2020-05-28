package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.List;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.V1BankAccount;
import com.squareup.square.models.V1CreateRefundRequest;
import com.squareup.square.models.V1Order;
import com.squareup.square.models.V1Payment;
import com.squareup.square.models.V1Refund;
import com.squareup.square.models.V1Settlement;
import com.squareup.square.models.V1UpdateOrderRequest;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface V1TransactionsApi {
    /**
     * Provides non-confidential details for all of a location's associated bank accounts. This endpoint does not provide full bank account numbers, and there is no way to obtain a full bank account number with the Connect API.
     * ---
     * - __Deprecation date__: 2020-02-26
     * - [__Retirement date__](https://developer.squareup.com/docs/docs/build-basics/api-lifecycle#deprecated): 2021-02-26
     * - [Migration guide](https://developer.squareup.com/docs/docs/migrate-from-v1/guides/v1-bankaccounts)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list bank accounts for.
     * @return    Returns the List<V1BankAccount> response from the API call
     */
    @Deprecated    List<V1BankAccount> listBankAccounts(
            final String locationId) throws ApiException, IOException;

    /**
     * Provides non-confidential details for all of a location's associated bank accounts. This endpoint does not provide full bank account numbers, and there is no way to obtain a full bank account number with the Connect API.
     * ---
     * - __Deprecation date__: 2020-02-26
     * - [__Retirement date__](https://developer.squareup.com/docs/docs/build-basics/api-lifecycle#deprecated): 2021-02-26
     * - [Migration guide](https://developer.squareup.com/docs/docs/migrate-from-v1/guides/v1-bankaccounts)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list bank accounts for.
     * @return    Returns the List<V1BankAccount> response from the API call 
     */
    @Deprecated
    CompletableFuture<List<V1BankAccount>> listBankAccountsAsync(
            final String locationId);

    /**
     * Provides non-confidential details for a merchant's associated bank account. This endpoint does not provide full bank account numbers, and there is no way to obtain a full bank account number with the Connect API.
     * ---
     * - __Deprecation date__: 2020-02-26
     * - [__Retirement date__](https://developer.squareup.com/docs/docs/build-basics/api-lifecycle#deprecated): 2021-02-26
     * - [Migration guide](https://developer.squareup.com/docs/docs/migrate-from-v1/guides/v1-bankaccounts)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the bank account's associated location.
     * @param    bankAccountId    Required parameter: The bank account's Square-issued ID. You obtain this value from Settlement objects returned.
     * @return    Returns the V1BankAccount response from the API call
     */
    @Deprecated    V1BankAccount retrieveBankAccount(
            final String locationId,
            final String bankAccountId) throws ApiException, IOException;

    /**
     * Provides non-confidential details for a merchant's associated bank account. This endpoint does not provide full bank account numbers, and there is no way to obtain a full bank account number with the Connect API.
     * ---
     * - __Deprecation date__: 2020-02-26
     * - [__Retirement date__](https://developer.squareup.com/docs/docs/build-basics/api-lifecycle#deprecated): 2021-02-26
     * - [Migration guide](https://developer.squareup.com/docs/docs/migrate-from-v1/guides/v1-bankaccounts)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the bank account's associated location.
     * @param    bankAccountId    Required parameter: The bank account's Square-issued ID. You obtain this value from Settlement objects returned.
     * @return    Returns the V1BankAccount response from the API call 
     */
    @Deprecated
    CompletableFuture<V1BankAccount> retrieveBankAccountAsync(
            final String locationId,
            final String bankAccountId);

    /**
     * Provides summary information for a merchant's online store orders.
     * @param    locationId    Required parameter: The ID of the location to list online store orders for.
     * @param    order    Optional parameter: TThe order in which payments are listed in the response.
     * @param    limit    Optional parameter: The maximum number of payments to return in a single response. This value cannot exceed 200.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Order> response from the API call
     */
    List<V1Order> listOrders(
            final String locationId,
            final String order,
            final Integer limit,
            final String batchToken) throws ApiException, IOException;

    /**
     * Provides summary information for a merchant's online store orders.
     * @param    locationId    Required parameter: The ID of the location to list online store orders for.
     * @param    order    Optional parameter: TThe order in which payments are listed in the response.
     * @param    limit    Optional parameter: The maximum number of payments to return in a single response. This value cannot exceed 200.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Order> response from the API call 
     */
    CompletableFuture<List<V1Order>> listOrdersAsync(
            final String locationId,
            final String order,
            final Integer limit,
            final String batchToken);

    /**
     * Provides comprehensive information for a single online store order, including the order's history.
     * @param    locationId    Required parameter: The ID of the order's associated location.
     * @param    orderId    Required parameter: The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint
     * @return    Returns the V1Order response from the API call
     */
    V1Order retrieveOrder(
            final String locationId,
            final String orderId) throws ApiException, IOException;

    /**
     * Provides comprehensive information for a single online store order, including the order's history.
     * @param    locationId    Required parameter: The ID of the order's associated location.
     * @param    orderId    Required parameter: The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint
     * @return    Returns the V1Order response from the API call 
     */
    CompletableFuture<V1Order> retrieveOrderAsync(
            final String locationId,
            final String orderId);

    /**
     * Updates the details of an online store order. Every update you perform on an order corresponds to one of three actions:
     * @param    locationId    Required parameter: The ID of the order's associated location.
     * @param    orderId    Required parameter: The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Order response from the API call
     */
    V1Order updateOrder(
            final String locationId,
            final String orderId,
            final V1UpdateOrderRequest body) throws ApiException, IOException;

    /**
     * Updates the details of an online store order. Every update you perform on an order corresponds to one of three actions:
     * @param    locationId    Required parameter: The ID of the order's associated location.
     * @param    orderId    Required parameter: The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Order response from the API call 
     */
    CompletableFuture<V1Order> updateOrderAsync(
            final String locationId,
            final String orderId,
            final V1UpdateOrderRequest body);

    /**
     * Provides summary information for all payments taken for a given
     * Square account during a date range. Date ranges cannot exceed 1 year in
     * length. See Date ranges for details of inclusive and exclusive dates.
     * *Note**: Details for payments processed with Square Point of Sale while
     * in offline mode may not be transmitted to Square for up to 72 hours.
     * Offline payments have a `created_at` value that reflects the time the
     * payment was originally processed, not the time it was subsequently
     * transmitted to Square. Consequently, the ListPayments endpoint might
     * list an offline payment chronologically between online payments that
     * were seen in a previous request.
     * @param    locationId    Required parameter: The ID of the location to list payments for. If you specify me, this endpoint returns payments aggregated from all of the business's locations.
     * @param    order    Optional parameter: The order in which payments are listed in the response.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in ISO 8601 format. If this value is more than one year greater than begin_time, this endpoint returns an error. Default value: The current time.
     * @param    limit    Optional parameter: The maximum number of payments to return in a single response. This value cannot exceed 200.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @param    includePartial    Optional parameter: Indicates whether or not to include partial payments in the response. Partial payments will have the tenders collected so far, but the itemizations will be empty until the payment is completed.
     * @return    Returns the List<V1Payment> response from the API call
     */
    List<V1Payment> listPayments(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken,
            final Boolean includePartial) throws ApiException, IOException;

    /**
     * Provides summary information for all payments taken for a given
     * Square account during a date range. Date ranges cannot exceed 1 year in
     * length. See Date ranges for details of inclusive and exclusive dates.
     * *Note**: Details for payments processed with Square Point of Sale while
     * in offline mode may not be transmitted to Square for up to 72 hours.
     * Offline payments have a `created_at` value that reflects the time the
     * payment was originally processed, not the time it was subsequently
     * transmitted to Square. Consequently, the ListPayments endpoint might
     * list an offline payment chronologically between online payments that
     * were seen in a previous request.
     * @param    locationId    Required parameter: The ID of the location to list payments for. If you specify me, this endpoint returns payments aggregated from all of the business's locations.
     * @param    order    Optional parameter: The order in which payments are listed in the response.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in ISO 8601 format. If this value is more than one year greater than begin_time, this endpoint returns an error. Default value: The current time.
     * @param    limit    Optional parameter: The maximum number of payments to return in a single response. This value cannot exceed 200.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @param    includePartial    Optional parameter: Indicates whether or not to include partial payments in the response. Partial payments will have the tenders collected so far, but the itemizations will be empty until the payment is completed.
     * @return    Returns the List<V1Payment> response from the API call 
     */
    CompletableFuture<List<V1Payment>> listPaymentsAsync(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken,
            final Boolean includePartial);

    /**
     * Provides comprehensive information for a single payment.
     * @param    locationId    Required parameter: The ID of the payment's associated location.
     * @param    paymentId    Required parameter: The Square-issued payment ID. payment_id comes from Payment objects returned by the List Payments endpoint, Settlement objects returned by the List Settlements endpoint, or Refund objects returned by the List Refunds endpoint.
     * @return    Returns the V1Payment response from the API call
     */
    V1Payment retrievePayment(
            final String locationId,
            final String paymentId) throws ApiException, IOException;

    /**
     * Provides comprehensive information for a single payment.
     * @param    locationId    Required parameter: The ID of the payment's associated location.
     * @param    paymentId    Required parameter: The Square-issued payment ID. payment_id comes from Payment objects returned by the List Payments endpoint, Settlement objects returned by the List Settlements endpoint, or Refund objects returned by the List Refunds endpoint.
     * @return    Returns the V1Payment response from the API call 
     */
    CompletableFuture<V1Payment> retrievePaymentAsync(
            final String locationId,
            final String paymentId);

    /**
     * Provides the details for all refunds initiated by a merchant or any of the merchant's mobile staff during a date range. Date ranges cannot exceed one year in length.
     * @param    locationId    Required parameter: The ID of the location to list refunds for.
     * @param    order    Optional parameter: TThe order in which payments are listed in the response.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in ISO 8601 format. If this value is more than one year greater than begin_time, this endpoint returns an error. Default value: The current time.
     * @param    limit    Optional parameter: The approximate number of refunds to return in a single response. Default: 100. Max: 200. Response may contain more results than the prescribed limit when refunds are made simultaneously to multiple tenders in a payment or when refunds are generated in an exchange to account for the value of returned goods.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Refund> response from the API call
     */
    List<V1Refund> listRefunds(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken) throws ApiException, IOException;

    /**
     * Provides the details for all refunds initiated by a merchant or any of the merchant's mobile staff during a date range. Date ranges cannot exceed one year in length.
     * @param    locationId    Required parameter: The ID of the location to list refunds for.
     * @param    order    Optional parameter: TThe order in which payments are listed in the response.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in ISO 8601 format. If this value is more than one year greater than begin_time, this endpoint returns an error. Default value: The current time.
     * @param    limit    Optional parameter: The approximate number of refunds to return in a single response. Default: 100. Max: 200. Response may contain more results than the prescribed limit when refunds are made simultaneously to multiple tenders in a payment or when refunds are generated in an exchange to account for the value of returned goods.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Refund> response from the API call 
     */
    CompletableFuture<List<V1Refund>> listRefundsAsync(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken);

    /**
     * Issues a refund for a previously processed payment. You must issue
     * a refund within 60 days of the associated payment.
     * You cannot issue a partial refund for a split tender payment. You must
     * instead issue a full or partial refund for a particular tender, by
     * providing the applicable tender id to the V1CreateRefund endpoint.
     * Issuing a full refund for a split tender payment refunds all tenders
     * associated with the payment.
     * Issuing a refund for a card payment is not reversible. For development
     * purposes, you can create fake cash payments in Square Point of Sale and
     * refund them.
     * @param    locationId    Required parameter: The ID of the original payment's associated location.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Refund response from the API call
     */
    V1Refund createRefund(
            final String locationId,
            final V1CreateRefundRequest body) throws ApiException, IOException;

    /**
     * Issues a refund for a previously processed payment. You must issue
     * a refund within 60 days of the associated payment.
     * You cannot issue a partial refund for a split tender payment. You must
     * instead issue a full or partial refund for a particular tender, by
     * providing the applicable tender id to the V1CreateRefund endpoint.
     * Issuing a full refund for a split tender payment refunds all tenders
     * associated with the payment.
     * Issuing a refund for a card payment is not reversible. For development
     * purposes, you can create fake cash payments in Square Point of Sale and
     * refund them.
     * @param    locationId    Required parameter: The ID of the original payment's associated location.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Refund response from the API call 
     */
    CompletableFuture<V1Refund> createRefundAsync(
            final String locationId,
            final V1CreateRefundRequest body);

    /**
     * Provides summary information for all deposits and withdrawals
     * initiated by Square to a linked bank account during a date range. Date
     * ranges cannot exceed one year in length.
     * *Note**: the ListSettlements endpoint does not provide entry
     * information.
     * @param    locationId    Required parameter: The ID of the location to list settlements for. If you specify me, this endpoint returns settlements aggregated from all of the business's locations.
     * @param    order    Optional parameter: The order in which settlements are listed in the response.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in ISO 8601 format. If this value is more than one year greater than begin_time, this endpoint returns an error. Default value: The current time.
     * @param    limit    Optional parameter: The maximum number of settlements to return in a single response. This value cannot exceed 200.
     * @param    status    Optional parameter: Provide this parameter to retrieve only settlements with a particular status (SENT or FAILED).
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Settlement> response from the API call
     */
    List<V1Settlement> listSettlements(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String status,
            final String batchToken) throws ApiException, IOException;

    /**
     * Provides summary information for all deposits and withdrawals
     * initiated by Square to a linked bank account during a date range. Date
     * ranges cannot exceed one year in length.
     * *Note**: the ListSettlements endpoint does not provide entry
     * information.
     * @param    locationId    Required parameter: The ID of the location to list settlements for. If you specify me, this endpoint returns settlements aggregated from all of the business's locations.
     * @param    order    Optional parameter: The order in which settlements are listed in the response.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in ISO 8601 format. If this value is more than one year greater than begin_time, this endpoint returns an error. Default value: The current time.
     * @param    limit    Optional parameter: The maximum number of settlements to return in a single response. This value cannot exceed 200.
     * @param    status    Optional parameter: Provide this parameter to retrieve only settlements with a particular status (SENT or FAILED).
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Settlement> response from the API call 
     */
    CompletableFuture<List<V1Settlement>> listSettlementsAsync(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String status,
            final String batchToken);

    /**
     * Provides comprehensive information for a single settlement.
     * The returned `Settlement` objects include an `entries` field that lists
     * the transactions that contribute to the settlement total. Most
     * settlement entries correspond to a payment payout, but settlement
     * entries are also generated for less common events, like refunds, manual
     * adjustments, or chargeback holds.
     * Square initiates its regular deposits as indicated in the
     * [Deposit Options with Square](https://squareup.com/help/us/en/article/3807)
     * help article. Details for a regular deposit are usually not available
     * from Connect API endpoints before 10 p.m. PST the same day.
     * Square does not know when an initiated settlement **completes**, only
     * whether it has failed. A completed settlement is typically reflected in
     * a bank account within 3 business days, but in exceptional cases it may
     * take longer.
     * @param    locationId    Required parameter: The ID of the settlements's associated location.
     * @param    settlementId    Required parameter: The settlement's Square-issued ID. You obtain this value from Settlement objects returned by the List Settlements endpoint.
     * @return    Returns the V1Settlement response from the API call
     */
    V1Settlement retrieveSettlement(
            final String locationId,
            final String settlementId) throws ApiException, IOException;

    /**
     * Provides comprehensive information for a single settlement.
     * The returned `Settlement` objects include an `entries` field that lists
     * the transactions that contribute to the settlement total. Most
     * settlement entries correspond to a payment payout, but settlement
     * entries are also generated for less common events, like refunds, manual
     * adjustments, or chargeback holds.
     * Square initiates its regular deposits as indicated in the
     * [Deposit Options with Square](https://squareup.com/help/us/en/article/3807)
     * help article. Details for a regular deposit are usually not available
     * from Connect API endpoints before 10 p.m. PST the same day.
     * Square does not know when an initiated settlement **completes**, only
     * whether it has failed. A completed settlement is typically reflected in
     * a bank account within 3 business days, but in exceptional cases it may
     * take longer.
     * @param    locationId    Required parameter: The ID of the settlements's associated location.
     * @param    settlementId    Required parameter: The settlement's Square-issued ID. You obtain this value from Settlement objects returned by the List Settlements endpoint.
     * @return    Returns the V1Settlement response from the API call 
     */
    CompletableFuture<V1Settlement> retrieveSettlementAsync(
            final String locationId,
            final String settlementId);

}