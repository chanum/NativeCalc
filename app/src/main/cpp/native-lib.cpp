#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_mapx_kosten_basicnativeccalculator_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


// Addition function
extern "C" JNIEXPORT jfloat JNICALL
Java_com_mapx_kosten_basicnativeccalculator_MainActivity_add( JNIEnv *env, jobject, jfloat x, jfloat y) {

    // return an integer
    return x + y;
}

// Subtraction function
extern "C" JNIEXPORT jfloat JNICALL
Java_com_mapx_kosten_basicnativeccalculator_MainActivity_sub( JNIEnv *env, jobject, jfloat x, jfloat y) {

    // return an integer
    return x - y;
}

// Multiplication function
extern "C" JNIEXPORT jfloat JNICALL
Java_com_mapx_kosten_basicnativeccalculator_MainActivity_multiply( JNIEnv *env, jobject, jfloat x, jfloat y) {

    // return an integer
    return x * y;
}

//Division function
extern "C" JNIEXPORT jfloat JNICALL
Java_com_mapx_kosten_basicnativeccalculator_MainActivity_divide( JNIEnv *env, jobject, jfloat x, jfloat y) {

    // return an integer
    if (y>0) {
        return x / y;
    }
    return 0.0;
}