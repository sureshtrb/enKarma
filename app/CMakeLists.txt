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