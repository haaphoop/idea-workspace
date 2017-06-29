package com.company.haaphoop.thinkingInJava;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/6/22 20:37
 * @Modified:
 */
public class Chapter9 {

    /*
    * 9.1 抽象类和抽象方法
    *       包含抽象方法的类称为抽象类。如果一个类包含一个或多个抽象方法，该类必须被限定为抽象的。
    * 9.2 接口
    *       interface 关键字产生一个完全抽象的类。接口可以包含域，但这些域隐式地是static和final的。
    *       可以在接口中显示地将方法声明为public的，但即使不这么做，它们也是public的。因此，当要实现
    *       一个接口时，在接口中被定义的方法必须被定义为public的；否则，它们将只能得到默认的包访问权限，这样在方法
    *       被继承过程中，其可访问权限就被降低了，这是java编译器做不允许的。在接口中任何方法即使没有被声明为public
    *       但它们默认就是public的。
    * 9.3 完全解耦
    *      协变类型：指的是子类中的成员函数的返回值不必严格等同于父类中被重写的成员函数的返回值类型，而可以是
    *      更窄的类型。Java 5.0 添加了对协变类型的支持，即子类覆盖（重写）基类方法时，返回的类型可以是基类方法
    *      返回类型的子类。协变返回类型允许返回更为具体的类型。
    *
    *      创建一个能够根据所传递的参数对象的不同而具有不同行为的方法，被称为策略设计模式。这类方法包含所要执行
    *      的算法中固定不变的部分，而策略包含变化的部分。策略就是传递进去的参数对象，它包含要执行的代码。
    *
    * 9.4 Java中的多重继承
    *       接口不仅仅只是一种更纯粹形式的抽象类，它的目标比这要高。因为接口是根本没有任何具体实现的---也就是说，没有任何
    *       与接口相关的存储；因此，也就无法阻止多个接口的组合。这一点是很有价值的。可以继承任意多个接口，并可以向上转型为
    *       每个接口，因为每一个接口都是一个独立类型。
    *
    *       可以看到，Hero组合了具体类ActionCharacter和CanFight,Swim,CanFly。当通过这种方式将一个具体类和多个接口组合到一起时
    *       这个具体类必须放在前面，后面跟着的才是接口。注意，CanFight接口与ActionCharacter类中的fight()方法的特征签名是一样的，
    *       而且，在Hreo中没有提供fight()方法的定义。可以扩展接口，但是得到的只是另一个接口。当想要创建对象时，所有的定义首先必须都存在。
    *       即使Hreo没有显示地提供fight()的定义，其定义也因ActionCharacter而随之而来，这样就使得创建Hreo成为可能。当Hero对象被
    *       创建时，它可以被传递给这些方法中的任何一个。意味着它依次被向上转型为每一个接口。这就是使用接口的核心原因：为了能够向上转型
    *       为多个基类型。然而，使用接口的第二个原因却是与使用抽象基类相同：防止客户端程序员创建该类的对象，并确保这仅仅是建立一个接口，
    *       这就带来了一个问题：我们应该使用接口还是抽象类？如果要创建不带任何方法定义和成员变量的基类，那么就应该选择接口而不是抽象类。
    *9.5 通过继承类扩展接口
    *       通过继承可以很容易地在接口中添加新的方法声明，还可以通过继承在新接口中组合数个接口。这两种情况都可以获得新的接口。
    *       组合接口时的名字冲突 在实现多重继承时，可能会有一个小陷阱。相同的方法不会有问题，但如果方法的签名或返回类型不同就会出现问题。
    *
    *9.6 适配接口
    *        接口最吸引人的原因之一就是允许同一个接口具有多个不同的实现。在简单的情况中，它的体现形式通常是一个接受接口类型的方法
    *        而该接口的实现和向该方法传递的对象则取决于方法的使用者。因此接口的一种常见用法就是前面提到的策略设计模式，此时，你编写一个执行
    *        某些操作的方法，而该方法将接受一个同样是你指定的接口。你主要是要声明，“你可以用任何你想要的对象来调用我的方法，只要你的对象遵循
    *        我的接口。” Readable接口只要求实现read()方法，在read()方法内部，将输入内容添加到CharBuffer参数中，或者在没有任何输入时返回-1。
    *        假设你有一个还未实现Readable接口的类，怎样才能让Scanner作用于它呢？因为在这种方式中，我们可以在任何现有类之上添加新的接口，所以这意味着让方法接收接口类型，是一种让任何类都可以对该方法进行适配的方式。这
    *        就是使用接口而不是类的强大之处。
    *
    *9.7 接口中的域
    *        因为放入接口中的任何域都自动是static和final的，所以接口就成为了一种很便捷的用来创建常量组的工具。
    *        9.7.1 初始化接口中的域
    *               接口中的域不能是“空final”，但是可以被非常量表达式初始化。例如使用Random进行初始化。既然域是static，它们就可以在类被
    *               第一次加载时初始化，这发生在任何域首次被访问时。当然这些域不是接口的一部分，它们的值被存储在该接口的静态存储区域内。
    *
    *9.8 嵌套接口
    *       接口可以嵌套在类或其他接口中，这展示了许多其他特性。
    *
    * 9.9 接口工厂
    *       接口是实现多重继承的途径，而生成遵循某个接口的对象的典型方式就是工厂方法模式。这与直接调用构造器不同，我们在工厂对象上调用的是
    *       创建方法，而该工厂将生成接口的某个实现的对象。理论上，通过这种方式，我们的代码将完全与接口的实现分离，这就使得我们可以透明地将某个
    *       实现替换为另一个实现。
    *
    * 9.10 总结
    *       “确定接口是理想选择，因而应该总是选择接口而不是具体的类。” 这其实是一种引诱。当然，对于创建类，几乎在任何时刻，都可以替代为创建
    *       一个接口和工厂。许多人都掉进了这种诱惑的陷阱，只要有可能就去创建接口和工厂。这种逻辑看起来好像是因为需要使用不同的具体实现，因此
    *       总是应该添加这种抽象性。这实际上已经变成了一种草率的设计优化。任何抽象性都应该是应真正的需求而产生的。当必需时，你应该重构接口而不是
    *       到处添加额外级别的间接性，并由此带来的复杂性。恰当的原则应该是优先选择类而不是接口。
    *
    *
    * */
}

interface Service{
    void method1();
    void method2();
}

interface ServiceFactory{
    Service getService();
}

class Implementation1 implements Service {
    Implementation1(){}

    @Override
    public void method1() {
        System.out.println("Implementation1 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation1 method2");
    }
}

class Implementation1Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implementation1();
    }
}

class Implementation2 implements Service {
    Implementation2(){}

    @Override
    public void method1() {
        System.out.println("Implementation2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 method2");
    }
}

class Implementation2Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implementation2();
    }
}

class Factories {
    public static void serviceConsumer(ServiceFactory serviceFactory){
        Service service = serviceFactory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factory());
        serviceConsumer(new Implementation2Factory());
    }
}

interface Game{boolean move();}

interface GameFactory{Game getGame();}

class Checkers implements Game {
    private int moves = 0;
    private static final int MOVE = 3;

    @Override
    public boolean move() {

        System.out.println("Checkers move " + moves);
        return ++moves != MOVE;
    }
}

class CheckersFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Checkers();
    }
}

class Chess implements Game {
    private int moves = 0;
    private static final int MOVE = 4;

    @Override
    public boolean move() {
        System.out.println("Chess move " + moves);
        return ++moves != MOVE;
    }
}

class ChessFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Chess();
    }
}

class Games {
    public static void playGame(GameFactory gameFactory){
        Game game = gameFactory.getGame();
        while (game.move()){

        }
    }

    public static void main(String[] args) {
        playGame(new CheckersFactory());
        playGame(new ChessFactory());

    }
}








class A {
    interface B {
        void f();
    }

    public class BImpl implements B{
        public void f(){}
    }

    private class BImpl2 implements B{
        public void f(){}
    }

    interface C {
        void f();
    }

    public class CImpl implements C{
        public void f(){}
    }

    private class CImpl2 implements C{
        public void f(){}
    }

    interface D {
        void f();
    }

    public class DImpl implements D{
        public void f(){}
    }

    private class DImpl2 implements D{
        public void f(){}
    }

    public D getD(){
        return new DImpl2();
    }

    private D dRef;

    public void receiveD(D d){dRef = d;dRef.f();}
}

interface E {
    interface G {void f();}
    public interface H{void f();}

    void g();
}

class NestingInterfaces {
    public class BImpl implements A.B {
        public void f(){}
    }

    class CImpl implements A.C {
        public void f(){}
    }

    class EImpl implements E {
        public void g(){}
    }

    class EGImpl implements E.G {
        public void f(){}
    }

    class EImpl2 implements E {
        public void g(){}
        class EG implements E.G {
            public void f(){}
        }
    }

    public static void main(String[] args) {
        A a = new A();
        A a2 = new A();
        a2.receiveD(a.getD());
    }
}

class RandomDoubles {
    private static Random random = new Random(47);
    public double next(){return random.nextDouble();}

    public static void main(String[] args) {
        RandomDoubles randomDoubles = new RandomDoubles();
        for (int i = 0; i < 7; i++) {
            System.out.println(randomDoubles.next());
        }
    }
}
/*
*
* 再次使用了适配器模式，被适配的类可以通过继承和实现Readable接口来创建。因此，通过使用interface关键字提供的伪多重继承机制，我们可以生成既是RandomDoubles
* 又是Readable的类。
* */

class AdapterRandomDoubles extends RandomDoubles implements Readable {
    private int count;
    public AdapterRandomDoubles(int count){
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {

        if (count-- == 0 ) {
            return -1;
        }

        String result = Double.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new AdapterRandomDoubles(7));
        while (scanner.hasNextDouble())
            System.out.println(scanner.nextDouble() + " ");
    }

    /*
    * 因为在这种方式中，我们可以在任何现有类之上添加新的接口，所以这意味着让方法接收接口类型，是一种让任何类都可以对该方法进行适配的方式。这
    * 就是使用接口而不是类的强大之处。
    * */
}

class RandomWords implements Readable {
    private static Random random = new Random(47);
    private static final char[] capital = "ABCDEFGHIJK".toCharArray();
    private static final char[] lowers = "abcdefghijk".toCharArray();
    private static final char[] vowels = "aeiou".toCharArray();
    private int count;
    public RandomWords(int count) {
        this.count = count;
    }
    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count -- == 0) {
            return -1;
        }
        cb.append(capital[random.nextInt(capital.length)]);
        for (int i = 0; i < 4; i++) {
            cb.append(vowels[random.nextInt(vowels.length)]);
            cb.append(lowers[random.nextInt(lowers.length)]);
        }

        cb.append(" ");
        return 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new RandomWords(10));
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }

}

interface Monster{
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {
    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

class BadVampire implements Vampire {
    @Override
    public void destroy() {
    }

    @Override
    public void menace() {
    }

    @Override
    public void kill() {
    }

    @Override
    public void drinkBlood() {
    }
}

class HorrorShow {
    static void u(Monster monster) {
        monster.menace();
    }

    static void v(DangerousMonster dangerousMonster){
        dangerousMonster.menace();
        dangerousMonster.destroy();
    }

    static void w(Lethal lethal){
        lethal.kill();
    }

    public static void main(String[] args) {
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);
        Vampire vampire = new BadVampire();
        u(vampire);
        v(vampire);
        w(vampire);
    }
}




interface CanFight{
    void fight();
}

interface Swim{
    void swim();
}

interface CanFly{
    void fly();
}

class ActionCharacter{
    public void fight(){
        System.out.println("ActionCharacter");
    }
}

class Hero extends ActionCharacter implements CanFight,Swim,CanFly{
    @Override
    public void fly() {
        System.out.println("Herofly");
    }

    @Override
    public void swim() {
        System.out.println("Heroswim");
    }
}

class Adventure {
    public static void t(CanFight canFight){canFight.fight();}
    public static void u(Swim swim){swim.swim();}
    public static void v(CanFly canFly){canFly.fly();}
    public static void w(ActionCharacter actionCharacter){actionCharacter.fight();}

    public static void main(String[] args) {
        Hero hero = new Hero();
        t(hero);
        u(hero);
        v(hero);
        w(hero);
    }
}

class Processor {
    public String name(){
        return getClass().getSimpleName();
    }

    Object process(Object input){
        return input;
    }
}

/*lass Upcase extends Processor {
    String process(Object input){
        return ((String)input).toUpperCase();
    }
}

class Downcase extends Processor {
    String process(Object input) {
        return ((String)input).toLowerCase();
    }
}

class Splitter extends Processor {
    String process(Object input){
        String[] spliters = ((String) input).split(" ");
        for (String spliter : spliters) {
            System.out.println(spliter);
        }
        return Arrays.toString(spliters);
    }
}*/

class Apply {

    public static String s = "Disagreement with beliefs is by definition incorrect";
    public static void process(Processor processor, Object input) {
        System.out.println("Using Processor : " + processor.name());

        System.out.println(processor.process(input));
    }

    public static void process(Filter filter, Object input) {
        //System.out.println("Using Processor : " + waveform.name());

       // System.out.println(waveform.process(input));
    }

   /* public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }*/
}

class Waveform{
    private static long counter;
    private final long id = counter++;
    public String toString(){return "Waveform " + id;}
}

class Filter {
    public String name(){return getClass().getSimpleName();}
    public Waveform process(Waveform input){
        System.out.println("Filter");
        return input;
    }
}

class LowPass extends Filter {
    double cutoff;
    public LowPass(double cutoff){
        this.cutoff = cutoff;
    }
    public Waveform process(Waveform input){
        return input;
    }
}

class HighPass extends Filter {
    double cutoff;
    public HighPass(double cutoff){
        this.cutoff = cutoff;
    }
    public Waveform process(Waveform input){
        System.out.println("HighPass");
        return input;
    }
}

class BandPass extends Filter {
    double lowoff, highoff;
    public BandPass(double lowoff, double highoff){
        this.lowoff = lowoff;
        this.highoff = highoff;
    }
    public Waveform process(Waveform input){
        System.out.println("BandPass");
        return input;
    }
}
/*
* Filter与Processor具有相同的接口元素，但是因为它并非继承自Processor--因为Filter 类的创建者压根不清楚你想要将它用作Processor
* 因此，你不能将Filter用于Apply.process(),即便这样做可以正常运行。这里主要是因为Apply.process()方法和Processor之间的耦合过紧，
* 已经超出了所需要的程度，这就使得应该复用Apply.process()代码时，复用却被禁止了。另外，还需要注意的是，它们的输入和输出都是Waveform.
* 但是，如果Processor是一个接口，那么这些限制就会变得松动，使得你可以复用结构该接口的Apply.process()。
*
*
* */

interface Processor1 {
    String name();
    Object process(Object input);
}

class Apply1 {
    public static void  process(Processor1 processor, Object object){
        System.out.println("Using Processor1 " + processor);
        System.out.println(processor.process(object));
    }
    /*
    * 复用代码的第一种方式是客户端程序员遵循该接口来编写他们自己的类，就像下面这样：
    * */
}

abstract class StringProcessor implements Processor1 {
    public String name(){
        return getClass().getSimpleName();
    }
    public abstract String process(Object object);

    public static String s = "If she weights the same as a duck, she's made of wood";

    public static void main(String[] args) {
        Apply1.process(new Upcase(),s);
        Apply1.process(new Downcase(),s);
        Apply1.process(new Splitter(),s);
    }
}

class Upcase extends StringProcessor {
    @Override
    public String process(Object object) {
        return ((String)object).toUpperCase();
    }
}

class Downcase extends StringProcessor {
    @Override
    public String process(Object object) {
        return ((String)object).toLowerCase();
    }
}

class Splitter extends StringProcessor {
    @Override
    public String process(Object object) {
        return Arrays.toString(((String)object).split(" "));
    }
}
/*
* 但是，经常碰到的情况是无法修改想要使用的类。这种情况下，可以使用适配器设计模式。适配器中的代码将接受你所拥有的接口，并
* 产生你所需要的接口。像下面这样：
* */

class FilterAdapter implements Processor1 {
    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    public Waveform process(Object input){
        return  filter.process((Waveform) input);
    }
}

class FilterProcessor {
    public static void main(String[] args) {
        Waveform waveform = new Waveform();
        Apply1.process(new FilterAdapter(new LowPass(1.0)),waveform);
        Apply1.process(new FilterAdapter(new HighPass(2.0)),waveform);
        Apply1.process(new FilterAdapter(new BandPass(3.0,  4.0)),waveform);
    }
}
/*
*
* */
/*
interface Processor{
    String name();
    Object process(Object object);
}
class Waveform {
    private static long counter;
    private final long id = ++counter;
    public String toString(){
        return "Waveform " + id;
    }
}
class LowPass extends Filter {
    double cutoff;
    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    public Waveform process(Waveform input){
        return input;
    }
}

class HighPass extends Filter {
    double cutoff;
    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    public Waveform process(Waveform input){
        return input;
    }
}

class BandPass extends Filter {
    double lowCutoff, highCutoff;
    public BandPass(double lowCutoff, double highCutoff ) {
        this.lowCutoff= lowCutoff;
        this.highCutoff = highCutoff;
    }

    public Waveform process(Waveform input){
        return input;
    }
}
class Filter {
    public String name(){
        return getClass().getSimpleName();
    }

    public Waveform process (Waveform input) {
        return input;
    }
}
class Apply {
    public static void process(Processor processor, Object object){
        System.out.println("Using Processor " + processor);
        System.out.println(processor.process(object));
    }
}
class FilterAdapter implements Processor {
    Filter filter;
    public FilterAdapter(Filter filter){
        this.filter = filter;
    }

    public String name(){
        return filter.name();
    }

    public Waveform process(Object input){
        return filter.process((Waveform)input);
    }
}


class FilterProcessor {
    public static void main(String[] args) {
        Waveform waveform = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)), waveform);
        Apply.process(new FilterAdapter(new HighPass(2.0)), waveform);
        Apply.process(new FilterAdapter(new BandPass(3.0,4.0)), waveform);
    }
}*/
