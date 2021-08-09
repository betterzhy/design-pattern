package simple;

public class Client {
    public static void main(String[] args) {
        Config config = new Config.Builder()
                .minSize(5)
                .maxSize(20)
                .build();
        System.out.println(config.getMaxSize());
    }
}

class Config {
    private final int maxSize;
    private final int minSize;

    public Config(Builder builder) {
        this.maxSize = builder.maxSize;
        this.minSize = builder.minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getMinSize() {
        return minSize;
    }

    public static class Builder {
        private int maxSize;
        private int minSize;

        public Builder maxSize(int maxSize) {
            this.maxSize = maxSize;
            return this;
        }

        public Builder minSize(int minSize) {
            this.minSize = minSize;
            return this;
        }

        public Config build() {
            return new Config(this);
        }
    }
}
