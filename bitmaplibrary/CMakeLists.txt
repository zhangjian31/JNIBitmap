
cmake_minimum_required(VERSION 3.4.1)

add_library(load_bitmap SHARED src/main/cpp/native-lib.cpp )

find_library(log-lib log )

target_link_libraries(load_bitmap jnigraphics ${log-lib} )