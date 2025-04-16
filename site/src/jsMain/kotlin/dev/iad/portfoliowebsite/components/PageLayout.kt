package dev.iad.portfoliowebsite.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.silk.style.CssStyle
import kotlinx.browser.document
import org.jetbrains.compose.web.css.percent

@Composable
fun PageLayout(content: @Composable () -> Unit) {

    LaunchedEffect(Unit) {
        document.title = "Idris Adetunmbi - Software Engineer"
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .minHeight(size = 100.percent),
        contentAlignment = Alignment.Center,
    ) {
        content()
        Footer(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomCenter),
        )
    }
}

val PageContentStyle = CssStyle {
    base { Modifier.fillMaxSize() }
}
