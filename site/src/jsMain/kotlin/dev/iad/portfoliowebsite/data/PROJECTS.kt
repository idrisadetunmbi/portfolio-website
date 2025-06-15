package dev.iad.portfoliowebsite.data

import dev.iad.portfoliowebsite.models.Project

val PROJECTS = listOf(
    Project(
        image = "projects/trivago.png",
        link = "https://play.google.com/store/apps/details?id=com.trivago",
        type = Project.Type.MOBILE,
        headline = "trivago: Compare hotel prices",
        summary = "In addition to working on the core product features, I assumed responsibility of developing long-term, " +
                "member-retention features including the price drop notifications system (registration, notifications, " +
                "list management, and live prices) and the favorites lists feature increasing member acquisition and engagement.\n\n" +
                "On the tech-improvement side, I led and managed the introduction of the Jetpack Compose UI framework " +
                "to the trivago Android app, resulting in improved developer experience and faster development iterations.",
    ),
    Project(
        image = "projects/headspace-care.png",
        link = "https://play.google.com/store/apps/details?id=com.ginger",
        type = Project.Type.MOBILE,
        headline = "Headspace Care: Mental health support -- available through organizations + health plans",
        summary = "My experience working on the Headspace Care app included handling major projects, including porting the " +
                "Headspace Care Flutter Mobile app to a web app. This resulted in increased user base and retention " +
                "through providing an extra platform for product access. \n\n" +
                "I also worked in a three-person engineering sub-team to redevelop the content system, a large part of " +
                "the app, resulting in a more scalable, higher quality of the system and, in effect, a better user experience."
    ),
    Project(
        image = "projects/autochek.png",
        link = "https://play.google.com/store/apps/details?id=com.autochek.buysalefixcars",
        type = Project.Type.MOBILE,
        headline = "Autochek: Enjoy 360 degree solutions at your fingertips",
        summary = "I joined the Autochek startup team to develop the first release of the app handling major product features " +
                "including ad placements/uploads, financing application process, purchase payments, user authentication, etc. " +
                "The development featured using the Google-recommended MVVM architecture for developing Android apps, Kotlin, and " +
                "Kotlin Coroutines (for async operations).\n\n" +
                "It is one of the projects I adopted Jetpack Compose in at the early stages " +
                "of the framework based on my experience and understanding of declarative UI frameworks and the benefits they " +
                "bring to frontend engineering. " +
                "The release garnered up to 15,000 downloads with minimal impediments to user experience reported.",
    ),
    Project(
        image = "projects/aventine-alt.png",
        link = "https://aventine.org",
        type = Project.Type.WEB,
        headline = "Aventine: THE WORLD AS YOU'LL KNOW IT",
        summary = "I worked as a solo engineer with a product designer to develop this highly-custom blogging platform built " +
                "using Netlify CMS, ReactJS, and TailwindCSS (for a top research/journalism institute). The platform featured " +
                "heavy animations on the frontend using Framer Motion and some AST manipulations to develop a glossary " +
                "database feature unique to it.",
    ),
    Project(
        image = "projects/mtc.png",
        link = "https://www.intentionalfutures.com/posts/mastery-transcript",
        type = Project.Type.WEB,
        headline = "Mastery Transcript",
        summary = "Built with Firebase Cloud storage and ReactJS, the project started as a prototype (through rapid iterations) " +
                "and developed till the first major version of a modern transcript system for a network of high schools in the US. It also " +
                "included highly technical, custom SVG drawings to provide an immediate visualization summary of a " +
                "student's credit distribution.",
    ),
)
