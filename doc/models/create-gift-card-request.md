
# Create Gift Card Request

A request to create a gift card.

## Structure

`CreateGiftCardRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `IdempotencyKey` | `String` | Required | A unique string that identifies the `CreateGiftCard` request.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `128` | String getIdempotencyKey() |
| `LocationId` | `String` | Required | The location ID where the gift card that will be created should be registered.<br>**Constraints**: *Minimum Length*: `1` | String getLocationId() |
| `GiftCard` | [`GiftCard`](../../doc/models/gift-card.md) | Required | Represents a Square gift card. | GiftCard getGiftCard() |

## Example (as JSON)

```json
{
  "gift_card": {
    "type": "DIGITAL"
  },
  "idempotency_key": "NC9Tm69EjbjtConu",
  "location_id": "81FN9BNFZTKS4"
}
```

