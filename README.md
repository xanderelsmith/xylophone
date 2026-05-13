# 🎹 Xylophone: Building the 4th Kotlin App

A modern, high-performance musical instrument app built with **Jetpack Compose**. This project focuses on mastering UI layouts and low-latency audio implementation on Android.

---

## 📸 Demo

<p align="center">
  <img src="./xylo_demo.gif" alt="Xylophone App Demo" width="300"/>
</p>

---

## ✨ Features

*   **⚡ Zero-Latency Playback:** Uses the `SoundPool` API to pre-load audio into RAM for instant response.
*   **🌈 Material Palette:** A beautiful 7-key interface using standard musical colors (Red, Orange, Yellow, Green, Teal, Blue, Purple).
*   **📱 Edge-to-Edge Design:** Fully immersive UI that bleeds behind the status and navigation bars.
*   **⚖️ Responsive Layout:** Utilizes Compose `weights` to ensure perfect scaling across all screen sizes and orientations.

---

## 🛠️ Tech Stack

*   **Language:** Kotlin
*   **UI Framework:** Jetpack Compose
*   **Audio Engine:** Android `SoundPool`
*   **Design:** Material 3

---

## 🧠 Technical Deep Dive

### SoundPool vs. MediaPlayer
In building an instrument, latency is the enemy. While `MediaPlayer` is common for long-form audio, it suffers from a "start-up lag" unsuitable for rapid tapping. This app implements `SoundPool`, which:
1.  **Pre-loads** files from `res/raw` into memory on startup.
2.  Assigns a **Sound ID** (internal pointer) to each note.
3.  Plays the buffer **instantly** when triggered, bypassing disk-read delays.

### The Layout Logic
Instead of hardcoding seven buttons, the app uses a dynamic `forEachIndexed` loop with `Modifier.weight(1f)`. This ensures that each key receives an equal share of the screen height, regardless of the device resolution or aspect ratio.

---

## 🚀 Setup & Installation

1.  Clone the repository.
2.  Open in **Android Studio**.
3.  Ensure your `app/src/main/res/raw` folder contains `note1.wav` through `note7.wav`.
4.  Build and run on an emulator or physical device.

---

## ✍️ About the Series
This app was built as part of the *"Building Kotlin App as a Flutter Dev."* series, documenting the transition from Flutter to modern Android development.

[Check out the full write-up on Medium!](https://medium.com/@xanderelsmith/jingle-bells-building-my-4th-kotlin-app-the-xylophone-651d651f44da?postPublishedType=repub)
