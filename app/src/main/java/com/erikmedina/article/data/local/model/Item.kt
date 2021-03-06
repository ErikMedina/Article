package com.erikmedina.article.data.local.model

import java.io.Serializable

/**
 * This class contains the main item used in the application. Depending on the data that we have to
 * manage, we can have different item's models (view, domain, service, etc.) but, for simplicity,
 * we only declare this model.
 * We are going to use Kotlin's Data Classes (https://kotlinlang.org/docs/reference/data-classes.html)
 * because they are useful for holding data.
 */
data class Item(
        val id: Int,
        val title: String,
        val subtitle: String,
        val body: String,
        val date: String
) : Serializable
