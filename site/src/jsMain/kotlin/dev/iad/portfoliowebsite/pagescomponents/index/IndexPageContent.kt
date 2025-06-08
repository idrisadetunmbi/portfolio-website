package dev.iad.portfoliowebsite.pagescomponents.index

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import dev.iad.portfoliowebsite.components.PageLayout
import dev.iad.portfoliowebsite.pagescomponents.index.sections.AboutMeSection
import dev.iad.portfoliowebsite.pagescomponents.index.sections.ContactSection
import dev.iad.portfoliowebsite.pagescomponents.index.sections.ProjectsSection
import dev.iad.portfoliowebsite.pagescomponents.index.sections.ResumeSection
import dev.iad.portfoliowebsite.widgets.VerticalSpacer
import org.jetbrains.compose.web.css.cssRem

@Composable
fun IndexPageContent() {
    PageLayout {
        Column(modifier = Modifier.fillMaxWidth()) {
            VerticalSpacer(value = 12.cssRem)
            AboutMeSection()
            ResumeSection()
            ProjectsSection()
            ContactSection()
        }
    }
}
