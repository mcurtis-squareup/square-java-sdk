
# Search Shifts Request

A request for a filtered and sorted set of `Shift` objects.

## Structure

`SearchShiftsRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Query` | [`ShiftQuery`](../../doc/models/shift-query.md) | Optional | The parameters of a `Shift` search query, which includes filter and sort options. | ShiftQuery getQuery() |
| `Limit` | `Integer` | Optional | The number of resources in a page (200 by default).<br>**Constraints**: `>= 1`, `<= 200` | Integer getLimit() |
| `Cursor` | `String` | Optional | An opaque cursor for fetching the next page. | String getCursor() |

## Example (as JSON)

```json
{
  "query": {
    "filter": {
      "location_ids": [
        "location_ids4",
        "location_ids5"
      ],
      "employee_ids": [
        "employee_ids9",
        "employee_ids0"
      ],
      "status": "OPEN",
      "start": {
        "start_at": "start_at0",
        "end_at": "end_at2"
      },
      "end": {
        "start_at": "start_at4",
        "end_at": "end_at8"
      },
      "workday": {
        "date_range": {
          "start_date": "start_date6",
          "end_date": "end_date2"
        },
        "match_shifts_by": "INTERSECTION",
        "default_timezone": "default_timezone4"
      },
      "team_member_ids": [
        "team_member_ids1",
        "team_member_ids2",
        "team_member_ids3"
      ]
    },
    "sort": {
      "field": "CREATED_AT",
      "order": "DESC"
    }
  },
  "limit": 172,
  "cursor": "cursor6"
}
```

