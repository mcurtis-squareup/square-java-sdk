
# Search Orders Sort

Sorting criteria for a `SearchOrders` request. Results can only be sorted
by a timestamp field.

## Structure

`SearchOrdersSort`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `SortField` | [`String`](../../doc/models/search-orders-sort-field.md) | Required | Specifies which timestamp to use to sort `SearchOrder` results. | String getSortField() |
| `SortOrder` | [`String`](../../doc/models/sort-order.md) | Optional | The order (e.g., chronological or alphabetical) in which results from a request are returned. | String getSortOrder() |

## Example (as JSON)

```json
{
  "sort_field": "CLOSED_AT",
  "sort_order": "DESC"
}
```

