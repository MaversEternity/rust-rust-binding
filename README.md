# Java ↔ Rust Interop via Foreign Function & Memory API (FFM)

This project demonstrates calling a native Rust function from Java using the Foreign Function & Memory (FFM) API introduced in Java 22+.

---

## 🛠 Prerequisites

- Java 22 or later
- Rust toolchain (`cargo`)
- Maven (for building the Java module)

---

## 🚀 Building the Project

### 1. Compile the Rust library

```bash
cargo build --release --manifest-path rust-lib/Cargo.toml
```

### 2. Build and run the Java application using Maven 
still need to add VM flag for running <b>--enable-native-access=com.me.rust<b>