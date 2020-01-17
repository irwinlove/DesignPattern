package com.qktech.designpattern.builder;

import java.util.ArrayList;

/*
 * @Author irwin
 * @CreateAt 2020/1/17 13:35
 * @Description: 建造者模式测试类
 * @Since version-1.0
 */
public class BuilderTest {
    public static void main(String[] args) {
        //传统方式
//        Toy toy = new Toy();
//        toy.setHead("玩偶头部件");
//        toy.setBody("躯干部件");
//        //...
        //
        ArrayList hands = new ArrayList();
        hands.add("left");
        hands.add("right");
        ArrayList legs = new ArrayList();
        legs.add("left");
        legs.add("right");

        DefaultBuilder defaultBuilder = new DefaultBuilder();
        Director director = new Director(defaultBuilder);
        Toy toy = director.makeToy("头","躯干",hands,legs);
        System.out.println(toy);


    }

}

class Director {
    private ToyBuilder Builder;

    public Director(ToyBuilder builder) {
        Builder = builder;
    }

    public Toy makeToy(String head, String body, ArrayList legs, ArrayList hands) {
        Builder.builderHead(head);
        Builder.builderBody(body);
        Builder.builderHands(hands);
        Builder.builderLegs(legs);
        return Builder.build();
    }
}

interface ToyBuilder {
    void builderHead(String head);

    void builderBody(String Body);

    void builderHands(ArrayList hands);

    void builderLegs(ArrayList legs);
    Toy build();

}

class DefaultBuilder implements ToyBuilder {
    private String head;
    private String body;
    private ArrayList legs;
    private ArrayList hands;

    @Override
    public void builderHead(String head) {
        this.head = head;
    }

    @Override
    public void builderBody(String body) {
        this.body = body;
    }

    @Override
    public void builderHands(ArrayList hands) {
        this.hands = hands;
    }

    @Override
    public void builderLegs(ArrayList legs) {
        this.legs = legs;
    }

    @Override
    public Toy build() {
        return new Toy(this.head,this.body,this.hands,this.legs);
    }
}

/*
 * @Author irwin
 * @CreateAt 2020/1/17 13:37
 * @Description: 玩偶产品类
 * @Since version-1.0
 */
class Toy {
    private String head;
    private String body;
    private ArrayList legs;
    private ArrayList hands;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ArrayList getLegs() {
        return legs;
    }

    public void setLegs(ArrayList legs) {
        this.legs = legs;
    }

    public ArrayList getHands() {
        return hands;
    }

    public void setHands(ArrayList hands) {
        this.hands = hands;
    }

    //有参构造函数
    public Toy(String head, String body, ArrayList legs, ArrayList hands) {
        this.head = head;
        this.body = body;
        this.legs = legs;
        this.hands = hands;
    }

    //无参构造函数
    public Toy() {
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
        return  " Toy: "+
                " head='"+head+"\'"+
                " body='"+body+"\'"+
                " hands='"+hands+"\'"+
                " legs='"+legs+"\'";

    }
}