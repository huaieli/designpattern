package structuralpattern.compositepattern.demo02;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description 安全式组合模式
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-08-01
 */
// 抽象构件类、节点类
abstract class Component {
    public String name;

    public Component(String name) {
        this.name = name;
    }

    // 公有操作
    public abstract void display(int level);
}

// 树叶构件类
class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void display(int level) {
        System.out.println(level+"--"+name);
    }
}

// 树根树枝构件类
class Composite extends Component {

    private List<Component> children = new LinkedList<>();

    public Composite(String name) {
        super(name);
        this.children = new LinkedList<Component>();
    }
    // 添加一个节点，可能是树枝、叶子
    public void add(Component child) {
        children.add(child);
    }
    // 删除一个节点，可能是树枝、叶子
    public void remove(String child) {
        children.remove(child);
    }
    @Override
    public void display(int level) {
        System.out.print(level);
        for(int i=0;i<=level;i++){
            System.out.print("---");
        }
        System.out.println(name);
        for(Component c:children){
            c.display(level+1);
        }
    }

}

public class Client {

    public static void main(String[] args) {

        Composite root = new Composite("树根");

        Composite branch01 = new Composite("树枝01");
        Composite branch02 = new Composite("树枝02");

        root.add(branch01);
        root.add(branch02);

        Component leaf01 = new Leaf("树叶01");
        Component leaf02 = new Leaf("树叶02");
        Component leaf03 = new Leaf("树叶03");
        Component leaf04 = new Leaf("树叶04");
        Component leaf05 = new Leaf("树叶05");

        branch01.add(leaf01);
        branch01.add(leaf02);

        branch02.add(leaf03);
        branch02.add(leaf04);
        branch02.add(leaf05);

        root.display(1);

    }

}
