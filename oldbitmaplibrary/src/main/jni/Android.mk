LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := load_bitmap
LOCAL_SRC_FILES := ../cpp/native-lib.cpp

LOCAL_LDLIBS += -lm
LOCAL_LDLIBS += -llog
LOCAL_LDLIBS += -ljnigraphics

LOCAL_CPPFLAGS += -std=c++11

include $(BUILD_SHARED_LIBRARY)

