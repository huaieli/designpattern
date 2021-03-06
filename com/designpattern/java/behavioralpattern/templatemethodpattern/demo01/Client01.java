package behavioralpattern.templatemethodpattern.demo01;

/**
 * @author shusheng
 * @description 模板方法设计模式
 * @Email eric_wu_peng@126.com
 * @date 2019/4/18 16:56
 */
abstract class HouseTemplate {
    protected String name;

    protected HouseTemplate(String name){
        this.name = name;
    }

    protected abstract void buildDoor();
    protected abstract void buildWindow();
    protected abstract void buildWall();
    protected abstract void buildBase();

    //公共逻辑
    public final void buildHouse(){
        buildBase();
        buildWall();
        buildDoor();
        buildWindow();
    }

}
class HouseOne extends HouseTemplate {

    HouseOne(String name){
        super(name);
    }

    @Override
    protected void buildDoor() {
        System.out.println(name +"的门要采用防盗门");
    }
    @Override
    protected void buildWindow() {
        System.out.println(name + "的窗户要面向北方");
    }
    @Override
    protected void buildWall() {
        System.out.println(name + "的墙使用大理石建造");
    }
    @Override
    protected void buildBase() {
        System.out.println(name + "的地基使用钢铁地基");
    }

}

class HouseTwo extends HouseTemplate {

    HouseTwo(String name){
        super(name);
    }

    @Override
    protected void buildDoor() {
        System.out.println(name + "的门采用木门");
    }
    @Override
    protected void buildWindow() {
        System.out.println(name + "的窗户要向南");
    }
    @Override
    protected void buildWall() {
        System.out.println(name + "的墙使用玻璃制造");
    }
    @Override
    protected void buildBase() {
        System.out.println(name + "的地基使用花岗岩");
    }

}

public class Client01 {

    public static void main(String[] args){
        HouseTemplate houseOne = new HouseOne("房子1");
        HouseTemplate houseTwo = new HouseTwo("房子2");
        houseOne.buildHouse();
        System.out.println("-----------------休息一下--------------------------");
        houseTwo.buildHouse();
    }

}
