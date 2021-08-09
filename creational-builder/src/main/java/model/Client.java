package model;

public class Client {
    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());
        Product product = director.build();
    }
}

class Product {

}

interface Builder {
    void buildPartA();

    void buildPartB();

    void buildPartC();

    Product getResult();
}

class ConcreteBuilder implements Builder {
    private Product product;

    @Override
    public void buildPartA() {
        product = new Product();
    }

    @Override
    public void buildPartB() {
    }

    @Override
    public void buildPartC() {
    }

    @Override
    public Product getResult() {
        return product;
    }


}

class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Product build() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }

    ;
}