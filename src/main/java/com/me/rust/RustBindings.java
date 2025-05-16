package com.me.rust;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.nio.file.Path;

public class RustBindings {

  private RustBindings() {}

  private static final MethodHandle addNumbers; // Wrapper for the Rust function

  static {
      Path dylibPath = Path.of("rust-lib/target/release/librust_lib.dylib");
      SymbolLookup lookup = SymbolLookup.libraryLookup(dylibPath, Arena.global());
      Linker linker = Linker.nativeLinker();

      addNumbers = linker.downcallHandle(
          lookup.find("add_numbers").orElseThrow(),
          FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT)
      );
  }

  public static int addNumbers(int x, int y) throws Throwable {
    return (int) addNumbers.invoke(x, y);
  }
}
