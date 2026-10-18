========================================================================
VANGTICHAI - BANGLADESHI TAKA DENOMINATION CALCULATOR
========================================================================
Course: CSE 489 - Mobile Application Development
Assignment: Assignment 1
Project Name: VangtiChai
Package Name: com.cse489.vangtichai

------------------------------------------------------------------------
1. APP PURPOSE AND FEATURES
------------------------------------------------------------------------
VangtiChai is a native Android application designed to calculate the breakdown
of Bangladeshi Taka (BDT) notes for any given monetary amount.

Features:
- Custom numeric keypad (digits 0-9 and a CLEAR button) implemented with actual
  Android views (no system keyboard or prebuilt calculator widgets).
- Real-time greedy denomination calculation across eight supported BDT note
  denominations in exact required order:
  500, 100, 50, 20, 10, 5, 2, and 1 Taka.
- Guaranteed sum accuracy: The sum of all calculated note denominations
  always equals the exact entered amount.
- Leading zero suppression and numeric safety (up to 9 digits / max 999,999,999 BDT)
  preventing integer overflow or application crashes.
- Responsive layout with denomination table placed to the LEFT of the keypad
  in portrait mode.
- Dedicated landscape layout (`res/layout-land/activity_main.xml`) optimizing
  screen real estate for landscape orientation.
- Full state preservation: Currently entered amount and calculated breakdown
  are preserved seamlessly across device orientation rotations via `onSaveInstanceState`.
- Standard Android XML dimensions (`res/values/sizes.xml`) avoiding hardcoded
  dp/sp values.

------------------------------------------------------------------------
2. TECHNOLOGIES USED
------------------------------------------------------------------------
- Language: Kotlin (1.9.24)
- UI System: Native Android XML Views with ConstraintLayout
- Minimum SDK: API 21 (Android 5.0 Lollipop)
- Target SDK: API 34 (Android 14)
- View Binding: Enabled (`ActivityMainBinding`)
- Architecture: Pure Native Android with decoupled logic (`DenominationCalculator`)
- Unit Testing: JUnit 4

------------------------------------------------------------------------
3. HOW TO OPEN, BUILD, AND RUN THE PROJECT
------------------------------------------------------------------------
1. Open Android Studio.
2. Select "Open an existing Android Studio project" and choose the `VangtiChai`
   folder (`D:/App development/VangtiChai`).
3. Allow Gradle to sync dependencies automatically.
4. Build the project using:
   - In Android Studio: Build > Make Project (Ctrl+F9 / Cmd+F9).
   - Via Gradle CLI: `./gradlew assembleDebug` or `gradlew test`.
5. Run the app on an Android Emulator (e.g. Pixel XL, Nexus 10) or connected
   Android device running API 21+.

------------------------------------------------------------------------
4. HOW DENOMINATION CALCULATION WORKS
------------------------------------------------------------------------
The app uses a Greedy Denomination Algorithm implemented in `DenominationCalculator.kt`:

1. Given an amount in BDT (e.g., 786 BDT):
2. Iterate through the supported denominations array in descending order:
   [500, 100, 50, 20, 10, 5, 2, 1]
3. For each denomination:
   - `note_count = remaining_amount / denomination`
   - `remaining_amount = remaining_amount % denomination`
4. Store the note count and continue to the next lower denomination.

Example (Amount = 786 BDT):
- 500 Taka: 786 / 500 = 1 note  (Remainder = 286)
- 100 Taka: 286 / 100 = 2 notes (Remainder = 86)
-  50 Taka:  86 /  50 = 1 note  (Remainder = 36)
-  20 Taka:  36 /  20 = 1 note  (Remainder = 16)
-  10 Taka:  16 /  10 = 1 note  (Remainder = 6)
-   5 Taka:   6 /   5 = 1 note  (Remainder = 1)
-   2 Taka:   1 /   2 = 0 notes (Remainder = 1)
-   1 Taka:   1 /   1 = 1 note  (Remainder = 0)

Sum Check: 1x500 + 2x100 + 1x50 + 1x20 + 1x10 + 1x5 + 0x2 + 1x1 = 786 BDT.

------------------------------------------------------------------------
5. PORTRAIT AND LANDSCAPE LAYOUT IMPLEMENTATION
------------------------------------------------------------------------
- Default Portrait Layout (`app/src/main/res/layout/activity_main.xml`):
  - Top header card with "Taka:" label and amount display.
  - Denomination breakdown table positioned on the LEFT side.
  - Numeric keypad positioned on the RIGHT side.
- Landscape Layout (`app/src/main/res/layout-land/activity_main.xml`):
  - Rearranges elements across a wider horizontal grid.
  - Header card on top, table on left, keypad on right.
  - All corresponding view IDs match between portrait and landscape layouts,
    allowing `MainActivity.kt` to bind to both without duplicating logic.

------------------------------------------------------------------------
6. TESTING CHECKLIST & RESULTS
------------------------------------------------------------------------
[x] Unit Tests (`DenominationCalculatorTest`):
    - Test Zero Amount (0 BDT -> all 0 notes)
    - Test Assignment Example (786 BDT -> 500:1, 100:2, 50:1, 20:1, 10:1, 5:1, 2:0, 1:1)
    - Test Single Denomination Amounts (500, 100, 50, 20, 10, 5, 2, 1)
    - Test Sum Equality across random & large amounts
    - Test Safe Negative Amount Handling
    - Test Output: PASSED (Verified via JUnit test suite)

Target Device Configurations:
[x] Pixel XL Phone, Portrait (411 x 731 dp): Verified UI constraints and alignment.
[x] Pixel XL Phone, Landscape: Verified rotation and side-by-side layout layout.
[x] Nexus 10 Tablet, Portrait (800 x 1280 dp): Verified tablet scalability.
[x] Nexus 10 Tablet, Landscape: Verified widescreen tablet responsiveness.

Additional Devices Tested:
- Pixel 7 Pro Emulator (1440 x 3120 px, API 34): Verified input flow and CLEAR button.
- Generic 7" Tablet (600 x 1024 dp, API 28): Verified layout scaling.

Note: Layout rendering and logic have been verified against Android Studio Layout Inspector,
ConstraintLayout solver, and JUnit automated unit tests.
