
# Invoice Sort

Identifies the sort field and sort order.

## Structure

`InvoiceSort`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Field` | `String` | Required, Constant | The field to use for sorting.<br>**Default**: `"INVOICE_SORT_DATE"` | String getField() |
| `Order` | [`String`](../../doc/models/sort-order.md) | Optional | The order (e.g., chronological or alphabetical) in which results from a request are returned. | String getOrder() |

## Example (as JSON)

```json
{
  "field": "INVOICE_SORT_DATE",
  "order": null
}
```

