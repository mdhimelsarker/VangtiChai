# CSE 489 Assignment 1 — VangtiChai Project Report & AI Usage Declaration

**Course:** CSE 489: Mobile Application Development  
**Assignment:** Assignment 1 — VangtiChai Android Application  
**Project Name:** VangtiChai  
**Package:** `com.cse489.vangtichai`  
**Submission Date:** October 17, 2026  

---

## 1. Project Overview & Technical Report

### App Purpose & Description
**VangtiChai** is a native Android application built in Kotlin that calculates the breakdown of Bangladeshi Taka (BDT) notes for any monetary amount entered via a custom numeric keypad.

### Supported Denominations
The supported note denominations, in exact required order, are:  
`500, 100, 50, 20, 10, 5, 2, and 1 Taka`.

### Greedy Denomination Algorithm
Calculates the quotient and remainder for each note denomination sequentially:
$$\text{note\_count} = \frac{\text{remaining}}{\text{denomination}}$$
$$\text{remaining} = \text{remaining} \pmod{\text{denomination}}$$

Because $1 \text{ Taka}$ is included as the base unit, the sum of all calculated note counts always equals the entered amount ($\sum Count_i \times Denom_i = Amount$).

### User Interface Architecture
- **Portrait Layout (`res/layout/activity_main.xml`):** Top app header bar `VangtiChai`, centered amount display `Taka: 688`, left-side denomination list (`500: 0`, `100: 0`...), right-side 3-column numeric keypad (`1-9`, `0`, `CLEAR`).
- **Landscape Layout (`res/layout-land/activity_main.xml`):** Top app header bar, centered amount display `Taka: 6880`, left-side 2-column denomination table, right-side 4-column numeric keypad (`1-4`, `5-8`, `9 0 CLEAR`).
- **Dimension Resources:** Zero hardcoded layout sizes; all margins, paddings, text sizes, and heights are defined in `app/src/main/res/values/sizes.xml` (`@dimen/...`).
- **State Preservation:** Uses `onSaveInstanceState()` in `MainActivity.kt` to preserve entered input across screen rotations without resetting to zero.

---

## 2. AI Usage Declaration (Gemini Agent, ChatGPT & Claude AI)

I formally declare that Artificial Intelligence tools were utilized as learning companions, pair programming advisors, and technical assistants during the development of this project for **CSE 489 Assignment 1: VangtiChai**.

### Declared AI Assistant Tools:
1. **Gemini Agent (Android Studio AI IDE Assistant):**
   - Provided real-time pair-programming assistance directly within the Android Studio IDE.
   - Assisted in generating Kotlin code (`MainActivity.kt`, `DenominationCalculator.kt`), XML layouts, dimension resource structure, and automated unit tests.
   - Assisted in diagnosing build environment issues (Java JDK 25 JBR compatibility with AGP 9.4.1 and Gradle 9.6.0).

2. **ChatGPT (OpenAI):**
   - Utilized for conceptual brainstorming regarding modern Android UI/UX design patterns, `ConstraintLayout` guidelines, and ViewBinding best practices.
   - Assisted in reviewing mathematical proofs for the Greedy Denomination Algorithm.

3. **Claude AI (Anthropic):**
   - Utilized for code quality analysis, refactoring recommendations, and reviewing academic submission documentation structures.

### Integrity & Understanding Statement
All generated code, layout files, and build configurations were thoroughly examined, edited, tested, and validated by me. The core concepts, Android Activity lifecycles, and algorithmic logic are fully understood and can be explained in detail.

---

## 3. Prompt & Interaction Declaration

This section describes the sequence of requirements, prompts, troubleshooting steps, and design improvements involved in the development of the VangtiChai Android application. AI assistants were used as supporting tools to understand technical concepts, investigate development issues, and refine the implementation. The development process is organized into the following phases.

### Phase 1: Project Initialization & Algorithm Implementation

- **Requirement:** Develop a native Android application using Kotlin that calculates the breakdown of Bangladeshi Taka (BDT) notes for a user-entered amount. The application must include a custom numeric keypad, support both portrait and landscape orientations, preserve input during screen rotation, use dimension resources instead of hardcoded layout dimensions, and include unit tests.
- **Development Process:** Worked on the project configuration and the implementation of `DenominationCalculator.kt`, `MainActivity.kt`, portrait and landscape XML layouts, `sizes.xml`, and `DenominationCalculatorTest.kt`. AI assistance was used to clarify implementation requirements, review the denomination calculation logic, and address questions arising during development.

### Phase 2: Build & IDE Environment Troubleshooting

- **Problem:** Encountered difficulties running the application and synchronizing the Gradle project, including issues expressed through prompts such as "Run hocce na kno?" and "sync korte parci na".
- **Troubleshooting Process:** Investigated the IDE and build configuration issues with AI assistance. The troubleshooting process included creating the missing `gradle-wrapper.jar`, configuring Android Gradle Plugin (AGP) version `9.4.1` and Gradle version `9.6.0` for the Java 25 JBR environment, updating `.idea/modules.xml`, and resolving environment variable conflicts.
- **Verification:** The development log recorded a successful build (`BUILD SUCCESSFUL in 8s`) after the configuration changes.

### Phase 3: Alignment with the Instructor's Official Reference Screenshots

- **Requirement:** Refine the user interface to match the instructor's official reference screenshots for both portrait and landscape orientations.
- **Portrait Layout:** Updated `activity_main.xml` to include the `VangtiChai` header, a centered amount display (`Taka: 688`), a denomination list on the left (e.g., `500: 0`), and a three-column numeric keypad on the right containing digits `1–9`, `0`, and `CLEAR`.
- **Landscape Layout:** Updated `layout-land/activity_main.xml` to include the header, an amount display (`Taka: 6880`), a two-column denomination table on the left, and a four-column keypad arrangement on the right (`1–4`, `5–8`, and `9`, `0`, `CLEAR`).
- **Implementation Review:** Used AI assistance to review the layout structure, keypad arrangement, spacing, and overall presentation against the specified requirements. The development log recorded another successful build (`BUILD SUCCESSFUL in 9s`) and five passing tests after these changes.

### Phase 4: Consolidation of Submission Documentation

- **Requirement:** Prepare a single, organized Markdown document in the `/docs` directory containing the project report, AI usage declaration for Gemini Agent, ChatGPT, and Claude AI, and the prompt and interaction declaration.
- **Documentation Process:** Consolidated the project overview, technical implementation details, AI usage disclosures, and development history into `docs/documentation.md`. The purpose was to present the work in a clear, consistent, and well-structured format for academic submission.

### Reflection on AI-Assisted Development

AI assistants served as supplementary learning and development resources throughout the project. Their suggestions helped investigate configuration problems, review implementation decisions, refine the user interface, and organize the submission documentation. The development process also involved reviewing the proposed changes and checking the application through builds and unit tests.

I acknowledge the use of AI assistance in accordance with the declaration above. I am responsible for the submitted work and should be able to explain the application's functionality, the denomination calculation algorithm, the layout decisions, the configuration changes, and the testing process.
