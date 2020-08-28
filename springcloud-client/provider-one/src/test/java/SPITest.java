import com.springcloud.client.common.api.PostMessage;
import com.zms.springcloud.provider.dubbo.services.PostMessageProvider;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Exporter;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Protocol;
import org.apache.dubbo.rpc.ProxyFactory;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SPITest {

    @Test
    public void test(){
        ExtensionLoader<PostMessage> postMessageExtensionLoader=ExtensionLoader.getExtensionLoader(PostMessage.class);
        PostMessage postMessage=postMessageExtensionLoader.getExtension("main");
        postMessage.sendMsg("hello");
    }

    @Test
    public void test1(){
        ExtensionLoader<PostMessage> postMessageExtensionLoader=ExtensionLoader.getExtensionLoader(PostMessage.class);
        PostMessage postMessage=postMessageExtensionLoader.getAdaptiveExtension();
//        postMessage.sendMsg("sd");
        Map<String, String> parameters =new HashMap<>();
        parameters.put("post.message","main");
        URL url=new URL("dubbo","localhost",8080,parameters);

        postMessage.sendMsg(url,"hello");
    }

    @Test
    public void test2(){
        String url="/Users/top1ms/Java/";
        File file=new File(url);

    }

    @Test
    public void test3(){
        ExtensionLoader<ProxyFactory> proxyFactoryExtensionLoader=ExtensionLoader.getExtensionLoader(ProxyFactory.class);
        ProxyFactory proxyFactory= proxyFactoryExtensionLoader.getDefaultExtension();

        Map<String, String> parameters =new HashMap<>();
        parameters.put("proxy","");
        URL url=new URL("dubbo","localhost",8080,parameters);
        Invoker<PostMessage> invoker1=proxyFactory.getInvoker(new PostMessageProvider(),PostMessage.class,url);
//        Invoker<PostMessage> invoker2=proxyFactory.getInvoker(new Pos(),PostMessage.class,url);

        ExtensionLoader<Protocol> protocolExtensionLoader=ExtensionLoader.getExtensionLoader(Protocol.class);
        Protocol adaptiveExtension = protocolExtensionLoader.getExtension("dubbo");


        Exporter<PostMessage> export = adaptiveExtension.export(invoker1);
        System.out.println("1");


    }
}
