# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.10

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /Applications/CLion.app/Contents/bin/cmake/bin/cmake

# The command to remove a file.
RM = /Applications/CLion.app/Contents/bin/cmake/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/deezombiedude612/CLionProjects/euclidean_algorithm

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/deezombiedude612/CLionProjects/euclidean_algorithm/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/euclidean_algorithm.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/euclidean_algorithm.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/euclidean_algorithm.dir/flags.make

CMakeFiles/euclidean_algorithm.dir/main.cpp.o: CMakeFiles/euclidean_algorithm.dir/flags.make
CMakeFiles/euclidean_algorithm.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/deezombiedude612/CLionProjects/euclidean_algorithm/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/euclidean_algorithm.dir/main.cpp.o"
	/Library/Developer/CommandLineTools/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/euclidean_algorithm.dir/main.cpp.o -c /Users/deezombiedude612/CLionProjects/euclidean_algorithm/main.cpp

CMakeFiles/euclidean_algorithm.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/euclidean_algorithm.dir/main.cpp.i"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/deezombiedude612/CLionProjects/euclidean_algorithm/main.cpp > CMakeFiles/euclidean_algorithm.dir/main.cpp.i

CMakeFiles/euclidean_algorithm.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/euclidean_algorithm.dir/main.cpp.s"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/deezombiedude612/CLionProjects/euclidean_algorithm/main.cpp -o CMakeFiles/euclidean_algorithm.dir/main.cpp.s

CMakeFiles/euclidean_algorithm.dir/main.cpp.o.requires:

.PHONY : CMakeFiles/euclidean_algorithm.dir/main.cpp.o.requires

CMakeFiles/euclidean_algorithm.dir/main.cpp.o.provides: CMakeFiles/euclidean_algorithm.dir/main.cpp.o.requires
	$(MAKE) -f CMakeFiles/euclidean_algorithm.dir/build.make CMakeFiles/euclidean_algorithm.dir/main.cpp.o.provides.build
.PHONY : CMakeFiles/euclidean_algorithm.dir/main.cpp.o.provides

CMakeFiles/euclidean_algorithm.dir/main.cpp.o.provides.build: CMakeFiles/euclidean_algorithm.dir/main.cpp.o


# Object files for target euclidean_algorithm
euclidean_algorithm_OBJECTS = \
"CMakeFiles/euclidean_algorithm.dir/main.cpp.o"

# External object files for target euclidean_algorithm
euclidean_algorithm_EXTERNAL_OBJECTS =

euclidean_algorithm: CMakeFiles/euclidean_algorithm.dir/main.cpp.o
euclidean_algorithm: CMakeFiles/euclidean_algorithm.dir/build.make
euclidean_algorithm: CMakeFiles/euclidean_algorithm.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/deezombiedude612/CLionProjects/euclidean_algorithm/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable euclidean_algorithm"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/euclidean_algorithm.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/euclidean_algorithm.dir/build: euclidean_algorithm

.PHONY : CMakeFiles/euclidean_algorithm.dir/build

CMakeFiles/euclidean_algorithm.dir/requires: CMakeFiles/euclidean_algorithm.dir/main.cpp.o.requires

.PHONY : CMakeFiles/euclidean_algorithm.dir/requires

CMakeFiles/euclidean_algorithm.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/euclidean_algorithm.dir/cmake_clean.cmake
.PHONY : CMakeFiles/euclidean_algorithm.dir/clean

CMakeFiles/euclidean_algorithm.dir/depend:
	cd /Users/deezombiedude612/CLionProjects/euclidean_algorithm/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/deezombiedude612/CLionProjects/euclidean_algorithm /Users/deezombiedude612/CLionProjects/euclidean_algorithm /Users/deezombiedude612/CLionProjects/euclidean_algorithm/cmake-build-debug /Users/deezombiedude612/CLionProjects/euclidean_algorithm/cmake-build-debug /Users/deezombiedude612/CLionProjects/euclidean_algorithm/cmake-build-debug/CMakeFiles/euclidean_algorithm.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/euclidean_algorithm.dir/depend
