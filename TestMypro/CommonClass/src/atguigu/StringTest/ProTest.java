package atguigu.StringTest;

/**
 * @Author Curry
 * @Create 2020-06-0:45
 */
public class ProTest {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        ProTest pro = new ProTest();
        //将属性str的地址赋给形参String str,属性ch数组的地址赋给形参char ch[]
        //形参str一开始的值为good，调用方法后形参的str的值为test ok,
        // 此时又在方法区开辟了一个新的空间存test ok,此时形参指向方法区中新得内存地址，
        // 但属性str还是指向方法区中原来的内存地址，即good
        //形参ch一开始只做了声明，并没有在堆内存中开辟空间，调用方法后将属性ch的地址赋给形参ch
        //此时形参ch指向堆内存中的test，然后将形参ch数组的第0个下标位置的元素改为b
        //因为形参和属性对应的数据的内存地址都指向堆内存中的test，
        // 所以调用change()方法后数组对应的堆空间中的元素也就改变了
        pro.change(pro.str, pro.ch);
        System.out.println(pro.str);//good
        System.out.println(pro.ch);//best
    }
}
