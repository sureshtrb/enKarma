# Preserve Firebase SDK
-keep class com.google.firebase.** { *; }
-dontwarn com.google.firebase.**

# Preserve Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}

# Preserve Gson (for JSON serialization/deserialization)
-keep class com.google.gson.** { *; }
-keepattributes Signature
-keepattributes *Annotation*

# Preserve Jsoup
-dontwarn org.jsoup.**

# Preserve Kotlinx datetime
-dontwarn kotlinx.datetime.**

# Preserve AndroidAsyncHttp
-dontwarn cz.msebera.android.httpclient.**

# Preserve CircleImageView
-keep class de.hdodenhof.circleimageview.** { *; }

# Preserve Pusher
-dontwarn com.pusher.client.**

# Optional: Enable stack trace line numbers
-keepattributes SourceFile,LineNumberTable

# Optional: Remove original file names from stack traces
#-renamesourcefileattribute SourceFile

# If using WebView with JS (custom interface)
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Legacy Parse support (if still used, else remove this)
#-keep public class com.parse.**

# Optional for debugging ProGuard issues:
#-dontnote
#-dontwarn
