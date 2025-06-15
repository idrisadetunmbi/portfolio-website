package dev.iad.portfoliowebsite.models

data class Project(
    val image: String,
    val link: String,
    val type: Type,
    val headline: String,
    val summary: String,
) {
    enum class Type {
        ALL, MOBILE, WEB
    }
}
