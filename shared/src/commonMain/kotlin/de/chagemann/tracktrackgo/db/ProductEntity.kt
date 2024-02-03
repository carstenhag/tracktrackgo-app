data class ProductEntity(
    val barcodeId: Int?, // defined if it's a "real" product, ie its barcode was scanned and/or is available from an API.
    val nutriments: NutrimentsEntity,
)
