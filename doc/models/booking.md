
# Booking

Represents a booking as a time-bound service contract for a seller's staff member to provide a specified service
at a given location to a requesting customer in one or more appointment segments.

## Structure

`Booking`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | A unique ID of this object representing a booking.<br>**Constraints**: *Maximum Length*: `36` | String getId() |
| `Version` | `Integer` | Optional | The revision number for the booking used for optimistic concurrency. | Integer getVersion() |
| `Status` | [`String`](../../doc/models/booking-status.md) | Optional | Supported booking statuses. | String getStatus() |
| `CreatedAt` | `String` | Optional | The RFC 3339 timestamp specifying the creation time of this booking. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The RFC 3339 timestamp specifying the most recent update time of this booking. | String getUpdatedAt() |
| `StartAt` | `String` | Optional | The RFC 3339 timestamp specifying the starting time of this booking. | String getStartAt() |
| `LocationId` | `String` | Optional | The ID of the [Location](../../doc/models/location.md) object representing the location where the booked service is provided. Once set when the booking is created, its value cannot be changed.<br>**Constraints**: *Maximum Length*: `32` | String getLocationId() |
| `CustomerId` | `String` | Optional | The ID of the [Customer](../../doc/models/customer.md) object representing the customer receiving the booked service.<br>**Constraints**: *Maximum Length*: `192` | String getCustomerId() |
| `CustomerNote` | `String` | Optional | The free-text field for the customer to supply notes about the booking. For example, the note can be preferences that cannot be expressed by supported attributes of a relevant [CatalogObject](../../doc/models/catalog-object.md) instance.<br>**Constraints**: *Maximum Length*: `4096` | String getCustomerNote() |
| `SellerNote` | `String` | Optional | The free-text field for the seller to supply notes about the booking. For example, the note can be preferences that cannot be expressed by supported attributes of a specific [CatalogObject](../../doc/models/catalog-object.md) instance.<br>This field should not be visible to customers.<br>**Constraints**: *Maximum Length*: `4096` | String getSellerNote() |
| `AppointmentSegments` | [`List<AppointmentSegment>`](../../doc/models/appointment-segment.md) | Optional | A list of appointment segments for this booking. | List<AppointmentSegment> getAppointmentSegments() |
| `TransitionTimeMinutes` | `Integer` | Optional | Additional time at the end of a booking.<br>Applications should not make this field visible to customers of a seller. | Integer getTransitionTimeMinutes() |
| `AllDay` | `Boolean` | Optional | Whether the booking is of a full business day. | Boolean getAllDay() |
| `LocationType` | [`String`](../../doc/models/business-appointment-settings-booking-location-type.md) | Optional | Supported types of location where service is provided. | String getLocationType() |
| `CreatorDetails` | [`BookingCreatorDetails`](../../doc/models/booking-creator-details.md) | Optional | Information about a booking creator. | BookingCreatorDetails getCreatorDetails() |
| `Source` | [`String`](../../doc/models/booking-booking-source.md) | Optional | Supported sources a booking was created from. | String getSource() |

## Example (as JSON)

```json
{
  "id": "id0",
  "version": 172,
  "status": "CANCELLED_BY_SELLER",
  "created_at": "created_at2",
  "updated_at": "updated_at4"
}
```

