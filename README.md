# NIT3213 Final Android Application

## Overview
This project is an Android application developed for the NIT3213 final assignment. It demonstrates API integration, user interface design, and Android development best practices.

## Features
- Login screen with username and password
- Dashboard screen with RecyclerView
- Details screen for selected item
- Navigation between screens
- Dependency Injection using Hilt
- Unit tests for core data models

## Technologies Used
- Kotlin
- Android Studio
- Retrofit
- Hilt
- RecyclerView
- Material Design

## How to Run
1. Open the project in Android Studio
2. Sync Gradle files
3. Run the app on an emulator or Android device

## API
Base URL:
https://nit3213api.onrender.com/

The application includes API integration for login and dashboard retrieval. During testing, fallback handling was used when the API endpoint returned errors, so the full application flow could still be demonstrated.

## Project Structure
- MainActivity: Login screen
- DashboardActivity: Dashboard with RecyclerView
- DetailsActivity: Details screen
- ApiService: API endpoints
- NetworkModule: Hilt dependency injection module

## Author
Dipen