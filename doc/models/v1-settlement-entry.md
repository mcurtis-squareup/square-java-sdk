
# V1 Settlement Entry

V1SettlementEntry

## Structure

`V1SettlementEntry`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `PaymentId` | `String` | Optional | The settlement's unique identifier. | String getPaymentId() |
| `Type` | [`String`](../../doc/models/v1-settlement-entry-type.md) | Optional | - | String getType() |
| `AmountMoney` | [`V1Money`](../../doc/models/v1-money.md) | Optional | - | V1Money getAmountMoney() |
| `FeeMoney` | [`V1Money`](../../doc/models/v1-money.md) | Optional | - | V1Money getFeeMoney() |

## Example (as JSON)

```json
{
  "payment_id": "payment_id0",
  "type": "PAID_SERVICE_FEE",
  "amount_money": {
    "amount": 186,
    "currency_code": "KRW"
  },
  "fee_money": {
    "amount": 108,
    "currency_code": "UZS"
  }
}
```

