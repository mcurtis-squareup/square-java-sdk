
# Catalog Image

An image file to use in Square catalogs. It can be associated with
`CatalogItem`, `CatalogItemVariation`, `CatalogCategory`, and `CatalogModifierList` objects.
Only the images on items and item variations are exposed in Dashboard.
Only the first image on an item is displayed in Square Point of Sale (SPOS).
Images on items and variations are displayed through Square Online Store.
Images on other object types are for use by 3rd party application developers.

## Structure

`CatalogImage`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Name` | `String` | Optional | The internal name to identify this image in calls to the Square API.<br>This is a searchable attribute for use in applicable query filters<br>using the [SearchCatalogObjects](../../doc/api/catalog.md#search-catalog-objects).<br>It is not unique and should not be shown in a buyer facing context. | String getName() |
| `Url` | `String` | Optional | The URL of this image, generated by Square after an image is uploaded<br>using the [CreateCatalogImage](../../doc/api/catalog.md#create-catalog-image) endpoint.<br>To modify the image, use the UpdateCatalogImage endpoint. Do not change the URL field. | String getUrl() |
| `Caption` | `String` | Optional | A caption that describes what is shown in the image. Displayed in the<br>Square Online Store. This is a searchable attribute for use in applicable query filters<br>using the [SearchCatalogObjects](../../doc/api/catalog.md#search-catalog-objects). | String getCaption() |
| `PhotoStudioOrderId` | `String` | Optional | The immutable order ID for this image object created by the Photo Studio service in Square Online Store. | String getPhotoStudioOrderId() |

## Example (as JSON)

```json
{
  "name": "name0",
  "url": "url4",
  "caption": "caption4",
  "photo_studio_order_id": "photo_studio_order_id2"
}
```

