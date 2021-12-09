package com.javaSE.bean;

public class over {

    private int anInt;
    private double d;
    private int aInt;
    private boolean ad;
    private String dd;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        over over = (over) o;

        if (anInt != over.anInt) return false;
        if (Double.compare(over.d, d) != 0) return false;
        if (aInt != over.aInt) return false;
        if (ad != over.ad) return false;
        return dd != null ? dd.equals(over.dd) : over.dd == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        temp = Double.doubleToLongBits(d);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + aInt;
        result = 31 * result + (ad ? 1 : 0);
        result = 31 * result + (dd != null ? dd.hashCode() : 0);
        return result;
    }
}
