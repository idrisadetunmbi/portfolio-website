package dev.iad.portfoliowebsite.pagescomponents.index.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent

@Composable
internal fun SectionScaffold(
    title: String,
    backgroundColor: CSSColorValue = Color.transparent,
    content: @Composable ColumnScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .backgroundColor(color = backgroundColor),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .width(size = 100.percent)
                .maxWidth(size = 82.5.cssRem),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(modifier = Modifier.height(size = 6.5.cssRem))
            SpanText(
                text = title,
                modifier = Modifier
                    .textTransform(textTransform = TextTransform.Uppercase)
                    .fontSize(value = .75.cssRem)
                    .letterSpacing(value = .125.cssRem),
            )
            Box(modifier = Modifier.height(size = 2.cssRem))
            HorizontalDivider(modifier = Modifier.width(size = 1.5.cssRem))
            Box(modifier = Modifier.height(size = 3.cssRem))
            content()
            Box(modifier = Modifier.height(size = 6.5.cssRem))
        }
    }
}
