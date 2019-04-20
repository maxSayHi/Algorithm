package bobo.learn.algorithm.primary;

import java.util.HashMap;
import java.util.Objects;

public class Provider {
    private int num;
    private String name;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        super.equals(o);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provider provider = (Provider) o;
        return num == provider.num &&
                Objects.equals(name, provider.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, name);
    }
}
