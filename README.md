# Android MVVM App

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Installation](#installation)

## General info
I wanted to create this project to show the concepts of the **MVVM**, **Unit Testing**, **Dependency Injection**

Language: **Kotlin**


## Technologies
Project is created with:
- **Dagger 2**
- **RxJava 2**
- **Retrofit 2**
- **Glide**
- **Mockito**

#### Dependencies

```

apply plugin: 'kotlin-kapt'

  implementation 'com.squareup.retrofit2:retrofit:2.5.0'
  implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
  implementation 'com.squareup.retrofit2:adapter-rxjava2:2.4.0'

  implementation "io.reactivex.rxjava2:rxjava:2.1.9"
  implementation "io.reactivex.rxjava2:rxandroid:2.0.2"

  implementation 'com.google.dagger:dagger:2.22.1'
  implementation "com.google.dagger:dagger-android-support:2.22.1"
  kapt "com.google.dagger:dagger-compiler:2.22.1"
  kapt "com.google.dagger:dagger-android-processor:2.22.1"

  implementation "android.arch.lifecycle:extensions:1.1.1"
  testImplementation "org.mockito:mockito-inline:2.13.0"
  testImplementation 'android.arch.core:core-testing:1.1.1'
  implementation 'com.github.bumptech.glide:glide:4.9.0'


  api 'com.google.android.material:material:1.1.0-alpha07'
  implementation 'de.hdodenhof:circleimageview:3.0.0'
  implementation 'androidx.recyclerview:recyclerview:1.1.0-alpha06'

```

#### Permissions

```xml

<uses-permission android:name="android.permission.INTERNET"/>

```

#### Unit Testing



![Screen Shot 2019-06-07 at 3 40 22 PM](https://user-images.githubusercontent.com/11635523/59132398-b340fd00-893a-11e9-8fa2-8d86fa21beac.png)


![Screen Shot 2019-06-07 at 3 41 02 PM](https://user-images.githubusercontent.com/11635523/59132399-b340fd00-893a-11e9-8600-a806565d8c21.png)


## Installation
To run this project, Clone this repository and import into **Android Studio**
