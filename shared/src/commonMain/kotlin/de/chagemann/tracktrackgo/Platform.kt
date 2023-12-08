package de.chagemann.tracktrackgo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform