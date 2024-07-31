
public class BuilderPatternExample {

       public static class Computer {
        private final String CPU;
        private final String RAM;
        private final String storage;
        private final boolean hasGraphicsCard;
        private final boolean hasBluetooth;

        
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.hasGraphicsCard = builder.hasGraphicsCard;
            this.hasBluetooth = builder.hasBluetooth;
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage +
                   ", Graphics Card=" + (hasGraphicsCard ? "Yes" : "No") +
                   ", Bluetooth=" + (hasBluetooth ? "Yes" : "No") + "]";
        }

        
        public static class Builder {
            private String CPU;
            private String RAM;
            private String storage;
            private boolean hasGraphicsCard;
            private boolean hasBluetooth;

            
            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(boolean hasGraphicsCard) {
                this.hasGraphicsCard = hasGraphicsCard;
                return this;
            }

            public Builder setBluetooth(boolean hasBluetooth) {
                this.hasBluetooth = hasBluetooth;
                return this;
            }

            
            public Computer build() {
                return new Computer(this);
            }
        }
    }

    
    public static void main(String[] args) {
        
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard(true)
                .setBluetooth(true)
                .build();


        Computer officeComputer = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .build();

        System.out.println(gamingComputer);
        System.out.println(officeComputer);
    }
}