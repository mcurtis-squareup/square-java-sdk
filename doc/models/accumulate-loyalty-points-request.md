
# Accumulate Loyalty Points Request

A request to accumulate points for a purchase.

## Structure

`AccumulateLoyaltyPointsRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `AccumulatePoints` | [`LoyaltyEventAccumulatePoints`](../../doc/models/loyalty-event-accumulate-points.md) | Required | Provides metadata when the event `type` is `ACCUMULATE_POINTS`. | LoyaltyEventAccumulatePoints getAccumulatePoints() |
| `IdempotencyKey` | `String` | Required | A unique string that identifies the `AccumulateLoyaltyPoints` request.<br>Keys can be any valid string but must be unique for every request.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `128` | String getIdempotencyKey() |
| `LocationId` | `String` | Required | The [location](../../doc/models/location.md) where the purchase was made. | String getLocationId() |

## Example (as JSON)

```json
{
  "accumulate_points": {
    "order_id": "RFZfrdtm3mhO1oGzf5Cx7fEMsmGZY"
  },
  "idempotency_key": "58b90739-c3e8-4b11-85f7-e636d48d72cb",
  "location_id": "P034NEENMD09F"
}
```

