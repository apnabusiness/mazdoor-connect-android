# Mazdoor Connect (Native Android - Kotlin + Compose)

Simple, clean, lightweight marketplace MVP for local services in Pakistan.

## Implemented
- Discover workers by city and service category
- Worker cards with verified/rating/jobs/fee details
- Direct contact actions (call/whatsapp placeholder)
- Post service request form
- Worker leads screen
- Profile and verification center section
- Minimal premium-style Compose UI

## GitHub APK Build (No Android Studio Required)
1. Push project to your GitHub repo main branch.
2. Open repository > Actions tab.
3. Run `Build Android APK` workflow (or it runs automatically on push).
4. Open latest run > Artifacts > download `mazdoor-connect-debug-apk`.
5. Extract zip and install `app-debug.apk` on Android device.

## Next production steps
- Firebase Auth (OTP)
- Firestore collections (workers, requests, reviews)
- Real call/whatsapp intents
- CNIC verification workflow
- AdMob integration (policy-safe placements)
- Play Store assets and legal pages
