package com.qktech.designpattern.builder;

import java.util.ArrayList;

/*
 * @Author irwin
 * @CreateAt 2020/1/17 16:09
 * @Description: 简单建造者模式
 * @Since version-1.0
 */
public class SimpleBuilderTest {
    public static void main(String[] args) {
        ArrayList hands = new ArrayList();
        hands.add("左手");
        hands.add("右手");
        ArrayList legs = new ArrayList();
        legs.add("左脚");
        legs.add("右脚");
//        new simpleToy("头", "躯干", hands,legs);
        SimpleToy.Builder builder = new SimpleToy.Builder();
        SimpleToy simpleToy = builder.setBody("躯干").setHead("脑壳").build();
        System.out.println(simpleToy);

    }
}

/*
 * @Author irwin
 * @CreateAt 2020/1/17 13:37
 * @Description: 玩偶产品类
 * @Since version-1.0
 */
class SimpleToy {
    private  String head;
    private  String body;
    private  ArrayList legs;
    private  ArrayList hands;

    public void setHead(String head) {
        this.head = head;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setLegs(ArrayList legs) {
        this.legs = legs;
    }

    public void setHands(ArrayList hands) {
        this.hands = hands;
    }

    //有参构造函数
    public SimpleToy(String head, String body, ArrayList legs, ArrayList hands) {
        this.head = head;
        this.body = body;
        this.legs = legs;
        this.hands = hands;
    }

    public SimpleToy() {
    }

    static class Builder{
        private SimpleToy toy;

        public Builder() {
            toy = new SimpleToy();
        }

        public Builder setHead(String head) {
            toy.setHead(head);
            return this;
        }

        public Builder setBody(String body) {
            toy.setBody(body);
            return this;
        }

        public Builder setLegs(ArrayList legs) {
            toy.setLegs(legs);
            return this;
        }

        public Builder setHands(ArrayList hands) {
            toy.setHands(hands);
            return this;
        }

        public SimpleToy build() {
            return toy;
        }
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return " Toy: " +
                " head='" + head + "\'" +
                " body='" + body + "\'" +
                " hands='" + hands + "\'" +
                " legs='" + legs + "\'";

    }
}
