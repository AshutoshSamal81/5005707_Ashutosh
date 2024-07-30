public class BuilderPatternExample {

    // Product class
    public static class Computer {
        // Attributes
        private final String CPU;
        private final String RAM;
        private final String Storage;
        private final String GPU;
        private final boolean isBluetoothEnabled;

        // Private constructor
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.Storage = builder.Storage;
            this.GPU = builder.GPU;
            this.isBluetoothEnabled = builder.isBluetoothEnabled;
        }

        // Getters
        public String getCPU() {
            return CPU;
        }

        public String getRAM() {
            return RAM;
        }

        public String getStorage() {
            return Storage;
        }

        public String getGPU() {
            return GPU;
        }

        public boolean isBluetoothEnabled() {
            return isBluetoothEnabled;
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + Storage + ", GPU=" + GPU +
                    ", Bluetooth Enabled=" + isBluetoothEnabled + "]";
        }

        // Static nested Builder class
        public static class Builder {
            // Required parameters
            private final String CPU;
            private final String RAM;

            // Optional parameters
            private String Storage = "256GB SSD";
            private String GPU = "Integrated";
            private boolean isBluetoothEnabled = false;

            // Constructor with required parameters
            public Builder(String CPU, String RAM) {
                this.CPU = CPU;
                this.RAM = RAM;
            }

            // Methods to set optional parameters
            public Builder setStorage(String storage) {
                this.Storage = storage;
                return this;
            }

            public Builder setGPU(String gpu) {
                this.GPU = gpu;
                return this;
            }

            public Builder enableBluetooth(boolean bluetooth) {
                this.isBluetoothEnabled = bluetooth;
                return this;
            }

            // Build method to return the final Computer instance
            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Main method to test the Builder Pattern
    public static void main(String[] args) {
        // Create a basic Computer
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
            .build();
        System.out.println(basicComputer);

        // Create a high-end Computer with all options
        Computer gamingComputer = new Computer.Builder("AMD Ryzen 7", "16GB")
            .setStorage("1TB SSD")
            .setGPU("NVIDIA GTX 3080")
            .enableBluetooth(true)
            .build();
        System.out.println(gamingComputer);

        // Create a mid-range Computer with some options
        Computer midRangeComputer = new Computer.Builder("Intel i7", "12GB")
            .setStorage("512GB SSD")
            .build();
        System.out.println(midRangeComputer);
    }
}

