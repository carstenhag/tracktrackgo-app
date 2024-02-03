import kotlinx.serialization.SerialName

data class NutrimentsEntity(
    @SerialName("energy-kcal_100g")
    val energyKcal100g: Double,

    @SerialName("fat_100g")
    val fat100g: Double,

    @SerialName("proteins_100g")
    val proteins100g: Double,

    @SerialName("carbohydrates_100g")
    val carbohydrates100g: Double,
)
