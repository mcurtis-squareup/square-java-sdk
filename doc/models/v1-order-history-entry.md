
# V1 Order History Entry

V1OrderHistoryEntry

## Structure

`V1OrderHistoryEntry`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Action` | [`String`](../../doc/models/v1-order-history-entry-action.md) | Optional | - | String getAction() |
| `CreatedAt` | `String` | Optional | The time when the action was performed, in ISO 8601 format. | String getCreatedAt() |

## Example (as JSON)

```json
{
  "action": "ORDER_PLACED",
  "created_at": "created_at2"
}
```

