
# Search Loyalty Rewards Request Loyalty Reward Query

The set of search requirements.

## Structure

`SearchLoyaltyRewardsRequestLoyaltyRewardQuery`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LoyaltyAccountId` | `String` | Required | The ID of the [loyalty account](../../doc/models/loyalty-account.md) to which the loyalty reward belongs. | String getLoyaltyAccountId() |
| `Status` | [`String`](../../doc/models/loyalty-reward-status.md) | Optional | The status of the loyalty reward. | String getStatus() |

## Example (as JSON)

```json
{
  "loyalty_account_id": "loyalty_account_id0",
  "status": "DELETED"
}
```

