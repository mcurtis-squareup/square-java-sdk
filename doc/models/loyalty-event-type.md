
# Loyalty Event Type

The type of the loyalty event.

## Enumeration

`LoyaltyEventType`

## Fields

| Name | Description |
|  --- | --- |
| `ACCUMULATE_POINTS` | Points are added to a loyalty account for a purchase. |
| `CREATE_REWARD` | A [loyalty reward](../../doc/models/loyalty-reward.md) is created. |
| `REDEEM_REWARD` | A loyalty reward is redeemed. |
| `DELETE_REWARD` | A loyalty reward is deleted. |
| `ADJUST_POINTS` | Loyalty points are manually adjusted. |
| `EXPIRE_POINTS` | Loyalty points are expired according to the<br>expiration policy of the loyalty program. |
| `OTHER` | Some other loyalty event occurred. |

