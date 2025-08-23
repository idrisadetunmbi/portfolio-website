package dev.iad.portfoliowebsite.pagescomponents.index.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.web.events.SyntheticMouseEvent
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.dom.ref
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonSize
import com.varabyte.kobweb.silk.components.forms.InputGroup
import com.varabyte.kobweb.silk.components.forms.InputSize
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.iad.portfoliowebsite.pagescomponents.index.components.SectionScaffold
import dev.iad.portfoliowebsite.toSitePalette
import dev.iad.portfoliowebsite.widgets.VerticalSpacer
import kotlinx.browser.document
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLElement

@Composable
internal fun ContactSection() {
    var nameFieldValue by remember { mutableStateOf(value = "") }
    var subjectFieldValue by remember { mutableStateOf(value = "") }
    var messageFieldValue by remember { mutableStateOf(value = "") }

    var rootElementRef by remember { mutableStateOf<HTMLElement?>(value = null) }

    val handleSubmitClick: (SyntheticMouseEvent) -> Unit = {
        val element = document.createElement(localName = "a")
        val anchorElement = (element as HTMLAnchorElement)
        anchorElement.href = createMailToLink(
            name = nameFieldValue,
            subject = subjectFieldValue,
            message = messageFieldValue,
        )
        rootElementRef?.appendChild(node = anchorElement)
        anchorElement.click()
        rootElementRef?.removeChild(child = anchorElement)
    }

    SectionScaffold(
        title = "contact",
        backgroundColor = ColorMode.current.toSitePalette().backgroundAlt,
    ) {
        Column(
            modifier = ContainerStyle.toModifier(),
            ref = ref { rootElementRef = it },
        ) {
            VerticalSpacer(value = 1.cssRem)
            ContactFormInputField(
                type = InputType.Text,
                placeholder = "name",
                value = nameFieldValue,
                onValueChange = {
                    nameFieldValue = it
                },
            )
            VerticalSpacer(value = 3.5.cssRem)
            ContactFormInputField(
                type = InputType.Text,
                placeholder = "subject",
                value = subjectFieldValue,
                onValueChange = {
                    subjectFieldValue = it
                },
            )
            VerticalSpacer(value = 3.5.cssRem)
            ContactFormInputField(
                type = InputType.Text,
                placeholder = "message",
                value = messageFieldValue,
                onValueChange = {
                    messageFieldValue = it
                },
            )
            VerticalSpacer(value = 3.5.cssRem)
            Button(
                size = ButtonSize.LG,
                modifier = SubmitButtonStyle.toModifier(),
                onClick = handleSubmitClick,
            ) {
                SpanText(text = "start the conversation")
            }
        }
        VerticalSpacer(value = 10.cssRem)
    }
}

private fun createMailToLink(
    name: String,
    subject: String,
    message: String,
): String = buildString {
    append("mailto:contact@idrisadetunmbi.dev?")
    append("subject=$subject&")
    append("body=$message")
    appendLine()
    appendLine()
    append(name)
}

@Composable
private fun ContactFormInputField(
    type: InputType<String>,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    val modifier = InputFieldStyle.toModifier()
    InputGroup(
        modifier = Modifier.fillMaxWidth(),
        size = if (value.isEmpty()) InputSize.XS else InputSize.SM,
    ) {
        LeftInset(width = 2.cssRem) {
            Box()
        }
        Input(
            type = type,
            value = value,
            placeholder = placeholder,
            onValueChange = onValueChange,
            modifier = modifier.then(
                other = if (value.isEmpty()) Modifier
                    .letterSpacing(value = .25.cssRem)
                    .textTransform(textTransform = TextTransform.Uppercase)
                else Modifier,
            ),
        )
    }
}

val ContainerStyle = CssStyle {
    base {
        Modifier
            .width(size = 100.percent)
            .padding(leftRight = 2.cssRem)
    }

    Breakpoint.MD {
        Modifier.width(size = 50.percent)
    }
}

val SubmitButtonStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .backgroundColor(color = colorMode.toSitePalette().content)
            .color(color = colorMode.toSitePalette().backgroundAlt)
            .textTransform(textTransform = TextTransform.Uppercase)
            .letterSpacing(value = .1.cssRem)
            .fontSize(value = .875.cssRem)
            .borderRadius {
                topLeft(r = 0.cssRem)
                topRight(r = 0.cssRem)
                bottomLeft(r = 0.cssRem)
                bottomRight(r = 0.cssRem)
            }
    }
}

val InputFieldStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .borderRadius {
                bottomLeft(r = 0.cssRem)
                bottomRight(r = 0.cssRem)
                topLeft(r = 0.cssRem)
                topRight(r = 0.cssRem)
            }
            .border {
                width(width = .1.cssRem)
                color(color = colorMode.toSitePalette().content)
                style(bottom = LineStyle.Solid)
            }
            .padding {
                bottom(value = 1.5.cssRem)
                top(value = 1.5.cssRem)
            }
    }
}
