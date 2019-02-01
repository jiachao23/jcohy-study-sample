
#  Java
> #### PS:�������С�������
> #### ������ҳ��[www.jcohy.com](http://www.jcohy.com)  	

>  �ҵ�ѧϰ�ʼǣ���¼ѧϰ�����еıʼ��Լ�����������,�Լ��ҵ�һЩ�����ܽᡣ�����������ʧЧ,������֪����������ݵ���������ύ Issues �������޸�������ݡ�

## java��������
> * java����
>   * [Java�����ʵ�����л�����ʲô���壿](#stream-1)
>   * [Java���м������͵�����](#stream-2)
>   * [дһ������������һ���ļ�����һ���ַ�����ͳ������ַ���������ļ��г��ֵĴ�����](#stream-3)
>   * [�����Java�����г�һ��Ŀ¼�����е��ļ���](#stream-4)
> * java����
>   * [���һ��������������Щ��ʽ��](#reflect-1)
>   * [���ͨ�����䴴������](#reflect-2)
>   * [���ͨ�������ȡ�����ö���˽���ֶε�ֵ��](#reflect-3)
>   * [���ͨ��������ö���ķ�����](#reflect-4)
> * java������
>   * [��Java���׽��ֱ��ʵ��һ�����̵߳Ļ��ԣ�echo����������](#socket-1)

<p id="stream-1">

####  Java�����ʵ�����л�����ʲô���壿
���л�����һ����������������Ļ��ƣ���ν������Ҳ���ǽ���������ݽ������������Զ�������Ķ�����ж�д������Ҳ�ɽ�������Ķ�����������֮�䡣���л���Ϊ�˽����������д����ʱ�������������⣨������������л����ܻ����������������⣩��Ҫʵ�����л�����Ҫ��һ����ʵ��Serializable�ӿڣ��ýӿ���һ����ʶ�Խӿڣ���ע��������ǿɱ����л��ģ�Ȼ��ʹ��һ�������������һ�������������ͨ��writeObject(Object)�����Ϳ��Խ�ʵ�ֶ���д������������״̬���������Ҫ�����л��������һ������������������������Ȼ��ͨ��readObject���������ж�ȡ�������л������ܹ�ʵ�ֶ���ĳ־û�֮�⣬���ܹ����ڶ������ȿ�¡��

<p id="stream-2">

#### Java���м������͵�����

�ֽ������ַ�����

�ֽ����̳���InputStream��OutputStream

�ַ����̳���Reader��Writer��

��java.io ���л������������������Ҫ��Ϊ��������ܺ�ʹ�÷��㡣����Java��I/O��Ҫע��������㣺

- һ�����ֶԳ��ԣ����������ĶԳ��ԣ��ֽں��ַ��ĶԳ��ԣ���

- �����������ģʽ��������ģʽ��װ��ģʽ����

����Java�е�����ͬ��C#������ֻ��һ��ά��һ������

���ʵ���ļ��������������Ŀ�ڱ��Ե�ʱ�򾭳����֣�����Ĵ������������ʵ�ַ�����

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public final class MyUtil {
    private MyUtil() {
        throw new AssertionError();
    }
    public static void fileCopy(String source, String target) throws IOException {
        try (InputStream in = new FileInputStream(source)) {
            try (OutputStream out = new FileOutputStream(target)) {
                byte[] buffer = new byte[4096];
                int bytesToRead;
                while((bytesToRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesToRead);
                }
            }
        }
    }
    public static void fileCopyNIO(String source, String target) throws IOException {
        try (FileInputStream in = new FileInputStream(source)) {
            try (FileOutputStream out = new FileOutputStream(target)) {
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while(inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }
}
```


ע�⣺�����õ�Java 7��TWR��ʹ��TWR����Բ�����finally���ͷ��ⲿ��Դ���Ӷ��ô���������š�

<p id="stream-3">

#### дһ������������һ���ļ�����һ���ַ�����ͳ������ַ���������ļ��г��ֵĴ�����

```java
import java.io.BufferedReader;
import java.io.FileReader;
public final class MyUtil {
    // �������еķ������Ǿ�̬��ʽ���ʵ���˽�������˽�в�����������(���Ժ�ϰ��)
    private MyUtil() {
        throw new AssertionError();
    }
    /**
	*ͳ�Ƹ����ļ��и����ַ����ĳ��ִ���
	*
    * @param filename �ļ���
    * @param word �ַ���
    * @return �ַ������ļ��г��ֵĴ���
	*/
    public static int countWordInFile(String filename, String word) {
        int counter = 0;
        try (FileReader fr = new FileReader(filename)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    int index = -1;
                    while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
                        counter++;
                        line = line.substring(index + word.length());
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return counter;
    }
}

```

<p id="stream-4">

#### �����Java�����г�һ��Ŀ¼�����е��ļ���

���ֻҪ���г���ǰ�ļ����µ��ļ�������������ʾ��

```java
import java.io.File;
class Test12 {
    public static void main(String[] args) {
        File f = new File("/Users/Hao/Downloads");
        for(File temp : f.listFiles()) {
            if(temp.isFile()) {
                System.out.println(temp.getName());
            }
        }
    }
}
```

�����Ҫ���ļ��м���չ��������������ʾ��

```java
import java.io.File;
class Test12 {
    public static void main(String[] args) {
        showDirectory(new File("/Users/Hao/Downloads"));
    }
    public static void showDirectory(File f) {
        _walkDirectory(f, 0);
    }
    private static void _walkDirectory(File f, int level) {
        if(f.isDirectory()) {
            for(File temp : f.listFiles()) {
                _walkDirectory(temp, level + 1);
            }
        }
        else {
            for(int i = 0; i < level - 1; i++) {
                System.out.print("\t");
            }
            System.out.println(f.getName());
        }
    }
}
```

��Java 7�п���ʹ��NIO.2��API����ͬ�������飬����������ʾ��

```java
class ShowFileTest {
    public static void main(String[] args) throws IOException {
        Path initPath = Paths.get("/Users/Hao/Downloads");
        Files.walkFileTree(initPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                throws IOException {
                System.out.println(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
```

<p id="reflect-1">

#### ���һ��������������Щ��ʽ��

- ����1������.class

  ���磺`String.class`

- ����2������.getClass()

  ���磺`"hello".getClass()` 

- ����3��Class.forName()

  ���磺`Class.forName("java.lang.String")`

<p id="reflect-2">

#### ���ͨ�����䴴������

- ����1��ͨ����������newInstance()����

  ���磺`String.class.newInstance()` 

- ����2��ͨ��������getConstructor()��getDeclaredConstructor()������ù�������Constructor�����󲢵�����newInstance()������������

  ���磺`String.class.getConstructor(String.class).newInstance("Hello");`

<p id="reflect-3">

#### ���ͨ�������ȡ�����ö���˽���ֶε�ֵ��

����ͨ��������getDeclaredField()�����ֶΣ�Field������Ȼ����ͨ���ֶζ����setAccessible(true)��������Ϊ���Է��ʣ��������Ϳ���ͨ��get/set��������ȡ/�����ֶε�ֵ�ˡ�����Ĵ���ʵ����һ������Ĺ����࣬���е�������̬�����ֱ����ڻ�ȡ������˽���ֶε�ֵ���ֶο����ǻ�������Ҳ�����Ƕ���������֧�ֶ༶�������

����ReflectionUtil.get(dog, "owner.car.engine.id");���Ի��dog��������˵������������ID�š�

```java
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
/**

- ���乤����
- @author ���
*
*/
public class ReflectionUtil {
    private ReflectionUtil() {
        throw new AssertionError();
    }
    /**
- ͨ������ȡ����ָ���ֶ�(����)��ֵ
- @param target Ŀ�����
- @param fieldName �ֶε�����
- @throws ���ȡ��������ָ���ֶε�ֵ���׳��쳣
- @return �ֶε�ֵ
*/
    public static Object getValue(Object target, String fieldName) {
        Class<?> clazz = target.getClass();
        String[] fs = fieldName.split("\.");
        try {
            for(int i = 0; i < fs.length - 1; i++) {
                Field f = clazz.getDeclaredField(fs[i]);
                f.setAccessible(true);
                target = f.get(target);
                clazz = target.getClass();
            }
            Field f = clazz.getDeclaredField(fs[fs.length - 1]);
            f.setAccessible(true);
            return f.get(target);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
- ͨ������������ָ���ֶθ�ֵ
- @param target Ŀ�����
- @param fieldName �ֶε�����
- @param value ֵ
*/
    public static void setValue(Object target, String fieldName, Object value) {
        Class<?> clazz = target.getClass();
        String[] fs = fieldName.split("\.");
        try {
            for(int i = 0; i < fs.length - 1; i++) {
                Field f = clazz.getDeclaredField(fs[i]);
                f.setAccessible(true);
                Object val = f.get(target);
                if(val == null) {
                    Constructor<?> c = f.getType().getDeclaredConstructor();
                    c.setAccessible(true);
                    val = c.newInstance();
                    f.set(target, val);
                }
                target = val;
                clazz = target.getClass();
            }
            Field f = clazz.getDeclaredField(fs[fs.length - 1]);
            f.setAccessible(true);
            f.set(target, value);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

```

<p id="reflect-4">

#### ���ͨ��������ö���ķ�����
�뿴����Ĵ��룺

```java
import java.lang.reflect.Method;
class MethodInvokeTest {
    public static void main(String[] args) throws Exception {
        String str = "hello";
        Method m = str.getClass().getMethod("toUpperCase");
        System.out.println(m.invoke(str)); // HELLO
    }
}
```


<p id="socket-1">

####  ��Java���׽��ֱ��ʵ��һ�����̵߳Ļ��ԣ�echo����������

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class EchoServer {
    private static final int ECHO_SERVER_PORT = 6789;
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(ECHO_SERVER_PORT)) {
            System.out.println("�������Ѿ�����...");
            while(true) {
                Socket client = server.accept();
                new Thread(new ClientHandler(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static class ClientHandler implements Runnable {
        private Socket client;
        public ClientHandler(Socket client) {
            this.client = client;
        }
        @Override
        public void run() {
            try(BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter pw = new PrintWriter(client.getOutputStream())) {
                String msg = br.readLine();
                System.out.println("�յ�" + client.getInetAddress() + "���͵�: " + msg);
                pw.println(msg);
                pw.flush();
            } catch(Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```
ע�⣺����Ĵ���ʹ����Java 7��TWR�﷨�����ںܶ��ⲿ��Դ�඼��ӵ�ʵ����AutoCloseable�ӿڣ��������ص��ӿڣ�����˿�������TWR�﷨��try������ʱ��ͨ���ص��ķ�ʽ�Զ������ⲿ��Դ���close()������������д�߳���finally����顣���⣬����Ĵ�����һ����̬�ڲ���ʵ���̵߳Ĺ��ܣ�ʹ�ö��߳̿��Ա���һ���û�I/O�������������ж�Ӱ�������û��Է������ķ��ʣ��򵥵�˵����һ���û����������������������û�����������Ȼ������Ĵ���ʹ���̳߳ؿ��Ի�ø��õ����ܣ���ΪƵ���Ĵ����������߳�����ɵĿ���Ҳ�ǲ��ɺ��ӵġ�
������һ�λ��Կͻ��˲��Դ��룺

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class EchoClient {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("localhost", 6789);
        Scanner sc = new Scanner(System.in);
        System.out.print("����������: ");
        String msg = sc.nextLine();
        sc.close();
        PrintWriter pw = new PrintWriter(client.getOutputStream());
        pw.println(msg);
        pw.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println(br.readLine());
        client.close();
    }
}
```

���ϣ����NIO�Ķ�·�����׽���ʵ�ַ�����������������ʾ��NIO�Ĳ�����Ȼ�����˸��õ����ܣ�������Щ�����ǱȽϵײ�ģ����ڳ�ѧ����˵������Щ������⡣

```java
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
public class EchoServerNIO {
    private static final int ECHO_SERVER_PORT = 6789;
    private static final int ECHO_SERVER_TIMEOUT = 5000;
    private static final int BUFFER_SIZE = 1024;
    private static ServerSocketChannel serverChannel = null;
    private static Selector selector = null; // ��·����ѡ����
    private static ByteBuffer buffer = null; // ������
    public static void main(String[] args) {
        init();
        listen();
    }
    private static void init() {
        try {
            serverChannel = ServerSocketChannel.open();
            buffer = ByteBuffer.allocate(BUFFER_SIZE);
            serverChannel.socket().bind(new InetSocketAddress(ECHO_SERVER_PORT));
            serverChannel.configureBlocking(false);
            selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static void listen() {
        while (true) {
            try {
                if (selector.select(ECHO_SERVER_TIMEOUT) != 0) {
                    Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey key = it.next();
                        it.remove();
                        handleKey(key);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private static void handleKey(SelectionKey key) throws IOException {
        SocketChannel channel = null;
        try {
            if (key.isAcceptable()) {
                ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                channel = serverChannel.accept();
                channel.configureBlocking(false);
                channel.register(selector, SelectionKey.OP_READ);
            } else if (key.isReadable()) {
                channel = (SocketChannel) key.channel();
                buffer.clear();
                if (channel.read(buffer) > 0) {
                    buffer.flip();
                    CharBuffer charBuffer = CharsetHelper.decode(buffer);
                    String msg = charBuffer.toString();
                    System.out.println("�յ�" + channel.getRemoteAddress() + "����Ϣ��" + msg);
                    channel.write(CharsetHelper.encode(CharBuffer.wrap(msg)));
                } else {
                    channel.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (channel != null) {
                channel.close();
            }
        }
    }
}


import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
public final class CharsetHelper {
    private static final String UTF_8 = "UTF-8";
    private static CharsetEncoder encoder = Charset.forName(UTF_8).newEncoder();
    private static CharsetDecoder decoder = Charset.forName(UTF_8).newDecoder();
    private CharsetHelper() {
    }
    public static ByteBuffer encode(CharBuffer in) throws CharacterCodingException{
        return encoder.encode(in);
    }
    public static CharBuffer decode(ByteBuffer in) throws CharacterCodingException{
        return decoder.decode(in);
    }
}
```