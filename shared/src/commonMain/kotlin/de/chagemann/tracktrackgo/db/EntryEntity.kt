data class EntryEntity(
    val id: Int,
    val comment: String?,
    val product: ProductEntity?,
    val amount: Double?,
    val unit: MeasurementUnitEntity,
)

enum class MeasurementUnitEntity {
    GRAMS,
    MILILITER
}
