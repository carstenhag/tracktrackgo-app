package de.chagemann.tracktrackgo

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString

@Serializable
data class Project(val name: String, val language: String)

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        val json = getJson()
        val data = Project("kotlinx.serialization", "Kotlin")
        val string = json.encodeToString(data)
        println(string) // {"name":"kotlinx.serialization","language":"Kotlin"}
        // Deserializing back into objects
        val obj = json.decodeFromString<Project>(string)
        println(obj) // Project(name=kotlinx.serialization, language=Kotlin)

        return "Hello, ${obj.name} ${obj.language}!"
    }
}
