cmake(
android {

buildTypes {
release {

debuggable true
}
}
})

# In your CMakeLists.txt file
set(CMAKE_BUILD_TYPE Debug) # Set build type to Debug

# 16KB page alignment for Android 15+ compatibility
set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -Wl,-z,max-page-size=16384")
